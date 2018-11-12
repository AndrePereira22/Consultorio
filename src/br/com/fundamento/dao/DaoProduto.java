/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Cliente;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class DaoProduto implements IDaoProduto {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvar(Produto produto) {

        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Produto.INSERT);
            this.statement.setString(1, produto.getNome());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Produto buscarPorId(int id) {
        Produto produto = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Produto.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                produto = new Produto();
                produto.setId(result.getInt(1));
                produto.setNome(result.getString(SQLUtil.Produto.DESCRICAO));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public List<Produto> getAll() {
        List<Produto> produtos = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME));
            this.result = this.statement.executeQuery();
            Produto produto;
            while (result.next()) {
                produto = new Produto();
                produto.setId(result.getInt(1));
                produto.setNome(result.getString(SQLUtil.Produto.DESCRICAO));
                produtos.add(produto);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    @Override
    public void editar(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
