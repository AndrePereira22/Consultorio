/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Login;
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
public class DaoLogin implements  IDaoLogin{

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarLogin(Login login) {
        
        int id=0;
        
  try {
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Login.INSERT);
            this.statement.setString(1, login.getUsuario());
            this.statement.setString(2, login.getSenha());
            result = statement.executeQuery();
            
            if (result.next()) {
                id = result.getInt(1);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
  return id;

        }

    @Override
    public Login buscarLoginPorId(int id) {
        Login login = null;
         int iD;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Login.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              login = new Login();
               login.setUsuario(result.getString(SQLUtil.Login.COL_LOGIN));
                login.setSenha(result.getString(SQLUtil.Login.COL_SENHA));
                       
                 iD = result.getInt(1);
               login.setId(iD);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
    @Override
    public List<Login> getAllLogin() {
        List<Login> logins = new ArrayList<>();
         int id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Login.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Login login;
            while (result.next()) {
                login = new Login();
                
                login.setUsuario(result.getString(SQLUtil.Login.COL_LOGIN));
                login.setSenha(result.getString(SQLUtil.Login.COL_SENHA));
                 id = result.getInt(1);
                login.setId(id);
                logins.add(login);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logins;  }

    @Override
    public void editarLogin(Login login) {
           try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Login.updateLoString(login.getUsuario(),login.getSenha(), login.getId()));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
     }

    @Override
    public void ativarDesativarLogin(int id) {
         try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Login.desativar(id));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }  
     }

    @Override
    public Login buscarLoginFuncionario(String nome) {
          Login login = null;
           int id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Login.BuscaloginFuncionario(nome));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              login = new Login();
               login.setUsuario(result.getString(SQLUtil.Login.COL_LOGIN));
                login.setSenha(result.getString(SQLUtil.Login.COL_SENHA));
                     id = result.getInt(1);
                login.setId(id);  
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
      
    }

    @Override
    public Login buscarLoginMedico(String parametro,String nome) {
        Login login = null;
        int id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Login.BuscaloginMedico(parametro ,nome));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              login = new Login();
               login.setUsuario(result.getString(SQLUtil.Login.COL_LOGIN));
                login.setSenha(result.getString(SQLUtil.Login.COL_SENHA));
                id = result.getInt(1);
                login.setId(id);    
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login; }
    
}
