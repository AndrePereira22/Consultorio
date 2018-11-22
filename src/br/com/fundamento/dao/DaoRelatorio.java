/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Relatorio;
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
public class DaoRelatorio implements IDaoRelatorio {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvar(Relatorio relatorio) {
        try {
            int id_funcionario = new DaoFuncionario().salvarFuncionario(relatorio.getFuncionario());

            this.conexao = SQLConections.getInstance();

            this.statement = conexao.prepareStatement(SQLUtil.Relatorio.INSERT);

            this.statement.setString(1, relatorio.getDescricao());
            this.statement.setString(2, relatorio.getRelatorio());
            this.statement.setInt(3, id_funcionario);

            statement.execute();
            this.statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Relatorio buscarPorId(int id) {
        Relatorio relatorio = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Relatorio.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                relatorio = new Relatorio();
                
                relatorio.setDescricao(result.getString(SQLUtil.Relatorio.COL_DESCRICAO));
                relatorio.setRelatorio(result.getString(SQLUtil.Relatorio.COL_RELATORIO));

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoRelatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return relatorio;
    }

    @Override
    public List<Relatorio> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Relatorio relatroio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
