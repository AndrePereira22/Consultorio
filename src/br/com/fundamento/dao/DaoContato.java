/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Contato;
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
public class DaoContato implements IDaoContato{
    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarContato(Contato contato) {
        int id = 0;
        try {

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Contato.INSERT);
            this.statement.setString(1, contato.getEmail());
            this.statement.setString(2, contato.getTelefone());
            this.statement.setString(3, contato.getCelular());
            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(DaoContato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
     }

    @Override
    public Contato buscarContatoPorId(int id) {
       Contato contato = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Contato.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                contato = new Contato();
               
                contato.setEmail(result.getString(SQLUtil.Contato.COL_EMAIL));
                contato.setTelefone(result.getString(SQLUtil.Contato.COL_TELEFONE));
                contato.setCelular(result.getString(SQLUtil.Contato.COL_CELULAR));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contato; }

    @Override
    public List<Contato> getAllContato() {
         List<Contato> contatos = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Contato.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Contato contato;
            while (result.next()) {
                contato = new Contato();
                
                contato.setEmail(result.getString(SQLUtil.Contato.COL_EMAIL));
                contato.setTelefone(result.getString(SQLUtil.Contato.COL_TELEFONE));
                contato.setCelular(result.getString(SQLUtil.Contato.COL_CELULAR));
                
                contatos.add(contato);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contatos;}

    @Override
    public void editarContato(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarContato(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
