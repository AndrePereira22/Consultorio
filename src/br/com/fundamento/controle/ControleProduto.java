/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.view.BuscarProduto;
import br.com.fundamento.view.CadastroProduto;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleProduto implements ActionListener{
    
     private TelaPrincipal telaPrincipal;
     private CadastroProduto cadastroProduto;
     private BuscarProduto buscarProduto;
     IFachada fachada1 = Fachada.getInstance();

    public ControleProduto(TelaPrincipal telaPrincipal, CadastroProduto cadastroProduto, BuscarProduto buscarProduto) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroProduto = cadastroProduto;
        this.buscarProduto = buscarProduto;
        
        telaPrincipal.getBotaoCadastarProduto().addActionListener(this);
        cadastroProduto.getBotaoCancelarProduto().addActionListener(this);
        cadastroProduto.getBotaoSalvarProduto().addActionListener(this);
        buscarProduto.getBotaoAdicionarProduto().addActionListener(this);
        buscarProduto.getBotaoEditarProduto().addActionListener(this);
        buscarProduto.getBotaoExcluirProduto().addActionListener(this);
        buscarProduto.getBotaoFecharProduto().addActionListener(this);
        buscarProduto.getBotaoPesquisarProduto().addActionListener(this);
        
    }
     
     

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == telaPrincipal.getBotaoCadastarProduto()) {
             
              List<Produto> produtos = fachada1.getAllProdutos();

            try {
                String[] colunas = new String[]{"Nome", "Fabricante","Quantidade Estoque","Quantidade Minima", "Preco Compra"};
                Object[][] dados = new Object[produtos.size()][5];
                for (int i = 0; i < produtos.size(); i++) {
                    Produto produto = produtos.get(i);
                    dados[i][0] = produto.getNome();
                    dados[i][1] = produto.getFabricante();
                    dados[i][2] = produto.getQuantidade_estoque();
                    dados[i][3] = produto.getQuantidade_minima();
                    dados[i][4] = produto.getPreco_compra();
                }
                DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
                buscarProduto.getTabela().setModel(dataModel);
            } catch (Exception ex) {

            }
             
            telaPrincipal.setEnabled(false);
            buscarProduto.setVisible(true);
        }
        if (e.getSource() == buscarProduto.getBotaoFecharProduto()) {
            telaPrincipal.setEnabled(true);
            buscarProduto.setVisible(false);
        }
        if (e.getSource() == buscarProduto.getBotaoAdicionarProduto()) {
           
            cadastroProduto.setVisible(true); 
            buscarProduto.setVisible(false);
        }
        if (e.getSource() == cadastroProduto.getBotaoCancelarProduto()) {
            telaPrincipal.setEnabled(false);
            buscarProduto.setVisible(true);
            cadastroProduto.setVisible(false);
        }
        if (e.getSource() == cadastroProduto.getBotaoSalvarProduto()) {
            
            
            
            

            buscarProduto.setVisible(true);
            cadastroProduto.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    } 
}
    

