/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.modelos.EntradaEstoque;
import br.com.fundamento.view.BuscarEntradaEstoque;
import br.com.fundamento.view.BuscarSaidaEstoque;
import br.com.fundamento.view.Entrada_Estoque;
import br.com.fundamento.view.Saida_Es;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleEstoque implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private Saida_Es saida_Estoque;
    private BuscarSaidaEstoque buscarSaidaEstoque;
    private Entrada_Estoque entrada;
    private BuscarEntradaEstoque buscarEntradaEstoque;
    private Produto produto;
    private List<Produto> produtos;
    IFachada fachada1 = Fachada.getInstance();

    public ControleEstoque(TelaPrincipal telaPrincipal, Saida_Es saida_Estoque, Entrada_Estoque entrada_Estoque, BuscarSaidaEstoque buscarSaidaEstoque, BuscarEntradaEstoque buscarEntradaEstoque) {
        this.telaPrincipal = telaPrincipal;
        this.saida_Estoque = saida_Estoque;
        this.entrada = entrada_Estoque;
        this.buscarSaidaEstoque = buscarSaidaEstoque;
        this.buscarEntradaEstoque = buscarEntradaEstoque;

        telaPrincipal.getBotaoSaidaEstoque().addActionListener(this);
        saida_Estoque.getBotaoCancelarSaidaEstoque().addActionListener(this);
        saida_Estoque.getBotaoSalvarSaidaEstoque().addActionListener(this);
        buscarSaidaEstoque.getBotaoadicionar().addActionListener(this);
        buscarSaidaEstoque.getBotaofechar().addActionListener(this);
        telaPrincipal.getBotaoEntradaEstoque().addActionListener(this);
        entrada_Estoque.getBotaoCancelarEntradaEstoque().addActionListener(this);
        entrada_Estoque.getBotaoSalvarEntradaEstoque().addActionListener(this);
        buscarEntradaEstoque.getBotaoadicionar().addActionListener(this);
        buscarEntradaEstoque.getBotaofechar().addActionListener(this);

        saida_Estoque.getListProduto().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = saida_Estoque.getListProduto().getMinSelectionIndex();
                try {

                    produto = produtos.get(indice);
                } catch (Exception eu) {
                }
            }
        });
        entrada_Estoque.getListProduto().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = entrada_Estoque.getListProduto().getMinSelectionIndex();
                try {

                    produto = produtos.get(indice);
                } catch (Exception eu) {
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaPrincipal.getBotaoEntradaEstoque()) {
            preenchertabelaEntrada();
            buscarEntradaEstoque.setVisible(true);
        }
        if (e.getSource() == entrada.getBotaoCancelarEntradaEstoque()) {
            preenchertabelaEntrada();
            entrada.setVisible(false);
            buscarEntradaEstoque.setVisible(true);
            PreencherProdutoSaida(saida_Estoque);
        }
        if (e.getSource() == entrada.getBotaoSalvarEntradaEstoque()) {
            EntradaEstoque entradaEstoque = new EntradaEstoque();
            java.util.Date d = new Date();
            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            entradaEstoque.setData(dStr);
            String q = entrada.getTxtQuantidade().getText();
            q = q.replaceAll("[^0-9]", "");
            int quantidade = 0;

            try {

                quantidade = Integer.parseInt(q);

            } catch (NumberFormatException erro) {
            }

            entradaEstoque.setQuantidade_entrada(quantidade);

            entradaEstoque.setProduto(produto);

            entradaEstoque.getProduto().setQuantidade_estoque(entradaEstoque.getProduto().getQuantidade_estoque() + quantidade);
            fachada1.editarProduto(produto);
            fachada1.salvarEntradaEstoque(entradaEstoque);
            preenchertabelaEntrada();
            entrada.setVisible(false);
            buscarEntradaEstoque.setVisible(true);
        }

        if (e.getSource() == telaPrincipal.getBotaoSaidaEstoque()) {
            preenchertabelaSaida();
            buscarSaidaEstoque.setVisible(true);

        }
        if (e.getSource() == buscarEntradaEstoque.getBotaofechar()) {
            buscarEntradaEstoque.setVisible(false);
        }
        if (e.getSource() == buscarEntradaEstoque.getBotaoadicionar()) {
            entrada.setVisible(true);
            buscarEntradaEstoque.setVisible(false);
            entrada.getTxtQuantidade().setText("");
            PreencherProdutoEntrada(entrada);
        }
        if (e.getSource() == buscarSaidaEstoque.getBotaofechar()) {
            buscarSaidaEstoque.setVisible(false);
        }
        if (e.getSource() == buscarSaidaEstoque.getBotaoadicionar()) {
            saida_Estoque.setVisible(true);
            buscarSaidaEstoque.setVisible(false);
            saida_Estoque.getTxtquantidade().setText("");
            PreencherProdutoSaida(saida_Estoque);

        }
        if (e.getSource() == saida_Estoque.getBotaoCancelarSaidaEstoque()) {
            preenchertabelaSaida();
            saida_Estoque.setVisible(false);
            buscarSaidaEstoque.setVisible(true);
            PreencherProdutoSaida(saida_Estoque);
        }
        if (e.getSource() == saida_Estoque.getBotaoSalvarSaidaEstoque()) {

            SaidaEstoque saidaEstoque = new SaidaEstoque();

            java.util.Date d = new Date();
            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            saidaEstoque.setData(dStr);
            String q = saida_Estoque.getTxtquantidade().getText();
            q = q.replaceAll("[^0-9]", "");
            int quantidade = 0;

            try {

                quantidade = Integer.parseInt(q);

            } catch (NumberFormatException erro) {
            }

            saidaEstoque.setQuantidade_saida(quantidade);

            saidaEstoque.setProduto(produto);
            if (saidaEstoque.getProduto().getQuantidade_estoque() >= quantidade) {
                saidaEstoque.getProduto().setQuantidade_estoque(saidaEstoque.getProduto().getQuantidade_estoque() - quantidade);
                fachada1.editarProduto(produto);
                fachada1.salvarSaidaEstoque(saidaEstoque);
                preenchertabelaSaida();
                saida_Estoque.setVisible(false);
                buscarSaidaEstoque.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Quantidade Insuficiente");
            }
        }
    }

    public void PreencherProdutoSaida(Saida_Es cp) {

        produtos = fachada1.getAllProdutos();

        DefaultListModel model = new DefaultListModel();
        for (Produto f : produtos) {

            model.addElement(f.getNome());

        }

        cp.getListProduto().setModel(model);
    }
     public void PreencherProdutoEntrada(Entrada_Estoque cp) {

        produtos = fachada1.getAllProdutos();

        DefaultListModel model = new DefaultListModel();
        for (Produto f : produtos) {

            model.addElement(f.getNome());

        }

        cp.getListProduto().setModel(model);
    }

    public void preenchertabelaSaida() {
        List<SaidaEstoque> saida = fachada1.getAllSaidaEstoque();
        buscarSaidaEstoque.getTabelaSaidaestoque().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Produto", "Quantidade", "Data"};
            Object[][] dados = new Object[saida.size()][3];
            for (int i = 0; i < saida.size(); i++) {
                SaidaEstoque saidaEstoque = saida.get(i);
                dados[i][0] = saidaEstoque.getProduto().getNome();
                dados[i][1] = saidaEstoque.getQuantidade_saida();
                dados[i][2] = saidaEstoque.getData();
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarSaidaEstoque.getTabelaSaidaestoque().setModel(dataModel);
        } catch (Exception ex) {

        }

    }
       public void preenchertabelaEntrada() {
        List<EntradaEstoque> entradaEstoques = fachada1.getAllEntradaEstoque();
        buscarEntradaEstoque.getTabelaEntadaestoque().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Produto", "Quantidade", "Data"};
            Object[][] dados = new Object[entradaEstoques.size()][3];
            for (int i = 0; i < entradaEstoques.size(); i++) {
                EntradaEstoque entradaEstoque = entradaEstoques.get(i);
                dados[i][0] = entradaEstoque.getProduto().getNome();
                dados[i][1] = entradaEstoque.getQuantidade_entrada();
                dados[i][2] = entradaEstoque.getData();
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarEntradaEstoque.getTabelaEntadaestoque().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

}
