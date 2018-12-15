/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.CommumDao;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.BuscarMedico;
import br.com.fundamento.view.CadastroMedico;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleMedico implements ActionListener {

    private TelaPrincipal telaPrincipal;
    CadastroMedico cadastroMedico, cm;
    BuscarMedico buscarMedico;
    JButton btn1, btn2;
    private Medico m;
    private List<Medico> medicos;
    IFachada fachada1 = Fachada.getInstance();

    public ControleMedico(TelaPrincipal telaPrincipal, CadastroMedico cadastroMedico, BuscarMedico buscarMedico) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroMedico = cadastroMedico;
        this.buscarMedico = buscarMedico;

        telaPrincipal.getBotaoMedico().addActionListener(this);
        buscarMedico.getBotaoFecharMedico().addActionListener(this);
        buscarMedico.getBotaoAdicionarMedico().addActionListener(this);
        cadastroMedico.getBotaoCancelarMedico().addActionListener(this);
        cadastroMedico.getBotaoSalvarMedico().addActionListener(this);
        cadastroMedico.getBotaoSelecionar().addActionListener(this);
        buscarMedico.getTabelaMedico().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = buscarMedico.getTabelaMedico().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarMedico.getTabelaMedico().getRowHeight();

                if (row < buscarMedico.getTabelaMedico().getRowCount() && row >= 0 && column < buscarMedico.getTabelaMedico().getColumnCount() && column >= 0) {
                    Object value = buscarMedico.getTabelaMedico().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarMedico.getTabelaMedico().getSelectedRow();
                            if (editar == 0) {
                                cm = new CadastroMedico();
                                cm.getLabelmedico().setText("ATUALIZAR MEDICO");
                                cm.setVisible(true);
                                buscarMedico.setVisible(false);

                                m = medicos.get(ro);

                                preencherCadastro(m, cm);
                                try {
                                    cm.getBotaoSalvarMedico().addActionListener(new Acaoupdate());
                                    cm.getBotaoCancelarMedico().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            cm.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            buscarMedico.setVisible(true);
                                            buscarMedico.getTxtPesquisarMedico().setText("");
                                            preenchertabela();
                                            cm = null;
                                            m = null;

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
        buscarMedico.getTxtPesquisarMedico().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                preenchertabela();
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoMedico()) {
            preenchertabela();

            telaPrincipal.setEnabled(false);
            buscarMedico.setVisible(true);
        }
        if (e.getSource() == buscarMedico.getBotaoFecharMedico()) {
            telaPrincipal.setEnabled(true);
            buscarMedico.setVisible(false);
        }
        if (e.getSource() == buscarMedico.getBotaoAdicionarMedico()) {

            cadastroMedico.setVisible(true);
            buscarMedico.setVisible(false);
        }
        if (e.getSource() == cadastroMedico.getBotaoCancelarMedico()) {
            buscarMedico.getTxtPesquisarMedico().setText("");
            preenchertabela();
            buscarMedico.setVisible(true);
            cadastroMedico.setVisible(false);
        }

        if (e.getSource() == cadastroMedico.getBotaoSalvarMedico()) {

            Endereco end = new Endereco();
            end.setBairro(cadastroMedico.getTxtbairro().getText());
            end.setRua(cadastroMedico.getTxtrua().getText());
            end.setCep(cadastroMedico.getTxtcep().getText());
            end.setNumero(cadastroMedico.getTxtnumero().getText());
            end.setMunicipio(cadastroMedico.getTxtcidade().getText());
            end.setEstado(cadastroMedico.getTxtUf().getSelectedItem().toString());

            Contato con = new Contato();
            con.setEmail(cadastroMedico.getTxtemail().getText());
            con.setCelular(cadastroMedico.getTxtcelular().getText());
            con.setTelefone(cadastroMedico.getTxttelefone().getText());

            Consultorio c = fachada1.bucarConsultorio();
            Endereco endConsultorio = CommumDao.buscarEndereco("consultorio", "nome_fantasia", c.getNome_fantasia());
            Contato t = CommumDao.bucarContato("consultorio", "nome_fantasia", c.getNome_fantasia());

            c.setMedicos(new ArrayList<Medico>());
            c.setEndereco(endConsultorio);
            c.setContato(t);

            Login l = new Login();
            String senha = new String(cadastroMedico.getTxtsenha1().getPassword());
            l.setSenha(senha);
            l.setUsuario(cadastroMedico.getTxtlogin1().getText());

            List<Especializacao> especializacoes = new ArrayList<Especializacao>();

            Especializacao es = new Especializacao();
            es.setDescricao(cadastroMedico.getTxtEspecializacao().getText());
            String sa = cadastroMedico.getTxtsalario1().getText();
            sa = sa.replaceAll("[^0-9]", "");
            double salario = 0;
            try {
                salario = Double.parseDouble(sa);

            } catch (NumberFormatException erro) {
            }
            es.setSalario(salario);
            es.setHorario_disponivel(cadastroMedico.getTxthorario().getText());
            especializacoes.add(es);

            Medico medico = new Medico();
            medico.setConsultas(new ArrayList<Consulta>());
            medico.setEspecializacoes(especializacoes);
            medico.setContato(con);
            medico.setEndereco(end);
            medico.setConsultorio(c);
            medico.setLogin(l);
            medico.setCpf(cadastroMedico.getTxtcpf().getText());
            java.util.Date d = new Date();

            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

            medico.setData_cadastro(dStr);
            medico.setData_nascimento(cadastroMedico.getTxtdata().getText());
            medico.setNome(cadastroMedico.getTxtnome().getText());
            String rg = cadastroMedico.getTxtrg().getText();
            rg = rg.replaceAll("[^0-9]", "");
            int RG = Integer.parseInt(rg);
            medico.setRg(RG);
            medico.setSexo(cadastroMedico.getjComboBox1().getSelectedItem().toString());

            String confirmarSenha = new String(cadastroMedico.getTxtconfirmasenha1().getPassword());

            if (senha.equals(confirmarSenha)) {

                fachada1.salvarMedico(medico);
                buscarMedico.getTxtPesquisarMedico().setText("")
                        
                        ;
                preenchertabela();
                buscarMedico.setVisible(true);
                cadastroMedico.setVisible(false);
                telaPrincipal.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Senha diferentes");
            }
        }

    }

    public void preenchertabela() {
        medicos = fachada1.getPorBuscaMedico(buscarMedico.getTxtPesquisarMedico().getText());
        buscarMedico.getTabelaMedico().setDefaultRenderer(Object.class, new Render());

        btn1 = new JButton("Modificar");
        btn1.setName("m");
        btn2 = new JButton("Eliminar");
        btn2.setName("e");

        try {
            String[] colunas = new String[]{"Nome", "Sexo", "Rg", "CPF", "Data Nascimento", "Data Cadastro", "E", "M"};
            Object[][] dados = new Object[medicos.size()][8];
            for (int i = 0; i < medicos.size(); i++) {
                Medico medico = medicos.get(i);
                dados[i][0] = medico.getNome();
                dados[i][1] = medico.getSexo();
                dados[i][2] = medico.getRg();
                dados[i][3] = medico.getCpf();
                dados[i][4] = medico.getData_nascimento();
                dados[i][5] = medico.getData_cadastro();
                dados[i][6] = btn1;
                dados[i][7] = btn2;

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarMedico.getTabelaMedico().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void preencherCadastro(Medico p, CadastroMedico cm) {

        cm.getTxtcep().setText(p.getEndereco().getCep());
        cm.getTxtbairro().setText(p.getEndereco().getBairro());
        cm.getTxtnumero().setText(p.getEndereco().getNumero());
        cm.getTxtcidade().setText(p.getEndereco().getMunicipio());
        cm.getTxtrua().setText(p.getEndereco().getRua());

        for (int u = 0; u < cm.getTxtUf().getItemCount(); u++) {

            if (cm.getTxtUf().getItemAt(u).equals(p.getEndereco().getEstado())) {
                cm.getTxtUf().setSelectedItem(cm.getTxtUf().getItemAt(u));
            }
        }

        cm.getTxtcelular().setText(p.getContato().getCelular());
        cm.getTxttelefone().setText(p.getContato().getTelefone());
        cm.getTxtemail().setText(p.getContato().getEmail());

        cm.getTxtcpf().setText(p.getCpf());
        cm.getTxtnome().setText(p.getNome());
        cm.getTxtrg().setText(p.getRg() + "");

        for (int u = 0; u < cm.getjComboBox1().getItemCount(); u++) {

            if (cm.getjComboBox1().getItemAt(u).equals(p.getSexo())) {
                cm.getjComboBox1().setSelectedItem(cm.getjComboBox1().getItemAt(u));
            }
        }

        cm.getTxtdata().setText(p.getData_nascimento());
        cm.getTxtlogin1().setText(p.getLogin().getUsuario());
        cm.getTxtsenha1().setText(p.getLogin().getSenha());
        cm.getTxtconfirmasenha1().setText(p.getLogin().getSenha());
    }

    public class Acaoupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cm.getBotaoSalvarMedico()) {
                
                Medico medico = m;
                
                
               medico.getEndereco().setBairro(cm.getTxtbairro().getText());
                medico.getEndereco() .setRua(cm.getTxtrua().getText());
                medico.getEndereco() .setCep(cm.getTxtcep().getText());
                medico.getEndereco() .setNumero(cm.getTxtnumero().getText());
                medico.getEndereco() .setMunicipio(cm.getTxtcidade().getText());
                medico.getEndereco() .setEstado(cm.getTxtUf().getSelectedItem().toString());
                medico.getContato().setEmail(cm.getTxtemail().getText());
                 medico.getContato().setCelular(cm.getTxtcelular().getText());
                 medico.getContato().setTelefone(cm.getTxttelefone().getText());
                String senha = new String(cm.getTxtsenha1().getPassword());
                 medico.getLogin().setSenha(senha);
                 
                 medico.getLogin().setUsuario(cm.getTxtlogin1().getText());

                String confirmarSenha = new String(cm.getTxtconfirmasenha1().getPassword());
                

                medico.setCpf(cm.getTxtcpf().getText());

                medico.setNome(cm.getTxtnome().getText());
                String rg = cm.getTxtrg().getText();
                rg = rg.replaceAll("[^0-9]", "");
                int RG = Integer.parseInt(rg);
                medico.setRg(RG);
                medico.setSexo(cm.getjComboBox1().getSelectedItem().toString());
                

                if (senha.equals(confirmarSenha)) {

                    fachada1.editarMedico(medico);
                    buscarMedico.getTxtPesquisarMedico().setText("");
                    buscarMedico.setVisible(true);
                    preenchertabela();
                    cm.setVisible(false);
                    cm = null;
                    m = null;

                } else {
                    JOptionPane.showMessageDialog(null, "Senha diferentes");
                }

            }

        }
    }

}
