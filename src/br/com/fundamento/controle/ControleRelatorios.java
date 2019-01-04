/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.modelos.Tarefa;
import br.com.fundamento.view.Recibo;
import br.com.fundamento.view.Relatorio;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleRelatorios implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private Relatorio relatorio, relatorioP, relatorioT, relatorioF, relatorioC;
    private ControleProduto controleProduto;
    Recibo recibo;
    IFachada fachada1 = Fachada.getInstance();

    public ControleRelatorios(TelaPrincipal telaPrincipal, Relatorio relatorio, Recibo recibo) {
        this.telaPrincipal = telaPrincipal;
        this.relatorio = relatorio;
        this.recibo = recibo;

        relatorioC = new Relatorio();
        relatorioF = new Relatorio();
        relatorioT = new Relatorio();
        relatorioP = new Relatorio();

        telaPrincipal.getBotaoRelatorioConsulta().addActionListener(this);
        telaPrincipal.getBotaoRelatorioFluxoCaixa().addActionListener(this);
        telaPrincipal.getBotaoRelatorioPessoais().addActionListener(this);
        relatorio.getBotaoVoltarRelatorio().addActionListener(this);
        relatorio.getBotaoRelatorio().addActionListener(this);
        relatorio.getComboescolha().addActionListener(this);
        relatorioP.getBotaoVoltarRelatorio().addActionListener(this);
        relatorioP.getBotaoRelatorio().addActionListener(this);
        relatorioT.getBotaoVoltarRelatorio().addActionListener(this);
        relatorioT.getBotaoRelatorio().addActionListener(this);
        relatorioC.getBotaoVoltarRelatorio().addActionListener(this);
        relatorioC.getBotaoRelatorio().addActionListener(this);
        relatorioF.getBotaoVoltarRelatorio().addActionListener(this);
        relatorioF.getBotaoRelatorio().addActionListener(this);
        telaPrincipal.getBotaoRelatorioProduto().addActionListener(this);
        telaPrincipal.getBotaoRelatorioTarefa().addActionListener(this);
        telaPrincipal.getBotaoRecibo().addActionListener(this);
        recibo.getBotaoRecibo().addActionListener(this);
        recibo.getBotaoVoltarRecibo().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == relatorio.getBotaoVoltarRelatorio()) {
            relatorio.setVisible(false);
        }
        if (e.getSource() == relatorioC.getBotaoVoltarRelatorio()) {
            relatorioC.setVisible(false);
        }
        if (e.getSource() == relatorioT.getBotaoVoltarRelatorio()) {
            relatorioT.setVisible(false);
        }
        if (e.getSource() == relatorioF.getBotaoVoltarRelatorio()) {
            relatorioF.setVisible(false);
        }
        if (e.getSource() == relatorioP.getBotaoVoltarRelatorio()) {
            relatorioP.setVisible(false);

        }
        if (e.getSource() == recibo.getBotaoVoltarRecibo()) {
            recibo.setVisible(false);
           


        }
        if (e.getSource() == telaPrincipal.getBotaoRelatorioPessoais()) {
            relatorio.getjLabel5().setText("Relatorio Perssoais");
            relatorio.getLabelescolha().setVisible(true);
            relatorio.getComboescolha().setVisible(true);
            relatorio.getComboescolha().setSelectedIndex(0);
            relatorio.setVisible(true);
            preencherbuscasPaciente();

        }
        if (e.getSource() == telaPrincipal.getBotaoRecibo()) {
            recibo.setVisible(true);
            recibo.getTxtnome().setText("");
            recibo.getTxtnome().setHorizontalAlignment(recibo.getTxtnome().CENTER);
            recibo.getFuncionario().setText("");
            recibo.getFuncionario().setHorizontalAlignment(recibo.getFuncionario().CENTER);
            recibo.getCpf().setText("");
            recibo.getCpf().setHorizontalAlignment(recibo.getCpf().CENTER);
            recibo.getReferente().setText("");
            recibo.getReferente().setHorizontalAlignment(recibo.getReferente().CENTER);
            recibo.getValor().setText("");
            recibo.getValor().setHorizontalAlignment(recibo.getValor().CENTER);
            recibo.getDia().setText("");
            recibo.getDia().setHorizontalAlignment(recibo.getDia().CENTER);
            recibo.getAno().setText("");
            recibo.getAno().setHorizontalAlignment(recibo.getAno().CENTER);
            recibo.getMes().setText("");
            recibo.getMes().setHorizontalAlignment(recibo.getMes().CENTER);
            recibo.getAssinaturaCliente().setText("");
            recibo.getAssinaturaCliente().setHorizontalAlignment(recibo.getAssinaturaCliente().CENTER);
            recibo.getAssinaturaFuncionario().setText("");
            recibo.getAssinaturaFuncionario().setHorizontalAlignment(recibo.getAssinaturaFuncionario().CENTER);
        }
        if (e.getSource() == relatorio.getComboescolha()) {

            if (relatorio.getComboescolha().getSelectedItem().toString().equals("Fornecedor")) {
                preenchertabelaFornecedor();
            }
            if (relatorio.getComboescolha().getSelectedItem().toString().equals("Paciente")) {
                preencherbuscasPaciente();
            }
            if (relatorio.getComboescolha().getSelectedItem().toString().equals("Medico")) {
                preenchertabelaMedico();
            }
            if (relatorio.getComboescolha().getSelectedItem().toString().equals("Funcionario")) {
                preenchertabelaFuncionario();
            }

        }
        if (e.getSource() == telaPrincipal.getBotaoRelatorioConsulta()) {
            relatorioC.getComboescolha().setVisible(false);
            relatorioC.getLabelescolha().setVisible(false);
            relatorioC.getjLabel5().setText("Relatorio de Consulta");
            relatorioC.setVisible(true);
            preenchertabelaConsulta();
        }

        if (e.getSource() == telaPrincipal.getBotaoRelatorioFluxoCaixa()) {
            relatorioF.getComboescolha().setVisible(false);
            relatorioF.getLabelescolha().setVisible(false);
            relatorioF.getjLabel5().setText("Relatorio de Fluxo de Caixa");
            relatorioF.setVisible(true);

        }
        if (e.getSource() == telaPrincipal.getBotaoRelatorioProduto()) {
            relatorioP.getComboescolha().setVisible(false);
            relatorioP.getLabelescolha().setVisible(false);
            relatorioP.getjLabel5().setText("Relatorio de Produto");
            relatorioP.setVisible(true);
            PreencherTabelaproduto();
        }
        if (e.getSource() == telaPrincipal.getBotaoRelatorioTarefa()) {
            relatorioT.getComboescolha().setVisible(false);
            relatorioT.getLabelescolha().setVisible(false);
            relatorioT.getjLabel5().setText("Relatorio de Tarefa");
            relatorioT.setVisible(true);
            PreencherTabelatarefa();
        }
        if (e.getSource() == relatorioP.getBotaoRelatorio()) {

            MessageFormat t = new MessageFormat("Relatório de Produto");
            MessageFormat o = new MessageFormat("");

            try {
                relatorioP.getTabelarelatorio().print(JTable.PrintMode.FIT_WIDTH, t, o);
            } catch (Exception pp) {
                JOptionPane.showInternalMessageDialog(null, "Erro na Tabela");
            }

        }
        if (e.getSource() == relatorioF.getBotaoRelatorio()) {

            MessageFormat t = new MessageFormat("Relatório Fluxo de Caixa");
            MessageFormat o = new MessageFormat("");

            try {
                relatorioF.getTabelarelatorio().print(JTable.PrintMode.FIT_WIDTH, t, o);
            } catch (Exception pp) {
                JOptionPane.showInternalMessageDialog(null, "Erro na Tabela");
            }

        }

        if (e.getSource() == relatorioC.getBotaoRelatorio()) {

            MessageFormat t = new MessageFormat("Relatório de Consulta");
            MessageFormat o = new MessageFormat("");

            try {
                relatorioC.getTabelarelatorio().print(JTable.PrintMode.FIT_WIDTH, t, o);
            } catch (Exception pp) {
                JOptionPane.showInternalMessageDialog(null, "Erro na Tabela");
            }

        }

        if (e.getSource() == relatorio.getBotaoRelatorio()) {

            MessageFormat t = new MessageFormat("Relatório de " + relatorio.getComboescolha().getSelectedItem().toString());
            MessageFormat o = new MessageFormat("");

            try {
                relatorio.getTabelarelatorio().print(JTable.PrintMode.FIT_WIDTH, t, o);
            } catch (Exception pp) {
                JOptionPane.showInternalMessageDialog(null, "Erro na Tabela");
            }

        }

        if (e.getSource() == relatorioT.getBotaoRelatorio()) {

            MessageFormat t = new MessageFormat("Relatório de Tarefas");
            MessageFormat o = new MessageFormat("");

            try {
                relatorioT.getTabelarelatorio().print(JTable.PrintMode.FIT_WIDTH, t, o);

            } catch (Exception pp) {
                JOptionPane.showInternalMessageDialog(null, "Erro na Tabela");
            }

        }
        if (e.getSource() == recibo.getBotaoRecibo()) {
             printComponenet();
             
        }
        recibo.getTxtnome().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
 
                recibo.getAssinaturaCliente().setText(recibo.getTxtnome().getText());
            }
        });
         recibo.getFuncionario().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
 
                recibo.getAssinaturaFuncionario().setText(recibo.getFuncionario().getText());
            }
        });


    }

    public void PreencherTabelaproduto() {

        List<Produto> produtos = fachada1.getAllProdutos();
        relatorioP.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "Fabricante", "Quantidade Estoque", "Preco Compra"};
            Object[][] dados = new Object[produtos.size()][5];
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                dados[i][0] = produto.getNome();
                dados[i][1] = produto.getFabricante();
                dados[i][2] = produto.getQuantidade_estoque();
                dados[i][3] = produto.getPreco_compra();
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorioP.getTabelarelatorio().setModel(dataModel);

        } catch (Exception ex) {

        }

    }

    public void PreencherTabelatarefa() {

        List<Tarefa> tarefas = fachada1.getAllTarefa();

        relatorioT.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Descricao", "Prioridade", "Status", "Data Inicio", "Data Termino"};
            Object[][] dados = new Object[tarefas.size()][5];
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
                s = "Em Andamento";

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorioT.getTabelarelatorio().setModel(dataModel);
        } catch (Exception ex) {

        }
    }

    public void preenchertabelaConsulta() {

        List<Consulta> consultas = fachada1.getAllConsulta();
        relatorioC.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Hora", "Tipo", "Paciente", "Medico"};
            Object[][] dados = new Object[consultas.size()][4];
            for (int i = 0; i < consultas.size(); i++) {
                Consulta c = consultas.get(i);

                dados[i][0] = c.getHora();
                dados[i][1] = c.getTipo();
                dados[i][2] = c.getPaciente().getNome();
                dados[i][3] = c.getMedico().getNome();
                i++;
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorioC.getTabelarelatorio().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void preenchertabelaFornecedor() {

        List<Fornecedor> fornecedores = fachada1.getAllfornecedor();

        relatorio.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome Fantasia", "Razao Social", "cnpj"};
            Object[][] dados = new Object[fornecedores.size()][3];
            for (int i = 0; i < fornecedores.size(); i++) {
                Fornecedor fornecedor = fornecedores.get(i);
                dados[i][0] = fornecedor.getNome_fantasia();
                dados[i][1] = fornecedor.getRazao_social();
                dados[i][2] = fornecedor.getCnpj();

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorio.getTabelarelatorio().setModel(dataModel);
        } catch (Exception ex) {

        }
    }

    public void preenchertabelaMedico() {
        List<Medico> medicos = fachada1.getAllMedico();
        relatorio.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "Sexo", "Rg", "CPF", "Data Nascimento", "Data Cadastro"};
            Object[][] dados = new Object[medicos.size()][6];
            for (int i = 0; i < medicos.size(); i++) {
                Medico medico = medicos.get(i);
                dados[i][0] = medico.getNome();
                dados[i][1] = medico.getSexo();
                dados[i][2] = medico.getRg();
                dados[i][3] = medico.getCpf();
                dados[i][4] = medico.getData_nascimento();
                dados[i][5] = medico.getData_cadastro();

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorio.getTabelarelatorio().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void preencherbuscasPaciente() {
        List<Paciente> pacientes = fachada1.getAllPaciente();

        relatorio.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "CPF", "Sexo", "Data Nascimento", "Data Cadastro", "Rg", "Convenio"};
            Object[][] dados = new Object[pacientes.size()][7];
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente paciente = pacientes.get(i);
                dados[i][0] = paciente.getNome();
                dados[i][1] = paciente.getCpf();
                dados[i][2] = paciente.getSexo();
                dados[i][3] = paciente.getData_nascimento();
                dados[i][4] = paciente.getData_cadastro();
                dados[i][5] = paciente.getRg();
                dados[i][6] = paciente.getConvenio();

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorio.getTabelarelatorio().setModel(dataModel);
        } catch (Exception erro) {

        }

    }

    public void preenchertabelaFuncionario() {

        List<Funcionario> funcionarios = fachada1.getAllFuncionario();

        relatorio.getTabelarelatorio().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Nome", "CPF", "Salario", "Fuuncao", "Data Nascimento"};
            Object[][] dados = new Object[funcionarios.size()][7];
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                dados[i][0] = funcionario.getNome();
                dados[i][1] = funcionario.getCpf();
                dados[i][2] = funcionario.getSalario();
                dados[i][3] = funcionario.getFuncao();
                dados[i][4] = funcionario.getData_nascimento();
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            relatorio.getTabelarelatorio().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void printComponenet() {
        PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Print Component ");
        pj.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                recibo.getRecibo().paint(g2);        
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

}
