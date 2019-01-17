/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoConsulta;
import br.com.fundamento.dao.DaoFuncionario;
import br.com.fundamento.dao.DaoMedico;
import br.com.fundamento.dao.DaoProntuario;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.Historico;
import br.com.fundamento.view.ListaConsulta;
import br.com.fundamento.view.TelaProntuario;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.view.AtualizarConsultorio;
import br.com.fundamento.view.Receita_Exames;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private static Funcionario funcionario;
    private static Medico medico;
   private AtualizarConsultorio atualizarConsultorio;
    private static String login = "", password = "";
    private List<Consulta> consultas;
    private Paciente paciente;
    private Receita_Exames receita_Exames;
    private List<Prontuario> prontuarios;
    private Prontuario prontuario;
    private JButton btn1, btn2;

    IFachada fachada1 = Fachada.getInstance();

    public ControlePrincipal(TelaPrincipal telaPrincipal, TelaLogin telaLogin, ListaConsulta Liconsulta, TelaProntuario telaprontuario, Historico historico, AtualizarConsultorio atualizarConsultorio, Receita_Exames receita_Exames) {
        this.telaPrincipal = telaPrincipal;
        this.telaLogin = telaLogin;
        this.Liconsulta = Liconsulta;
        this.telaprontuario = telaprontuario;
        this.historico = historico;
        this.atualizarConsultorio = atualizarConsultorio;
        this.receita_Exames = receita_Exames;

        telaPrincipal.getBotaoAtualizardados().addActionListener(this);
        telaLogin.setVisible(true);
        telaprontuario.getBotaoexames().addActionListener(this);
        telaprontuario.getBotaoreceita().addActionListener(this);
        atualizarConsultorio.getBotaoCancelarrConsultorio().addActionListener(this);
        atualizarConsultorio.getBotaoSalvarConsultorio().addActionListener(this);
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
        historico.getBotaoeditar().addActionListener(this);
        historico.getBotaoatualizar().addActionListener(this);
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

                            int atender = JOptionPane.showConfirmDialog(null, "Deseja atender este paciente", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = Liconsulta.getTabelalistaPaciente().getSelectedRow();
                            if (atender == 0) {

                                paciente = consultas.get(ro).getPaciente();

                                telaprontuario.setVisible(true);
                                Liconsulta.setVisible(false);
                                telaprontuario.getTxtoExames().setText("");
                                telaprontuario.getTxtoReceita().setText("");
                                telaprontuario.getSintomas().setText("");

                            }

                        }
                        if (boton.getName().equals("h")) {
                            int history = JOptionPane.showConfirmDialog(null, "Deseja ver o Historico", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = Liconsulta.getTabelalistaPaciente().getSelectedRow();
                            if (history == 0) {

                                paciente = consultas.get(ro).getPaciente();
                                preenchertabelaHistorio();
                                historico.setVisible(true);
                                Liconsulta.setVisible(false);
                                historico.getTextdata().setEditable(false);
                                historico.getTextexames().setEditable(false);
                                historico.getTextreceita().setEditable(false);
                                historico.getTxtsintomas().setEditable(false);
                                historico.getBotaoatualizar().setVisible(false);
                                historico.getBotaoeditar().setVisible(false);

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
        historico.getTabelahistorico().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = historico.getTabelahistorico().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / historico.getTabelahistorico().getRowHeight();

                if (row < historico.getTabelahistorico().getRowCount() && row >= 0 && column < historico.getTabelahistorico().getColumnCount() && column >= 0) {
                    Object value = historico.getTabelahistorico().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("d")) {
                            int atender = JOptionPane.showConfirmDialog(null, "Deseja ver detalhes", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = historico.getTabelahistorico().getSelectedRow();
                            if (atender == 0) {
                                prontuario = prontuarios.get(ro);
                                preencherDetalhes();
                                historico.getBotaoeditar().setVisible(true);

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
         this.Liconsulta.getCalendariopaciente().getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                preenchertabela();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAtualizardados()) {
            atualizarConsultorio.setVisible(true);

            try {

                Consultorio c = fachada1.bucarConsultorio();

                atualizarConsultorio.getTxtnomefantasia().setText(c.getNome_fantasia());
                atualizarConsultorio.getTxtcnpj().setText(c.getCnpj());
                atualizarConsultorio.getTxtrazao().setText(c.getRazao_social());

                atualizarConsultorio.getTxtrua().setText(c.getEndereco().getRua());
                atualizarConsultorio.getTxtbairro().setText(c.getEndereco().getBairro());
                atualizarConsultorio.getTxtcep().setText(c.getEndereco().getCep());
                atualizarConsultorio.getTxtnumero().setText(c.getEndereco().getNumero());
                atualizarConsultorio.getTxtcidade().setText(c.getEndereco().getMunicipio());

                for (int u = 0; u < atualizarConsultorio.getTxtUf().getItemCount(); u++) {

                    if (atualizarConsultorio.getTxtUf().getItemAt(u).equals(c.getEndereco().getEstado())) {
                        atualizarConsultorio.getTxtUf().setSelectedItem(atualizarConsultorio.getTxtUf().getItemAt(u));
                    }
                }

                atualizarConsultorio.getTxtemail().setText(c.getContato().getEmail());
                atualizarConsultorio.getTxtcelular().setText(c.getContato().getCelular());
                atualizarConsultorio.getTxttelefone().setText(c.getContato().getTelefone());
            } catch (Exception p) {
            }

        }

        if (e.getSource() == historico.getBotaoeditar()) {

            historico.getTextexames().setEditable(true);
            historico.getTextreceita().setEditable(true);
            historico.getTxtsintomas().setEditable(true);
            historico.getBotaoatualizar().setVisible(true);
            historico.getBotaoeditar().setVisible(false);
        }
        if (e.getSource() == historico.getBotaoatualizar()) {

            prontuario.setExames(historico.getTextexames().getText());
            prontuario.setReceitas(historico.getTextreceita().getText());
            prontuario.setSintomas(historico.getTxtsintomas().getText());
            fachada1.editarProntuario(prontuario);

            historico.getBotaoatualizar().setVisible(false);
            preenchertabelaHistorio();
        }

        if (e.getSource() == telaprontuario.getBotaoCancelarProntuario()) {
            telaprontuario.setVisible(false);
            Liconsulta.setVisible(true);
        }
        if (e.getSource() == telaprontuario.getBotaoSalvarProntuario()) {

            Paciente p = paciente;

            List<Prontuario> list = new ArrayList<Prontuario>();

            Prontuario pron = new Prontuario();
            pron.setExames(telaprontuario.getTxtoExames().getText());
            pron.setReceitas(telaprontuario.getTxtoReceita().getText());
            pron.setSintomas(telaprontuario.getSintomas().getText());
            java.util.Date d = new Date();
            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            pron.setData(dStr);

            list.add(pron);

            p.setProntuarios(list);

            fachada1.editarPaciente(p);
            telaprontuario.setVisible(false);
            Liconsulta.setVisible(true);

        }

        if (e.getSource() == telaPrincipal.getBotaolist()) {
            Liconsulta.setVisible(true);
            preenchertabela();
        }
        if (e.getSource() == Liconsulta.getBotaoFechar()) {
            Liconsulta.setVisible(false);
        }
          if (e.getSource() == atualizarConsultorio.getBotaoCancelarrConsultorio()) {
            atualizarConsultorio.setVisible(false);
        }
        if (e.getSource() == atualizarConsultorio.getBotaoSalvarConsultorio()) {

            Consultorio consultori = fachada1.buscarConsultorioPorId(1);
            if (consultori == null) {
                criarConsultorio();
            } else {
                Endereco end = consultori.getEndereco();

                end.setBairro(atualizarConsultorio.getTxtbairro().getText());
                end.setRua(atualizarConsultorio.getTxtrua().getText());
                end.setCep(atualizarConsultorio.getTxtcep().getText());
                end.setNumero(atualizarConsultorio.getTxtnumero().getText());
                end.setEstado(atualizarConsultorio.getTxtUf().getSelectedItem().toString());
                end.setMunicipio(atualizarConsultorio.getTxtcidade().getText());
                Contato con = consultori.getContato();

                con.setEmail(atualizarConsultorio.getTxtemail().getText());
                con.setCelular(atualizarConsultorio.getTxtcelular().getText());
                con.setTelefone(atualizarConsultorio.getTxttelefone().getText());
                consultori.setEndereco(end);
                consultori.setContato(con);
                consultori.setCnpj(atualizarConsultorio.getTxtcnpj().getText());
                consultori.setNome_fantasia(atualizarConsultorio.getTxtnomefantasia().getText());
                consultori.setRazao_social(atualizarConsultorio.getTxtrazao().getText());
                consultori.setMedicos(new ArrayList<Medico>());

                fachada1.editarConsultorio(consultori);
                atualizarConsultorio.setVisible(false);
            }
        }
        if (e.getSource() == telaLogin.getEntrar()) {
           validarLogin();

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
            historico.getTextdata().setText("");
            historico.getTextexames().setText("");
            historico.getTextreceita().setText("");
            historico.getTxtsintomas().setText("");

        }

        if (e.getSource() == telaPrincipal.getBotaoSair()) {
            System.exit(0);
        }
        if (e.getSource() == telaLogin.getCancelarLogin()) {
            System.exit(0);
        }
        if (e.getSource() == telaprontuario.getBotaoexames()) {
            if (telaprontuario.getTxtoExames().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Exame vazia");
            } else {

                java.util.Date d = new Date();
                String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

                receita_Exames.getNome().setText(telaprontuario.getTxtpaciente().getText());
                receita_Exames.getData().setText(dStr);
                receita_Exames.getTexto().setText(telaprontuario.getTxtoExames().getText());
                printExames();
            }
        }
        if (e.getSource() == telaprontuario.getBotaoreceita()) {
            if (telaprontuario.getTxtoReceita().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Receita vazia");
            } else {

                java.util.Date d = new Date();
                String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

                receita_Exames.getNome().setText(telaprontuario.getTxtpaciente().getText());
                receita_Exames.getData().setText(dStr);
                receita_Exames.getTexto().setText(telaprontuario.getTxtoReceita().getText());
                printReceita();
            }
        }

    }

    public void criarConsultorio() {

        Consultorio consultori = new Consultorio();
        Endereco end = new Endereco();

        end.setBairro(atualizarConsultorio.getTxtbairro().getText());
        end.setRua(atualizarConsultorio.getTxtrua().getText());
        end.setCep(atualizarConsultorio.getTxtcep().getText());
        end.setNumero(atualizarConsultorio.getTxtnumero().getText());
        end.setEstado(atualizarConsultorio.getTxtUf().getSelectedItem().toString());
        end.setMunicipio(atualizarConsultorio.getTxtcidade().getText());
        Contato con = new Contato();

        con.setEmail(atualizarConsultorio.getTxtemail().getText());
        con.setCelular(atualizarConsultorio.getTxtcelular().getText());
        con.setTelefone(atualizarConsultorio.getTxttelefone().getText());
        consultori.setEndereco(end);
        consultori.setContato(con);
        consultori.setCnpj(atualizarConsultorio.getTxtcnpj().getText());
        consultori.setNome_fantasia(atualizarConsultorio.getTxtnomefantasia().getText());
        consultori.setRazao_social(atualizarConsultorio.getTxtrazao().getText());
        consultori.setMedicos(new ArrayList<Medico>());

        fachada1.salvarConsultorio(consultori);
        atualizarConsultorio.setVisible(false);

    }

    public void preenchertabela() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String busca = formato.format(Liconsulta.getCalendariopaciente().getDate());
        int i = 0;
        consultas = new DaoConsulta().BuscaConsultadoMedico(medico.getNome(), busca);
        Liconsulta.getTabelalistaPaciente().setDefaultRenderer(Object.class, new Render());
        Icon atender = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/atender.png"));
        Icon historico = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/historico.png"));

        btn1 = new JButton(atender);
        btn1.setName("a");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        btn2 = new JButton(historico);
        btn2.setName("h");
        btn2.setBorder(null);
        btn2.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Hora", "Tipo", "Paciente", "Atender", "Historico"};
            Object[][] dados = new Object[consultas.size()][5];
            for (Consulta c : consultas) {

                telaprontuario.getTxtpaciente().setText(c.getPaciente().getNome());
                dados[i][0] = c.getHora();
                dados[i][1] = c.getTipo();
                dados[i][2] = c.getPaciente().getNome();
                dados[i][3] = btn1;
                dados[i][4] = btn2;

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

    public void preenchertabelaHistorio() {

        int i = 0;
        prontuarios = new DaoProntuario().ProntuariosPaciente(paciente.getId());
        historico.getTabelahistorico().setDefaultRenderer(Object.class, new Render());
        Icon atender = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/detalhes.png"));

        JButton btn1 = new JButton(atender);
        btn1.setName("d");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Data", "Sintomas", "Exames", "Receitas", "Detallhe"};
            Object[][] dados = new Object[prontuarios.size()][5];
            for (Prontuario p : prontuarios) {

                dados[i][0] = p.getData();
                dados[i][1] = p.getSintomas();
                dados[i][2] = p.getExames();
                dados[i][3] = p.getReceitas();
                dados[i][4] = btn1;
                i++;
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = historico.getTabelahistorico().getColumnModel();
            historico.getTabelahistorico().setModel(dataModel);
            historico.getTabelahistorico().setPreferredScrollableViewportSize(historico.getTabelahistorico().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    public void criarFuncionario(String login, String senha) {

        Funcionario funcionario = new DaoFuncionario().buscarFuncionario(login, senha);

        ControleConsulta.setFuncionario(funcionario);
        Icon fun = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/funcionario.png"));

        telaPrincipal.getImagem().setIcon(fun);
        telaPrincipal.getImagem().setText(funcionario.getNome());

    }

    public void criarMedico(String login, String senha) {

        medico = new DaoMedico().buscarMedico(login, senha);
        Icon medicou = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/medico.png"));

        telaPrincipal.getImagem().setIcon(medicou);
        telaPrincipal.getImagem().setText(medico.getNome());

    }

    public void preencherDetalhes() {

        historico.getTextdata().setText(prontuario.getData());
        historico.getTextexames().setText(prontuario.getExames());
        historico.getTextreceita().setText(prontuario.getReceitas());
        historico.getTxtsintomas().setText(prontuario.getSintomas());

    }

    public void printReceita() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Exames ");
        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                receita_Exames.getPanelR_E().paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false) {
            return;
        }
        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }

    public void printExames() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Exames ");
        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                receita_Exames.getPanelR_E().paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if (pj.printDialog() == false) {
            return;
        }
        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }

    public void validarLogin(){
         Login loginF = null, loginM = null;

            String senha = new String(telaLogin.getTextsenha().getPassword());
            try {
                loginF = fachada1.buscarLogin(telaLogin.getTextlogin().getText());
                loginM = fachada1.buscarLoginMedico("l.usuario", telaLogin.getTextlogin().getText());
                if (loginF.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginF.getSenha().equals(senha)) {

                    password = senha;
                    login = telaLogin.getTextlogin().getText();

                    telaPrincipal.getBotaolist().setVisible(false);
                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                    criarFuncionario(login, password);
                    telaPrincipal.getPanelP().setEnabledAt(1, true);
                    telaPrincipal.getPanelP().setEnabledAt(2, true);
                    telaPrincipal.getPanelP().setEnabledAt(3, true);
                    telaPrincipal.getPanelP().setEnabledAt(4, true);
                    telaPrincipal.getBotaoCadastroPaciente().setVisible(true);
                    telaPrincipal.getBotaoMedico().setVisible(true);
                    telaPrincipal.getBotaoCadastroFuncionario().setVisible(true);
                    telaPrincipal.getBotaoCadastrarTarefa().setVisible(true);
                    telaPrincipal.getBotaoAgendamento().setVisible(true);
                    telaPrincipal.getBotaolist().setVisible(false);

                }
            } catch (Exception a) {
            }

            try {
                if (loginM.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginM.getSenha().equals(senha)) {

                    password = senha;
                    login = telaLogin.getTextlogin().getText();

                    telaPrincipal.getBotaolist().setVisible(false);
                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                    criarMedico(login, password);

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
             if (telaLogin.getTextlogin().getText().equals("admin") && senha.equals("admin")) {

                   

                    telaPrincipal.getBotaolist().setVisible(false);
                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                    telaPrincipal.getPanelP().setEnabledAt(1, false);
                    telaPrincipal.getBotaoCadastroPaciente().setVisible(true);
                    telaPrincipal.getBotaoMedico().setVisible(true);
                    telaPrincipal.getBotaoCadastroFuncionario().setVisible(true);
                    telaPrincipal.getBotaoCadastrarTarefa().setVisible(true);
                    telaPrincipal.getBotaoAgendamento().setVisible(false);
                    telaPrincipal.getBotaolist().setVisible(false);

                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                }
            if (telaLogin.isVisible()) {
                JOptionPane.showMessageDialog(null, "Usuario não existe");
            }
    }
}
