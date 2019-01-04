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
import java.util.ArrayList;
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
    public int salvarEspecializacao(Especializacao especializacao) {
        int id=0;
        try {
            
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Especializacao.INSERT);
            this.statement.setString(1, especializacao.getDescricao());
            this.statement.setDouble(2, especializacao.getSalario());
            this.statement.setString(3, especializacao.getHorario_disponivel());
            
            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Especializacao buscarEspecializacaoPorId(int id) {
        Especializacao especializacao = null;
        int idd=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Especializacao.NOME_TABELA,id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                especializacao = new Especializacao();
                
                especializacao.setDescricao(result.getString(SQLUtil.Especializacao.COL_DESCRICAO));
                especializacao.setSalario(result.getDouble(SQLUtil.Especializacao.COL_SALARIO));
                especializacao.setHorario_disponivel(result.getString(SQLUtil.Especializacao.COL_HORARIO_DISPONIVEL));
                
                
                 id = result.getInt(1);
                especializacao.setId(idd);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especializacao;
    }

    @Override
    public List<Especializacao> getAllEspecializacao() {
        List<Especializacao> especializacoes = new ArrayList<>();
        int idd=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Especializacao.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Especializacao especializacao;
            while (result.next()) {
                especializacao = new Especializacao();
                
                 especializacao.setDescricao(result.getString(SQLUtil.Especializacao.COL_DESCRICAO));
                especializacao.setSalario(result.getDouble(SQLUtil.Especializacao.COL_SALARIO));
                especializacao.setHorario_disponivel(result.getString(SQLUtil.Especializacao.COL_HORARIO_DISPONIVEL));
              
                 idd = result.getInt(1);
                especializacao.setId(idd);
                
                especializacoes.add(especializacao);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especializacoes;}

    @Override
    public void editarEspecializacao(Especializacao especializacao) {
     try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Especializacao.updateEspecializacao(especializacao.getDescricao(),especializacao.getSalario(),especializacao.getHorario_disponivel(),especializacao.getId()));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ativarDesativarEspecializacao(int id) {
      try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Especializacao.desativar(id));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
     @Override
     public Especializacao buscarEspecializaco(String busca) {
        Especializacao especializacao = null;
        int id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Especializacao.buscarEspecializacao(busca));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                especializacao = new Especializacao();
                
                especializacao.setDescricao(result.getString(SQLUtil.Especializacao.COL_DESCRICAO));
                especializacao.setSalario(result.getDouble(SQLUtil.Especializacao.COL_SALARIO));
                especializacao.setHorario_disponivel(result.getString(SQLUtil.Especializacao.COL_HORARIO_DISPONIVEL));

                id = result.getInt(1);
                especializacao.setId(id);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especializacao;
    }
}
