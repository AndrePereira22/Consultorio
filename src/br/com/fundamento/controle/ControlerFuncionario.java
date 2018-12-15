/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.BuscarFuncionario;
import br.com.fundamento.view.CadastroFuncionario;
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

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControlerFuncionario implements ActionListener {

    private CadastroFuncionario cadastroFuncionario, cf;
    private TelaPrincipal telaPrincipal;
    private BuscarFuncionario buscarFuncionario;
    private JButton btn1, btn2;
    private Funcionario f;
    private List<Funcionario> funcionarios;

    IFachada fachada1 = Fachada.getInstance();

    public ControlerFuncionario(CadastroFuncionario cadastroFuncionario, TelaPrincipal telaPrincipal, BuscarFuncionario buscarFuncionario) {

        this.cadastroFuncionario = cadastroFuncionario;
        this.telaPrincipal = telaPrincipal;
        this.buscarFuncionario = buscarFuncionario;

        telaPrincipal.getBotaoCadastroFuncionario().addActionListener(this);
        cadastroFuncionario.getBotaocancelarFuncionario().addActionListener(this);
        cadastroFuncionario.getBotaosalvarFuncionario().addActionListener(this);
        buscarFuncionario.getBotaoAdicionarFuncionario().addActionListener(this);
        buscarFuncionario.getBotaoFecharFuncionario().addActionListener(this);
        buscarFuncionario.getTabelaFunionario().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = buscarFuncionario.getTabelaFunionario().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarFuncionario.getTabelaFunionario().getRowHeight();

                if (row < buscarFuncionario.getTabelaFunionario().getRowCount() && row >= 0 && column < buscarFuncionario.getTabelaFunionario().getColumnCount() && column >= 0) {
                    Object value = buscarFuncionario.getTabelaFunionario().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarFuncionario.getTabelaFunionario().getSelectedRow();
                            if (editar == 0) {
                                cf = new CadastroFuncionario();
                                cf.getLabelFucncionario().setText("ATUALIZAR FUNCIONARIO");
                                cf.setVisible(true);
                                buscarFuncionario.setVisible(false);

                                f = funcionarios.get(ro);
                                preencherCadastro(f, cf);
                                try {
                                    cf.getBotaosalvarFuncionario().addActionListener(new Acaoupdate());
                                    cf.getBotaocancelarFuncionario().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            cf.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            buscarFuncionario.setVisible(true);
                                            buscarFuncionario.getTxtPesquisar().setText("");
                                            preenchertabela();
                                            cf = null;
                                            f = null;

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
        buscarFuncionario.getTxtPesquisar().addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                preenchertabela();
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoCadastroFuncionario()) {

            preenchertabela();
            telaPrincipal.setEnabled(false);
            buscarFuncionario.setVisible(true);
        }
        if (e.getSource() == buscarFuncionario.getBotaoAdicionarFuncionario()) {
            cadastroFuncionario.setVisible(true);
            buscarFuncionario.setVisible(false);
        }
        if (e.getSource() == cadastroFuncionario.getBotaocancelarFuncionario()) {
            telaPrincipal.setEnabled(false);
            buscarFuncionario.getTxtPesquisar().setText("");
            preenchertabela();
            buscarFuncionario.setVisible(true);
            cadastroFuncionario.setVisible(false);

        }

        if (e.getSource() == buscarFuncionario.getBotaoFecharFuncionario()) {
            telaPrincipal.setEnabled(true);
            buscarFuncionario.setVisible(false);
        }
        if (e.getSource() == cadastroFuncionario.getBotaosalvarFuncionario()) {

            Endereco end = new Endereco();
            end.setBairro(cadastroFuncionario.getTxtbairro().getText());
            end.setRua(cadastroFuncionario.getTxtrua().getText());
            end.setCep(cadastroFuncionario.getTxtcep().getText());
            end.setNumero(cadastroFuncionario.getTxtnumero().getText());
            end.setMunicipio(cadastroFuncionario.getTxtcidade().getText());
            end.setEstado(cadastroFuncionario.getTxtUF().getSelectedItem().toString());

            Contato con = new Contato();
            con.setEmail(cadastroFuncionario.getTxtemail().getText());
            con.setCelular(cadastroFuncionario.getTxtcelular().getText());
            con.setTelefone(cadastroFuncionario.getTxttelefone().getText());

            Caixa c = new Caixa();
            c.setNumero(1);
            java.util.Date d = new Date();

            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

            c.setData(dStr);
            c.setStatus(true);
            c.setPagamentos(new ArrayList<Pagamento>());
            c.setFuncionarios(new ArrayList<Funcionario>());

            Login l = new Login();
            String senha = new String(cadastroFuncionario.getTxtsenha().getPassword());
            l.setSenha(senha);
            l.setUsuario(cadastroFuncionario.getTxtlogin().getText());

            Funcionario funcionario = new Funcionario();
            funcionario.setContato(con);
            funcionario.setEndereco(end);
            funcionario.setCaixa(c);
            funcionario.setFuncao(cadastroFuncionario.getTxtfuncao().getText());
            funcionario.setNome(cadastroFuncionario.getTxtnome().getText());
            funcionario.setLogin(l);
            funcionario.setCpf(cadastroFuncionario.getTxtcpf().getText());
            String salario = cadastroFuncionario.getTxtsalario().getText();
            try {

                salario = salario.replaceAll("[^0-9]", "");
                Double s = Double.parseDouble(salario);
                funcionario.setSalario(s);
                funcionario.setData_nascimento(cadastroFuncionario.getTxtdata().getText());
            } catch (Exception erro) {
            }

            String confirmarSenha = new String(cadastroFuncionario.getTxtconfirmasenha().getPassword());

            if (senha.equals(confirmarSenha)) {
                fachada1.salvarFuncionario(funcionario);
              buscarFuncionario.getTxtPesquisar().setText("");
            preenchertabela();
                buscarFuncionario.setVisible(true);
                cadastroFuncionario.setVisible(false);
                telaPrincipal.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Senha diferentes");
            }

        }
    }

    public void preenchertabela() {

        funcionarios = fachada1.getPorBuscaFuncionario(buscarFuncionario.getTxtPesquisar().getText());

        buscarFuncionario.getTabelaFunionario().setDefaultRenderer(Object.class, new Render());
        btn1 = new JButton("modificar");
        btn1.setName("m");
        btn2 = new JButton("Eliminar");
        btn2.setName("e");

        try {
            String[] colunas = new String[]{"Nome", "CPF", "Salario", "Fuuncao", "Data Nascimento", "E", "M"};
            Object[][] dados = new Object[funcionarios.size()][7];
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getCpf();
                dados[i][2] = funcionario.getSalario();
                dados[i][3] = funcionario.getFuncao();
                dados[i][4] = funcionario.getData_nascimento();
                dados[i][5] = btn1;
                dados[i][6] = btn2;
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarFuncionario.getTabelaFunionario().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void preencherCadastro(Funcionario f, CadastroFuncionario cf) {

        cf.getTxtcep().setText(f.getEndereco().getCep());
        cf.getTxtbairro().setText(f.getEndereco().getBairro());
        cf.getTxtnumero().setText(f.getEndereco().getNumero());
        cf.getTxtcidade().setText(f.getEndereco().getMunicipio());
        cf.getTxtrua().setText(f.getEndereco().getRua());
        for (int u = 0; u < cf.getTxtUF().getItemCount(); u++) {

            if (cf.getTxtUF().getItemAt(u).equals(f.getEndereco().getEstado())) {
                cf.getTxtUF().setSelectedItem(cf.getTxtUF().getItemAt(u));
            }
        }
        cf.getTxtcelular().setText(f.getContato().getCelular());
        cf.getTxttelefone().setText(f.getContato().getTelefone());
        cf.getTxtemail().setText(f.getContato().getEmail());

        cf.getTxtcpf().setText(f.getCpf());
        cf.getTxtnome().setText(f.getNome());

        cf.getTxtfuncao().setText(f.getFuncao());
        cf.getTxtsalario().setText(f.getSalario() + "");
        cf.getTxtlogin().setText(f.getLogin().getUsuario());
        cf.getTxtsenha().setText(f.getLogin().getSenha());
        cf.getTxtconfirmasenha().setText(f.getLogin().getSenha());
        cf.getTxtdata().setText(f.getData_nascimento());

    }

    public class Acaoupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cf.getBotaosalvarFuncionario()) {

                Funcionario funcionario = f;
                f=null;
                funcionario.getEndereco().setBairro(cf.getTxtbairro().getText());
                funcionario.getEndereco().setRua(cf.getTxtrua().getText());
                funcionario.getEndereco().setCep(cf.getTxtcep().getText());
                funcionario.getEndereco().setNumero(cf.getTxtnumero().getText());
                funcionario.getEndereco().setMunicipio(cf.getTxtcidade().getText());
                funcionario.getEndereco().setEstado(cf.getTxtUF().getSelectedItem().toString());
                funcionario.getContato().setEmail(cf.getTxtemail().getText());
                funcionario.getContato().setCelular(cf.getTxtcelular().getText());
                funcionario.getContato().setTelefone(cf.getTxttelefone().getText());
                String senha = new String(cf.getTxtsenha().getPassword());
                funcionario.getLogin().setSenha(senha);
                funcionario.getLogin().setUsuario(cf.getTxtlogin().getText());
                funcionario.setCpf(cf.getTxtcpf().getText());
                funcionario.setNome(cf.getTxtnome().getText());
                funcionario.setFuncao(cf.getTxtfuncao().getText());
                String salario = cf.getTxtsalario().getText();
                try {

                    salario = salario.replaceAll("[^0-9]", "");
                    Double s = Double.parseDouble(salario);
                    funcionario.setSalario(s);
                } catch (Exception fre) {
                }
                String confirmarSenha = new String(cf.getTxtconfirmasenha().getPassword());
                if (senha.equals(confirmarSenha)) {

                    fachada1.editarFuncionario(funcionario);
                    buscarFuncionario.getTxtPesquisar().setText("");
                    preenchertabela();
                    buscarFuncionario.setVisible(true);
                    cf.setVisible(false);
                    telaPrincipal.setEnabled(true);
                    cf = null;
                    f = null;
                    funcionario = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha diferentes");
                }

            }
        }
    }
}
