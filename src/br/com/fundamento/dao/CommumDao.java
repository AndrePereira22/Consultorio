/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Produto;
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
 * @author prof Heldon
 */
public class CommumDao {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    public static int salvarEndereco(Endereco end) {
        int id = 0;
        try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT);
            statement.setString(1, end.getCep());
            statement.setString(2, end.getRua());
            statement.setString(3, end.getBairro());
            statement.setString(4, end.getNumero());
            statement.setString(5, end.getMunicipio());
            statement.setString(6, end.getEstado());

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public static void editarEndereco(Endereco end,int id) {
        
        try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Endereco.updateEnd(end.getCep(), end.getRua(), end.getNumero(),end.getBairro(), end.getMunicipio(), end.getEstado(), id));
            
            statement.execute();
            statement.close();

            
        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
  public static Endereco buscarEndereco(String tabela, String coluna, String busca) {
          Endereco endereco = null;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Endereco.buscaEndereco(tabela, coluna, busca));
            result = statement.executeQuery();

            if (result.next()) {
                endereco= new Endereco();
            
            endereco.setCep(result.getString(SQLUtil.Endereco.COL_CEP));
            endereco.setRua(result.getString(SQLUtil.Endereco.COL_RUA));
            endereco.setBairro(result.getString(SQLUtil.Endereco.COL_BAIRRO));
            endereco.setNumero(result.getString(SQLUtil.Endereco.COL_NUMERO));
            endereco.setMunicipio(result.getString(SQLUtil.Endereco.COL_MUNICIPIO));
           endereco.setEstado(result.getString(SQLUtil.Endereco.COL_ESTADO));
           
                
                            }
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;

}
   public static Endereco bucarEnderecoPorId(int id) {
          Endereco endereco = null;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, id));
            result = statement.executeQuery();

            if (result.next()) {
                endereco= new Endereco();
            
            endereco.setCep(result.getString(SQLUtil.Endereco.COL_CEP));
            endereco.setRua(result.getString(SQLUtil.Endereco.COL_RUA));
            endereco.setBairro(result.getString(SQLUtil.Endereco.COL_BAIRRO));
            endereco.setNumero(result.getString(SQLUtil.Endereco.COL_NUMERO));
            endereco.setMunicipio(result.getString(SQLUtil.Endereco.COL_MUNICIPIO));
            endereco.setEstado(result.getString(SQLUtil.Endereco.COL_ESTADO));
           
                
                            }
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;

}
  public static Contato bucarContato(String tabela, String coluna, String busca) {
        Contato contato = null;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Contato.buscaContato(tabela, coluna, busca));
            result = statement.executeQuery();

            if (result.next()) {
                contato = new Contato();
            
            contato.setEmail(result.getString(SQLUtil.Contato.COL_EMAIL));
            contato.setCelular(result.getString(SQLUtil.Contato.COL_CELULAR));
            contato.setTelefone(result.getString(SQLUtil.Contato.COL_TELEFONE));

                
                            }
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contato;

}
  public static Contato bucarContatoPorId(int id) {
        Contato contato = null;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Contato.NOME_TABELA, id));
            result = statement.executeQuery();

            if (result.next()) {
                contato = new Contato();
            
            contato.setEmail(result.getString(SQLUtil.Contato.COL_EMAIL));
            contato.setCelular(result.getString(SQLUtil.Contato.COL_CELULAR));
            contato.setTelefone(result.getString(SQLUtil.Contato.COL_TELEFONE));

                
                            }
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contato;

}
   public static void editarContato(Contato contato,int id) {
        
        try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Contato.updateContato(contato.getEmail(),contato.getTelefone(),contato.getTelefone(), id));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}