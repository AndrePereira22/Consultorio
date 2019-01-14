/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.modelos.Tarefa;
import br.com.fundamento.view.BuscarTarefa;
import br.com.fundamento.view.CadastroTarefas;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleTarefa implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroTarefas cadastroTarefas, ct;
    private BuscarTarefa buscarTarefa;
    private Tarefa t;
    private JButton btn1, btn2;
    private List<Tarefa> tarefas;
    IFachada fachada1 = Fachada.getInstance();

    public ControleTarefa(TelaPrincipal telaPrincipal, CadastroTarefas cadastroTarefas, BuscarTarefa buscarTarefa) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroTarefas = cadastroTarefas;
        this.buscarTarefa = buscarTarefa;
        ct = new CadastroTarefas();

        telaPrincipal.getBotaoCadastrarTarefa().addActionListener(this);
        cadastroTarefas.getBotaoCancelarTarefa().addActionListener(this);
        cadastroTarefas.getBotaoSalvarTarefa().addActionListener(this);
        buscarTarefa.getBotaoAdicionarTarefa().addActionListener(this);
        buscarTarefa.getBotaoFecharTarefa().addActionListener(this);
        buscarTarefa.getTabelaTarefa().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = buscarTarefa.getTabelaTarefa().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarTarefa.getTabelaTarefa().getRowHeight();

                if (row < buscarTarefa.getTabelaTarefa().getRowCount() && row >= 0 && column < buscarTarefa.getTabelaTarefa().getColumnCount() && column >= 0) {
                    Object value = buscarTarefa.getTabelaTarefa().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarTarefa.getTabelaTarefa().getSelectedRow();
                            if (editar == 0) {
                                ct = new CadastroTarefas();
                                ct.getLabeltarefa().setText("ATUALIZAR TAREFA");
                                ct.setVisible(true);
                                buscarTarefa.setVisible(false);
                                if (ct == null) {
                                    ct = new CadastroTarefas();
                                }
                                t = tarefas.get(ro);
                                preencherCadastro(t, ct);
                                try {
                                    ct.getBotaoSalvarTarefa().addActionListener(new Acaoupdate());
                                    ct.getBotaoCancelarTarefa().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            ct.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            buscarTarefa.setVisible(true);
                                            buscarTarefa.getTxtPesquisarTarefa().setText("");
                                            PreencherTabela();
                                            ct = null;
                                            t = null;

                                        }
                                    });

                                } catch (Exception ui) {
                                }
                            }
                        }
                        if (boton.getName().equals("e")) {

                            int editar = JOptionPane.showConfirmDialog(null, "Deseja eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

                            int ro = buscarTarefa.getTabelaTarefa().getSelectedRow();
                            if (editar == 0) {
                                t = tarefas.get(ro);

                                fachada1.ativarDesativarTarefa(t.getId());
                                PreencherTabela();
                            }

                        }
                    }

                    if (value instanceof JCheckBox) {
                        //((JCheckBox)value).doClick();
                        JCheckBox ch = (JCheckBox) value;
                        if (ch.isSelected() == true) {
                            ch.setSelected(false);
                        }
                        if (ch.isSelected() == false) {
                            ch.setSelected(true);
                        }
                    }
                }

            }

        });
        buscarTarefa.getTxtPesquisarTarefa().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                PreencherTabela();
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaPrincipal.getBotaoCadastrarTarefa()) {

            PreencherTabela();
            telaPrincipal.setEnabled(false);
            buscarTarefa.setVisible(true);
        }
        if (e.getSource() == buscarTarefa.getBotaoFecharTarefa()) {
            telaPrincipal.setEnabled(true);
            buscarTarefa.setVisible(false);
        }
        if (e.getSource() == buscarTarefa.getBotaoAdicionarTarefa()) {

            cadastroTarefas.setVisible(true);
            buscarTarefa.setVisible(false);
        }
        if (e.getSource() == cadastroTarefas.getBotaoCancelarTarefa()) {
            buscarTarefa.getTxtPesquisarTarefa().setText("");
            PreencherTabela();
            telaPrincipal.setEnabled(false);
            buscarTarefa.setVisible(true);
            cadastroTarefas.setVisible(false);
        }

        if (e.getSource() == cadastroTarefas.getBotaoSalvarTarefa()) {

            Tarefa tarefa = new Tarefa();
            tarefa.setData_inicio(cadastroTarefas.getTxtDatainicio().getText());
            tarefa.setData_termino(cadastroTarefas.getTxtdatafinal().getText());
            tarefa.setDescricao(cadastroTarefas.getTxtdescricao().getText());
          
            tarefa.setPrioridade(cadastroTarefas.getComboprioridade().getSelectedItem().toString());
            String s = cadastroTarefas.getTxtstatus().getSelectedItem().toString();
            boolean status = false;
            if (s.equalsIgnoreCase("Pronto")) {
                status = true;
            }
            tarefa.setStatus(status);

            fachada1.salvarTarefa(tarefa);

            buscarTarefa.getTxtPesquisarTarefa().setText("");
            PreencherTabela();
            buscarTarefa.setVisible(true);
            cadastroTarefas.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }

    public void PreencherTabela() {

        tarefas = fachada1.getPorBuscaTarefa(buscarTarefa.getTxtPesquisarTarefa().getText());

        buscarTarefa.getTabelaTarefa().setDefaultRenderer(Object.class, new Render());
       Icon editar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/editar.png"));
        Icon excluir = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/excluir.png"));
        
        JButton btn1 = new JButton(editar);
        btn1.setName("m");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        JButton btn2 = new JButton(excluir);
        btn2.setName("e");
        btn2.setBorder(null);
        btn2.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Descricao", "Prioridade", "Status", "Data Inicio", "Data Termino", "Editar", "Excluir"};
            Object[][] dados = new Object[tarefas.size()][7];
            String s = "Em Andamento";
            for (int i = 0; i < tarefas.size(); i++) {

                Tarefa tarefa = tarefas.get(i);
                if (tarefa.isStatus()) {
                    s = "Finalizado";
                }
                dados[i][0] = tarefa.getDescricao();
                dados[i][1] = tarefa.getPrioridade();
                dados[i][2] = s;
                dados[i][3] = tarefa.getData_inicio();
                dados[i][4] = tarefa.getData_termino();
                dados[i][5] = btn1;
                dados[i][6] = btn2;
                s = "Em Andamento";

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = buscarTarefa.getTabelaTarefa().getColumnModel();
            buscarTarefa.getTabelaTarefa().setModel(dataModel);
            buscarTarefa.getTabelaTarefa().setPreferredScrollableViewportSize(buscarTarefa.getTabelaTarefa().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    public void preencherCadastro(Tarefa t, CadastroTarefas ct) {

        ct.getTxtdescricao().setText(t.getDescricao());
        ct.getTxtDatainicio().setText(t.getData_inicio());
        ct.getTxtdatafinal().setText(t.getData_termino());
        for (int u = 0; u < ct.getComboprioridade().getItemCount(); u++) {

            if (ct.getComboprioridade().getItemAt(u).equals(t.getPrioridade())) {
                ct.getComboprioridade().setSelectedItem(ct.getComboprioridade().getItemAt(u));
            }
        }
        for (int u = 0; u < ct.getTxtstatus().getItemCount(); u++) {

            if (ct.getTxtstatus().getItemAt(u).equals(t.isStatus())) {
                ct.getTxtstatus().setSelectedItem(ct.getTxtstatus().getItemAt(u));
            }
        }
    }

    public class Acaoupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == ct.getBotaoSalvarTarefa()) {
                Tarefa tarefa = t;

                tarefa.setDescricao(ct.getTxtdescricao().getText());
                tarefa.setData_termino(ct.getTxtdatafinal().getText());
                tarefa.setPrioridade(ct.getComboprioridade().getSelectedItem().toString());

                String s = ct.getTxtstatus().getSelectedItem().toString();

                if (s.equalsIgnoreCase("Pronto")) {
                    tarefa.setStatus(true);
                } else {
                    tarefa.setStatus(false);
                }

                fachada1.editarTarefa(tarefa);
                buscarTarefa.getTxtPesquisarTarefa().setText("");
                PreencherTabela();
                ct.setVisible(false);
                telaPrincipal.setVisible(true);
                buscarTarefa.setVisible(true);
                ct = null;
                t = null;
            }
        }

    }
}
