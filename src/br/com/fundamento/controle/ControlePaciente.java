package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.BuscarPaciente;
import br.com.fundamento.view.CadastroPaciente;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Glenda Alves de Lima
 */
public class ControlePaciente implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroPaciente cadastroPaciente, cp;
    private BuscarPaciente buscarPaciente;
    private JButton btn1, btn2;
    private List<Paciente> pacientes;
    private Paciente p;
    private IFachada fachada1 = Fachada.getInstance();

    public ControlePaciente(TelaPrincipal telaPrincipal, CadastroPaciente cadastroPaciente, BuscarPaciente buscarPaciente) {

        this.telaPrincipal = telaPrincipal;
        this.cadastroPaciente = cadastroPaciente;
        this.buscarPaciente = buscarPaciente;

        telaPrincipal.getBotaoCadastroPaciente().addActionListener(this);
        cadastroPaciente.getBotaoCancelarrPaciente().addActionListener(this);
        cadastroPaciente.getBotaoSalvarPaciente().addActionListener(this);
        cadastroPaciente.getBotaoSelecionarFotoPaciente().addActionListener(this);
        buscarPaciente.getBotaoAdicionarPaciente().addActionListener(this);
        buscarPaciente.getBotaoFecharPaciente().addActionListener(this);
        buscarPaciente.getTabelaPaciente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = buscarPaciente.getTabelaPaciente().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarPaciente.getTabelaPaciente().getRowHeight();

                if (row < buscarPaciente.getTabelaPaciente().getRowCount() && row >= 0 && column < buscarPaciente.getTabelaPaciente().getColumnCount() && column >= 0) {
                    Object value = buscarPaciente.getTabelaPaciente().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarPaciente.getTabelaPaciente().getSelectedRow();
                            if (editar == 0) {
                                cp = new CadastroPaciente();
                                cp.getLabelcadastro().setText("ATUALIZAR PACIENTE");
                                cp.setVisible(true);
                                buscarPaciente.setVisible(false);

                                p = pacientes.get(ro);
                                preencherCadastro(p, cp);
                                try {
                                    cp.getBotaoSalvarPaciente().addActionListener(new Acaoupdate());
                                    cp.getBotaoCancelarrPaciente().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            cp.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            buscarPaciente.setVisible(true);
                                            buscarPaciente.getTxtpesquisarPaciente().setText("");
                                            preencherbuscas();
                                            cp = null;
                                            p = null;

                                        }
                                    });

                                } catch (Exception ui) {
                                }
                            }
                        }
                        if (boton.getName().equals("e")) {
                            JOptionPane.showConfirmDialog(null, "Deseja eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

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

        buscarPaciente.getTxtpesquisarPaciente().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                preencherbuscas();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaPrincipal.getBotaoCadastroPaciente()) {
            preencherbuscas();
            telaPrincipal.setEnabled(false);
            buscarPaciente.setVisible(true);

        }
        if (e.getSource() == cadastroPaciente.getBotaoCancelarrPaciente()) {
            telaPrincipal.setEnabled(true);
            buscarPaciente.getTxtpesquisarPaciente().setText("");
            preencherbuscas();
            cadastroPaciente.setVisible(false);
            buscarPaciente.setVisible(true);

        }
        if (e.getSource() == buscarPaciente.getBotaoFecharPaciente()) {
            telaPrincipal.setEnabled(true);
            buscarPaciente.setVisible(false);

        }
        if (e.getSource() == buscarPaciente.getBotaoAdicionarPaciente()) {
            cadastroPaciente.setVisible(true);
            buscarPaciente.setVisible(false);

        }

        if (e.getSource() == cadastroPaciente.getBotaoSalvarPaciente()) {

            Endereco end = new Endereco();
            end.setBairro(cadastroPaciente.getTxtbairro().getText());
            end.setRua(cadastroPaciente.getTxtrua().getText());
            end.setCep(cadastroPaciente.getTxtCep().getText());
            end.setNumero(cadastroPaciente.getTxtnumero().getText());
            end.setMunicipio(cadastroPaciente.getTxtcidade().getText());
            end.setEstado(cadastroPaciente.getTxtUf().getSelectedItem().toString());

            Contato con = new Contato();
            con.setEmail(cadastroPaciente.getTxtemail2().getText());
            con.setCelular(cadastroPaciente.getTxtcelular2().getText());
            con.setTelefone(cadastroPaciente.getTxttelefone().getText());

            Prontuario p = new Prontuario();
            // p.setExames(exames);

            Paciente paciente = new Paciente();
            paciente.setNome(cadastroPaciente.getTxtNome().getText());
            String rg = cadastroPaciente.getTxtrg().getText();
            rg = rg.replaceAll("[^0-9]", "");
            int RG = 0;
            try {
                RG = Integer.parseInt(rg);
                paciente.setRg(RG);

            } catch (NumberFormatException erro) {
            }

            java.util.Date d = new Date();

            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

            paciente.setData_cadastro(dStr);
            paciente.setCpf(cadastroPaciente.getTxtCpf().getText());
            paciente.setSexo(cadastroPaciente.getCombosexo().getSelectedItem().toString());
            paciente.setConvenio(cadastroPaciente.getTxtConvenio().getText());
            paciente.setProntuario(p);
            paciente.setEndereco(end);
            paciente.setContato(con);
            paciente.setConsultas(new ArrayList<Consulta>());
            paciente.setData_nascimento(cadastroPaciente.getTxtdata().getText());

            fachada1.salvarPaciente(paciente);
            buscarPaciente.getTxtpesquisarPaciente().setText("");
            preencherbuscas();
            telaPrincipal.setEnabled(true);
            cadastroPaciente.setVisible(false);
            buscarPaciente.setVisible(true);

        }
    }

    public void preencherbuscas() {
        pacientes = fachada1.getPorBusca(buscarPaciente.getTxtpesquisarPaciente().getText());

        buscarPaciente.getTabelaPaciente().setDefaultRenderer(Object.class, new Render());
        btn1 = new JButton("modificar");
        //btn1.setIcon(new ImageIcon("br.com.fundamento.resource/pencil.png"));
        btn1.setName("m");
        btn2 = new JButton("Eliminar");
        btn2.setName("e");

        try {
            String[] colunas = new String[]{"Nome", "CPF", "Sexo", "Data Nascimento", "Data Cadastro", "Rg", "Convenio", "E", "M"};
            Object[][] dados = new Object[pacientes.size()][9];
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente paciente = pacientes.get(i);
                dados[i][0] = paciente.getNome();
                dados[i][1] = paciente.getCpf();
                dados[i][2] = paciente.getSexo();
                dados[i][3] = paciente.getData_nascimento();
                dados[i][4] = paciente.getData_cadastro();
                dados[i][5] = paciente.getRg();
                dados[i][6] = paciente.getConvenio();
                dados[i][7] = btn1;
                dados[i][8] = btn2;

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarPaciente.getTabelaPaciente().setModel(dataModel);
        } catch (Exception erro) {

        }

    }

    public void preencherCadastro(Paciente p, CadastroPaciente cp) {

        cp.getTxtCep().setText(p.getEndereco().getCep());
        cp.getTxtbairro().setText(p.getEndereco().getBairro());
        cp.getTxtnumero().setText(p.getEndereco().getNumero());
        cp.getTxtcidade().setText(p.getEndereco().getMunicipio());
        cp.getTxtrua().setText(p.getEndereco().getRua());

        for (int u = 0; u < cp.getTxtUf().getItemCount(); u++) {

            if (cp.getTxtUf().getItemAt(u).equals(p.getEndereco().getEstado())) {
                cp.getTxtUf().setSelectedItem(cp.getTxtUf().getItemAt(u));
            }
        }

        cp.getTxtcelular2().setText(p.getContato().getCelular());
        cp.getTxttelefone2().setText(p.getContato().getTelefone());
        cp.getTxtemail2().setText(p.getContato().getEmail());

        cp.getTxtCpf().setText(p.getCpf());
        cp.getTxtNome().setText(p.getNome());
        cp.getTxtrg().setText(p.getRg() + "");

        for (int u = 0; u < cp.getCombosexo().getItemCount(); u++) {

            if (cp.getCombosexo().getItemAt(u).equals(p.getSexo())) {
                cp.getCombosexo().setSelectedItem(cp.getCombosexo().getItemAt(u));
            }
        }

        cp.getTxtdata().setText(p.getData_nascimento());
        cp.getTxtConvenio().setText(p.getConvenio());
    }

    public class Acaoupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cp.getBotaoSalvarPaciente()) {
                Paciente paciente = p;

                paciente.getEndereco().setBairro(cp.getTxtbairro().getText());
                paciente.getEndereco().setRua(cp.getTxtrua().getText());
                paciente.getEndereco().setCep(cp.getTxtCep().getText());
                paciente.getEndereco().setNumero(cp.getTxtnumero().getText());
                paciente.getEndereco().setMunicipio(cp.getTxtcidade().getText());
                paciente.getEndereco().setEstado(cp.getTxtUf().getSelectedItem().toString());
                paciente.getContato().setEmail(cp.getTxtemail2().getText());
                paciente.getContato().setCelular(cp.getTxtcelular2().getText());
                paciente.getContato().setTelefone(cp.getTxttelefone2().getText());
                paciente.setNome(cp.getTxtNome().getText());
                paciente.setCpf(cp.getTxtCpf().getText());
                paciente.setConvenio(cp.getTxtConvenio().getText());

                String rg = cp.getTxtrg().getText();
                rg = rg.replaceAll("[^0-9]", "");
                int RG = 0;
                try {
                    RG = Integer.parseInt(rg);
                    paciente.setRg(RG);

                } catch (NumberFormatException erro) {
                }
                

                fachada1.editarPaciente(paciente);
                buscarPaciente.getTxtpesquisarPaciente().setText("");
                preencherbuscas();
                cp.setVisible(false);
                telaPrincipal.setVisible(true);
                buscarPaciente.setVisible(true);
                cp = null;
                p = null;
            }
        }

    }
}
