/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Estado;
import br.com.fundamento.modelos.Municipio;
import br.com.fundamento.modelos.Produto;
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
public class DaoEstado implements IDaoEstado{
    
    private static Connection conexao;
    private static PreparedStatement statement; 
        private static ResultSet result;
    
    @Override
    public int salvarEstado(Estado estado) {
        int id = 0;
      
         try {
            this.conexao = SQLConections.getInstance();
             this.statement = conexao.prepareStatement(SQLUtil.Estado.INSERT);
            this.statement.setString(1, estado.getNome());
            this.statement.setString(2, estado.getSigla());
            
            
        result = statement.executeQuery();
            
            if (result.next()) {
                id = result.getInt(1);
            }
            for(Municipio municipios :   estado.getMunicipios()){
                DaoList.salvarMunicipio(municipios, id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
          return id;
    }

    @Override
    public Estado buscarEstadoPorId(int id) {
         Estado estado = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Estado.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              estado = new Estado();
               estado.setNome(result.getString(SQLUtil.Estado.COL_NOME));
               estado.setSigla(result.getString(SQLUtil.Estado.COL_SIGLA));
                       
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }

    @Override
    public List<Estado> getAllEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEstado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
