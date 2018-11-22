/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Especializacao;
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
public class DaoEspecializacao implements IDaoEspecializacao {

    private static Connection conexao;
    private static PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvarEspecializacao(Especializacao especializacao) {
        try {
            int id_medico = new DaoMedico().salvarMedico(especializacao.getMedico());
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Especializacao.INSERT);
            this.statement.setString(1, especializacao.getDescricao());
            this.statement.setDouble(2, especializacao.getSalario());
            this.statement.setInt(3, id_medico);
            this.statement.setString(4, especializacao.getHorario_disponivel());

            statement.execute();
            this.statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Especializacao buscarEspecializacaoPorId(int id) {
        Especializacao especializacao = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Especializacao.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                especializacao = new Especializacao();
                
                especializacao.setDescricao(result.getString(SQLUtil.Especializacao.COL_DESCRICAO));
                especializacao.setSalario(result.getFloat(SQLUtil.Especializacao.COL_SALARIO));
                //especializacao.setHorario_disponivel(result.getString(SQLUtil.Especializacao.COL_HORARIO_DISPONIVEL));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especializacao;
    }

    @Override
    public List<Especializacao> getAllEspecializacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarEspecializacao(Especializacao especializacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEspecializacao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}