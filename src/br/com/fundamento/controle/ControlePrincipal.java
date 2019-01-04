/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoFuncionario;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.Historico;
import br.com.fundamento.view.ListaConsulta;
import br.com.fundamento.view.TelaProntuario;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ControlePrincipal implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private TelaLogin telaLogin;
    private ListaConsulta Liconsulta;
    private TelaProntuario telaprontuario;
    private Historico historico;
    private static String login="",password="";

    IFachada fachada1 = Fachada.getInstance();

    public ControlePrincipal(TelaPrincipal telaPrincipal, TelaLogin telaLogin, ListaConsulta Liconsulta, TelaProntuario telaprontuario, Historico historico) {
        this.telaPrincipal = telaPrincipal;
        this.telaLogin = telaLogin;
        this.Liconsulta = Liconsulta;
        this.telaprontuario = telaprontuario;
        this.historico = historico;

        telaPrincipal.getBotaoAtualizardados().addActionListener(this);
        telaPrincipal.getBotaoCancelarrConsultorio().addActionListener(this);
        telaPrincipal.getBotaoSalvarConsultorio().addActionListener(this);
        telaLogin.setVisible(true);
        telaLogin.getEntrar().addActionListener(this);
        telaPrincipal.getBotaoSair().addActionListener(this);
        telaLogin.getCancelarLogin().addActionListener(this);
        telaPrincipal.getBotaoLogoff().addActionListener(this);
        telaPrincipal.getBotaoAgendamento().addActionListener(this);
        telaPrincipal.getBotaolist().addActionListener(this);
        Liconsulta.getBotaoFechar().addActionListener(this);
        telaprontuario.getBotaoCancelarProntuario().addActionListener(this);
        telaprontuario.getBotaoSalvarProntuario().addActionListener(this);
        historico.getBotaoFechar().addActionListener(this);
        Liconsulta.getTabelalistaPaciente().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = Liconsulta.getTabelalistaPaciente().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / Liconsulta.getTabelalistaPaciente().getRowHeight();

                if (row < Liconsulta.getTabelalistaPaciente().getRowCount() && row >= 0 && column < Liconsulta.getTabelalistaPaciente().getColumnCount() && column >= 0) {
                    Object value = Liconsulta.getTabelalistaPaciente().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("a")) {
                            JOptionPane.showConfirmDialog(null, "Deseja Atender este Paceinte,", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            telaprontuario.setVisible(true);
                            Liconsulta.setVisible(false);
                           telaprontuario.getTxtoExames().setText("");
                           telaprontuario.getTxtoReceita().setText("");
                           telaprontuario.getSintomas().setText("");

                        }
                        if (boton.getName().equals("h")) {
                            JOptionPane.showConfirmDialog(null, "Deseja ver o historico deste Paceinte,", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            historico.setVisible(true);
                            Liconsulta.setVisible(false);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAtualizardados()) {
            telaPrincipal.getPanelConsultorio().setVisible(true);

            try {

                Consultorio c = fachada1.bucarConsultorio();

                telaPrincipal.getTxtnomefantasia().setText(c.getNome_fantasia());
                telaPrincipal.getTxtcnpj().setText(c.getCnpj());
                telaPrincipal.getTxtrazao().setText(c.getRazao_social());

                telaPrincipal.getTxtrua().setText(c.getEndereco().getRua());
                telaPrincipal.getTxtbairro().setText(c.getEndereco().getBairro());
                telaPrincipal.getTxtcep().setText(c.getEndereco().getCep());
                telaPrincipal.getTxtnumero().setText(c.getEndereco().getNumero());
                telaPrincipal.getTxtcidade().setText(c.getEndereco().getMunicipio());

                for (int u = 0; u < telaPrincipal.getTxtUf().getItemCount(); u++) {

                    if (telaPrincipal.getTxtUf().getItemAt(u).equals(c.getEndereco().getEstado())) {
                        telaPrincipal.getTxtUf().setSelectedItem(telaPrincipal.getTxtUf().getItemAt(u));
                    }
                }

                telaPrincipal.getTxtemail().setText(c.getContato().getEmail());
                telaPrincipal.getTxtcelular().setText(c.getContato().getCelular());
                telaPrincipal.getTxttelefone().setText(c.getContato().getTelefone());
            } catch (Exception p) {
            }

        }

        if (e.getSource() == telaPrincipal.getBotaoCancelarrConsultorio()) {
            telaPrincipal.getPanelConsultorio().setVisible(false);
        }
        if (e.getSource() == telaprontuario.getBotaoCancelarProntuario()) {
            telaprontuario.setVisible(false);
            Liconsulta.setVisible(true);
        }
        if (e.getSource() == telaprontuario.getBotaoSalvarProntuario()) {
            Prontuario pron = new Prontuario();
            pron.setExames(telaprontuario.getTxtoExames().getText());
            pron.setReceitas(telaprontuario.getTxtoReceita().getText());
            pron.setSintomas(telaprontuario.getSintomas().getText());
            java.util.Date d = new Date();
            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            pron.setData(dStr);
            fachada1.salvarProntuario(pron);
             Liconsulta.setVisible(true);
        }

        if (e.getSource() == telaPrincipal.getBotaolist()) {
            Liconsulta.setVisible(true);
            preenchertabela();
        }
        if (e.getSource() == Liconsulta.getBotaoFechar()) {
            Liconsulta.setVisible(false);
        }
        if (e.getSource() == telaPrincipal.getBotaoSalvarConsultorio()) {

            Consultorio consultori = fachada1.buscarConsultorioPorId(1);
            if (consultori == null) {
                criarConsultorio();
            } else {
                Endereco end = consultori.getEndereco();

                end.setBairro(telaPrincipal.getTxtbairro().getText());
                end.setRua(telaPrincipal.getTxtrua().getText());
                end.setCep(telaPrincipal.getTxtcep().getText());
                end.setNumero(telaPrincipal.getTxtnumero().getText());
                end.setEstado(telaPrincipal.getTxtUf().getSelectedItem().toString());
                end.setMunicipio(telaPrincipal.getTxtcidade().getText());
                Contato con = consultori.getContato();

                con.setEmail(telaPrincipal.getTxtemail().getText());
                con.setCelular(telaPrincipal.getTxtcelular().getText());
                con.setTelefone(telaPrincipal.getTxttelefone().getText());
                consultori.setEndereco(end);
                consultori.setContato(con);
                consultori.setCnpj(telaPrincipal.getTxtcnpj().getText());
                consultori.setNome_fantasia(telaPrincipal.getTxtnomefantasia().getText());
                consultori.setRazao_social(telaPrincipal.getTxtrazao().getText());
                consultori.setMedicos(new ArrayList<Medico>());

                fachada1.editarConsultorio(consultori);
                telaPrincipal.getPanelConsultorio().setVisible(false);
            }
        }
        if (e.getSource() == telaLogin.getEntrar()) {
            Login loginF = null, loginM = null;

            String senha = new String(telaLogin.getTextsenha().getPassword());
            try {
                loginF = fachada1.buscarLogin(telaLogin.getTextlogin().getText());
                loginM = fachada1.buscarLoginMedico("l.usuario", telaLogin.getTextlogin().getText());
                if (loginF.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginF.getSenha().equals(senha)) {
                    
                    password=senha;
                    login = telaLogin.getTextlogin().getText();
                    
                    telaPrincipal.getBotaolist().setVisible(false);
                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                }
            } catch (Exception a) {
            }

            try {
                if (loginM.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginM.getSenha().equals(senha)) {

                    telaPrincipal.getPanelP().setEnabledAt(1, false);
                    telaPrincipal.getPanelP().setEnabledAt(2, false);
                    telaPrincipal.getPanelP().setEnabledAt(3, false);
                    telaPrincipal.getPanelP().setEnabledAt(4, false);
                    telaPrincipal.getBotaoCadastroPaciente().setVisible(false);
                    telaPrincipal.getBotaoMedico().setVisible(false);
                    telaPrincipal.getBotaoCadastroFuncionario().setVisible(false);
                    telaPrincipal.getBotaoCadastrarTarefa().setVisible(false);
                    telaPrincipal.getBotaoAgendamento().setVisible(false);
                    telaPrincipal.getBotaolist().setVisible(true);

                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                }
            } catch (Exception o) {
            }
            if (telaLogin.isVisible()) {
                JOptionPane.showMessageDialog(null, "Usuario não existe");
            }

        }

        if (e.getSource() == telaPrincipal.getBotaoLogoff()) {
            telaPrincipal.setVisible(false);
            telaLogin.getTextlogin().setText("");
            telaLogin.getTextsenha().setText("");
            telaLogin.setVisible(true);
            telaLogin.getTextlogin().grabFocus();

        }
        if (e.getSource() == historico.getBotaoFechar()) {
            historico.setVisible(false);
            Liconsulta.setVisible(true);

        }

        if (e.getSource() == telaPrincipal.getBotaoSair()) {
            System.exit(0);
        }
        if (e.getSource() == telaLogin.getCancelarLogin()) {
            System.exit(0);
        }

    }

   
    public void criarConsultorio() {

        Consultorio consultori = new Consultorio();
        Endereco end = new Endereco();

        end.setBairro(telaPrincipal.getTxtbairro().getText());
        end.setRua(telaPrincipal.getTxtrua().getText());
        end.setCep(telaPrincipal.getTxtcep().getText());
        end.setNumero(telaPrincipal.getTxtnumero().getText());
        end.setEstado(telaPrincipal.getTxtUf().getSelectedItem().toString());
        end.setMunicipio(telaPrincipal.getTxtcidade().getText());
        Contato con = new Contato();

        con.setEmail(telaPrincipal.getTxtemail().getText());
        con.setCelular(telaPrincipal.getTxtcelular().getText());
        con.setTelefone(telaPrincipal.getTxttelefone().getText());
        consultori.setEndereco(end);
        consultori.setContato(con);
        consultori.setCnpj(telaPrincipal.getTxtcnpj().getText());
        consultori.setNome_fantasia(telaPrincipal.getTxtnomefantasia().getText());
        consultori.setRazao_social(telaPrincipal.getTxtrazao().getText());
        consultori.setMedicos(new ArrayList<Medico>());

        fachada1.salvarConsultorio(consultori);
        telaPrincipal.getPanelConsultorio().setVisible(false);

    }

    public void preenchertabela() {

        java.util.Date d = new Date();
        int i = 0;
        List<Consulta> consultas = fachada1.getAllConsulta();
        Liconsulta.getTabelalistaPaciente().setDefaultRenderer(Object.class, new Render());
        Icon atender = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/user.png"));
        Icon historico = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/stats-2.png"));

        JButton btn1 = new JButton(atender);
        btn1.setName("a");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        JButton btn2 = new JButton(historico);
        btn2.setName("h");
        btn2.setBorder(null);
        btn2.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Hora", "Tipo", "Paciente", "Medico", "Data", "Atender", "Historico"};
            Object[][] dados = new Object[consultas.size()][7];
            for (Consulta c : consultas) {

                telaprontuario.getTxtpaciente().setText(c.getPaciente().getNome());
                dados[i][0] = c.getHora();
                dados[i][1] = c.getTipo();
                dados[i][2] = c.getPaciente().getNome();
                dados[i][3] = c.getMedico().getNome();
                dados[i][4] = c.getData();
                dados[i][5] = btn1;
                dados[i][6] = btn2;
                i++;
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = Liconsulta.getTabelalistaPaciente().getColumnModel();
            Liconsulta.getTabelalistaPaciente().setModel(dataModel);
            Liconsulta.getTabelalistaPaciente().setPreferredScrollableViewportSize(Liconsulta.getTabelalistaPaciente().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    /**
     * @return the login
     */
    public static String getLogin() {
        return login;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

}
