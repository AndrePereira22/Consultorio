/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void salvarSaidaEstoque(SaidaEstoque saidaEstoque) {

        try {

            int id_estoque = new DaoEstoque().salvarEstoque(saidaEstoque.getEstoque());
            this.conexao = SQLConections.getInstance();

            this.statement = conexao.prepareStatement(SQLUtil.SaidaEstoque.INSERT);

            this.statement.setString(1, saidaEstoque.getNome());
            this.statement.setString(2, saidaEstoque.getFabricante());
            this.statement.setInt(3, saidaEstoque.getQuantidade_saida());
            this.statement.setInt(4, id_estoque);

            statement.execute();
            this.statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public SaidaEstoque buscarSaidaEstoquePorId(int id) {
        SaidaEstoque saidaEstoque = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.SaidaEstoque.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                saidaEstoque = new SaidaEstoque();

                saidaEstoque.setNome(result.getString(SQLUtil.SaidaEstoque.COL_NOME));
                saidaEstoque.setFabricante(result.getString(SQLUtil.SaidaEstoque.COL_FABRICANTE));
                saidaEstoque.setQuantidade_saida(result.getInt(SQLUtil.SaidaEstoque.COL_QUANTIDADE_SAIDA));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saidaEstoque;
    }

    @Override
    public List<SaidaEstoque> getAllSaidaEstoque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarSaidaEstoque(SaidaEstoque saidaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarSaidaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
