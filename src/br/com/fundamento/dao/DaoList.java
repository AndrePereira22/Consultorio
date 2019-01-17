/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoList {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    public static void salvarProduto(Produto produto, int estoque_id, int id_fornecedor) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Produto.INSERT);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getFabricante());
            statement.setInt(3, produto.getQuantidade_estoque());
            statement.setDouble(4, produto.getPreco_compra());
            statement.setInt(5, estoque_id);
            statement.setInt(6, id_fornecedor);

            statement.execute();

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    public static void salvarSaidaEstoque(SaidaEstoque saidaEstoque) {

        try {

            conexao = SQLConections.getInstance();

            statement = conexao.prepareStatement(SQLUtil.SaidaEstoque.INSERT);
            int id_produto = new DaoProduto().salvar(saidaEstoque.getProduto());
            statement.setString(1, saidaEstoque.getData());
            statement.setInt(2, saidaEstoque.getQuantidade_saida());
            statement.setInt(3, id_produto);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarParcelas(Parcela parcela, int id_pagamento) {

        try {

            conexao = SQLConections.getInstance();

            statement = conexao.prepareStatement(SQLUtil.Parcela.INSERT);

            statement.setDouble(1, parcela.getValor());
            statement.setBoolean(2, parcela.isStatus());
            statement.setInt(3, parcela.getNumero());
            statement.setString(4, parcela.getData_vencimento());
            statement.setString(5, parcela.getData_pagamento());
            statement.setInt(6, id_pagamento);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
  
    
    public static void salvarProntuario(Prontuario prontuario, int id_paciente) {

        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Prontuario.INSERT);
            statement.setString(1, prontuario.getExames());
            statement.setString(2, prontuario.getReceitas());
            statement.setString(3, prontuario.getData());
            statement.setString(4, prontuario.getSintomas());
            statement.setInt(5, id_paciente);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
