/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Prontuario;
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
public class DaoProntuario implements IDaoProntuario{
    
    private Connection conexao;
    private PreparedStatement statement;
      private static ResultSet result;

    @Override
    public int salvarProntuario(Prontuario prontuario) {
       int id = 0;
      try {
            this.conexao = SQLConections.getInstance();
             this.statement = conexao.prepareStatement(SQLUtil.Prontuario.INSERT);
            this.statement.setString(1, prontuario.getExames());
            this.statement.setString(2, prontuario.getReceitas());
             this.statement.setString(3, prontuario.getData());
              this.statement.setString(4, prontuario.getSintomas());
             result = statement.executeQuery();
            
            if (result.next()) {
                id = result.getInt(1);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
      return id;
     }

    @Override
    public Prontuario buscarProntuarioPorId(int id) {
        Prontuario prontuario = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Prontuario.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              prontuario = new Prontuario();
              
               prontuario.setExames(result.getString(SQLUtil.Prontuario.COL_EXAMES));
               prontuario.setReceitas(result.getString(SQLUtil.Prontuario.COL_RECEITAS));
               prontuario.setData(result.getString(SQLUtil.Prontuario.COL_DATA));
               prontuario.setSintomas(result.getString(SQLUtil.Prontuario.COL_SINTOMAS));
                       
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prontuario;
    }

    @Override
    public List<Prontuario> getAllProntuario() {
       List<Prontuario> prontuarios = new ArrayList<>();
       int id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Prontuario.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Prontuario prontuario;
            while (result.next()) {
                prontuario = new Prontuario();
                
              prontuario.setExames(result.getString(SQLUtil.Prontuario.COL_EXAMES));
               prontuario.setReceitas(result.getString(SQLUtil.Prontuario.COL_RECEITAS));
                prontuario.setData(result.getString(SQLUtil.Prontuario.COL_DATA));
               prontuario.setSintomas(result.getString(SQLUtil.Prontuario.COL_SINTOMAS));
                id = result.getInt(1);
                
                prontuario.setId(id);
                prontuarios.add(prontuario);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prontuarios;  }

    @Override
    public void editarProntuario(Prontuario prontuario) {
        
           try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Prontuario.updateProntuario(prontuario.getReceitas(), prontuario.getSintomas(), prontuario.getExames(), prontuario.getId()));
         
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }

   }

    @Override
    public void ativarDesativarProntuario(int id) {
         try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Prontuario.desativar(id));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        } 
     
    }

    @Override
    public Prontuario buscarProntuario(String busca) {
          Prontuario prontuario = null;
          int id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Prontuario.buscaProntuario(busca));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              prontuario = new Prontuario();
              
               prontuario.setExames(result.getString(SQLUtil.Prontuario.COL_EXAMES));
               prontuario.setReceitas(result.getString(SQLUtil.Prontuario.COL_RECEITAS));
               prontuario.setData(result.getString(SQLUtil.Prontuario.COL_DATA));
               prontuario.setSintomas(result.getString(SQLUtil.Prontuario.COL_SINTOMAS));
                        id = result.getInt(1);
                
                prontuario.setId(id);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prontuario;  
    }
    
     public List<Prontuario> ProntuariosPaciente(int id) {
       List<Prontuario> prontuarios = new ArrayList<>();
       int idd=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Prontuario.prontuarioPaciente(id));
            this.result = this.statement.executeQuery();
            Prontuario prontuario;
            while (result.next()) {
                prontuario = new Prontuario();
                
              prontuario.setExames(result.getString(SQLUtil.Prontuario.COL_EXAMES));
               prontuario.setReceitas(result.getString(SQLUtil.Prontuario.COL_RECEITAS));
                prontuario.setData(result.getString(SQLUtil.Prontuario.COL_DATA));
               prontuario.setSintomas(result.getString(SQLUtil.Prontuario.COL_SINTOMAS));
                idd = result.getInt(1);
                
                prontuario.setId(idd);
                prontuarios.add(prontuario);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prontuarios;  }
}
