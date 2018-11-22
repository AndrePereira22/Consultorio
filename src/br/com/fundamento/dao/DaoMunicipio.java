/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Municipio;
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
public class DaoMunicipio implements  IDaoMunicipio{
    
    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;


    @Override
    public int salvarMunicipio(Municipio municipio) {
         int id = 0;
        try {
            int id_estado = new DaoEstado().salvarEstado(municipio.getEstado());
            
            this.conexao = SQLConections.getInstance();
             this.statement = conexao.prepareStatement(SQLUtil.Municipio.INSERT);
            this.statement.setString(1, municipio.getDescricao());
            this.statement.setInt(2, id_estado);
            result = statement.executeQuery();
            
            if (result.next()) {
                id = result.getInt(1);
            }
           
                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }
    return id;
    
    }

    @Override
    public Municipio buscarMunicipioPorId(int id) {
         Municipio municipio = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Municipio.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              municipio = new Municipio();
              
               municipio.setDescricao(result.getString(SQLUtil.Municipio.COL_NOME));
                       
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return municipio;
    }

    @Override
    public List<Municipio> getAllMunicipio() {
        List<Municipio> municipios = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Municipio.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Municipio municipio;
            while (result.next()) {
                municipio = new Municipio();
              municipio.setDescricao(result.getString(SQLUtil.Municipio.COL_NOME));
                
                municipios.add(municipio);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return municipios; }

    @Override
    public void editarMunicipio(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarMunicipio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
