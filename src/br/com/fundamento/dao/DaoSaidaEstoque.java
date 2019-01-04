/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.SaidaEstoque;
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
 * @author Glenda Alves de Lima
 */
public class DaoSaidaEstoque implements IDaoSaidaEstoque {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public int salvarSaidaEstoque(SaidaEstoque saidaEstoque) {

        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.SaidaEstoque.INSERT);
            this.statement.setString(1, saidaEstoque.getData());
            this.statement.setInt(2, saidaEstoque.getQuantidade_saida());
            this.statement.setInt(3, saidaEstoque.getProduto().getId());

            if (result.next()) {
                id = result.getInt(1);
            }

            statement.execute();
            this.statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public SaidaEstoque buscarSaidaEstoquePorId(int id) {
        SaidaEstoque saidaEstoque = null;
        Produto produto = null;
        int idP;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.SaidaEstoque.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                saidaEstoque = new SaidaEstoque();

                saidaEstoque.setData(result.getString(SQLUtil.SaidaEstoque.COL_DATA));
                saidaEstoque.setQuantidade_saida(result.getInt(SQLUtil.SaidaEstoque.COL_QUANTIDADE_SAIDA));

                idP = result.getInt(SQLUtil.SaidaEstoque.COL_ID_PRODUTO);
                produto = new DaoProduto().buscarPorId(idP);
                saidaEstoque.setProduto(produto);

                id = result.getInt(1);
                produto.setId(id);

                saidaEstoque.setId_produto(idP);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saidaEstoque;
    }

    @Override
    public List<SaidaEstoque> getAllSaidaEstoque() {
        List<SaidaEstoque> saidaEstoques = new ArrayList<>();
        Produto produto = null;
        int idP = 0, id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.SaidaEstoque.NOME_TABELA));
            this.result = this.statement.executeQuery();
            SaidaEstoque saidaEstoque;
            while (result.next()) {
                saidaEstoque = new SaidaEstoque();

                saidaEstoque.setData(result.getString(SQLUtil.SaidaEstoque.COL_DATA));
                saidaEstoque.setQuantidade_saida(result.getInt(SQLUtil.SaidaEstoque.COL_QUANTIDADE_SAIDA));

                idP = result.getInt(SQLUtil.SaidaEstoque.COL_ID_PRODUTO);
                produto = new DaoProduto().buscarPorId(idP);
                saidaEstoque.setProduto(produto);

                id = result.getInt(1);
                produto.setId(id);

                saidaEstoque.setId_produto(idP);

                saidaEstoques.add(saidaEstoque);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saidaEstoques;
    }

    @Override
    public void editarSaidaEstoque(SaidaEstoque saidaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarSaidaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SaidaEstoque> getPorBuscaSaidaEstoque(String busca) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

}
