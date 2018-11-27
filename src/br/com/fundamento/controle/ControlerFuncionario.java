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
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Relatorio;
import br.com.fundamento.modelos.Tarefa;
import br.com.fundamento.view.BuscarFuncionario;
import br.com.fundamento.view.CadastroFuncionario;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControlerFuncionario implements ActionListener {

    private CadastroFuncionario cadastroFuncionario;
    private TelaPrincipal telaPrincipal;
    private BuscarFuncionario buscarFuncionario;

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
        buscarFuncionario.getBotaoPesquisar().addActionListener(this);

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
            buscarFuncionario.setVisible(true);
            cadastroFuncionario.setVisible(false);

        }
        
        if(e.getSource()==buscarFuncionario.getBotaoPesquisar()){
            
            List<Funcionario> funcionarios = fachada1.getPorBuscaFuncionario(buscarFuncionario.getTxtPesquisar().getText());

        try {
            String[] colunas = new String[]{"Nome", "CPF", "Salario", "Fuuncao", "Data Nascimento"};
            Object[][] dados = new Object[funcionarios.size()][5];
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getCpf();
                dados[i][2] = funcionario.getSalario();
                dados[i][3] = funcionario.getFuncao();
                dados[i][4] = funcionario.getData_nascimento();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            buscarFuncionario.getTabelaFunionario().setModel(dataModel);
        } catch (Exception ex) {

        }
            
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
            funcionario.setRelatorios(new ArrayList<Relatorio>());
            funcionario.setTarefas(new ArrayList<Tarefa>());
            funcionario.setCaixa(c);
            funcionario.setFuncao(cadastroFuncionario.getTxtfuncao().getText());
            funcionario.setNome(cadastroFuncionario.getTxtnome().getText());
            funcionario.setLogin(l);
            funcionario.setCpf(cadastroFuncionario.getTxtcpf().getText());
            String salario = cadastroFuncionario.getTxtsalario().getText();
            salario = salario.replaceAll("[^0-9]", "");
            Double s = Double.parseDouble(salario);
            funcionario.setSalario(s);
            funcionario.setData_nascimento(cadastroFuncionario.getTxtdata().getText());

            fachada1.salvarFuncionario(funcionario);
            preenchertabela();
            buscarFuncionario.setVisible(true);
            cadastroFuncionario.setVisible(false);
            telaPrincipal.setEnabled(true);

        }
    }

    public void preenchertabela() {
        List<Funcionario> funcionarios = fachada1.getAllFuncionario();

        try {
            String[] colunas = new String[]{"Nome", "CPF", "Salario", "Fuuncao", "Data Nascimento"};
            Object[][] dados = new Object[funcionarios.size()][5];
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getCpf();
                dados[i][2] = funcionario.getSalario();
                dados[i][3] = funcionario.getFuncao();
                dados[i][4] = funcionario.getData_nascimento();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            buscarFuncionario.getTabelaFunionario().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

}
