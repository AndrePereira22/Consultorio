/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Convenio;
import br.com.fundamento.modelos.Paciente;
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
public class DaoConvenio implements IDaoConvenio{
    
    private Connection conexao;
    private PreparedStatement statement;
      private static ResultSet result;

    @Override
    public int salvarConvenio(Convenio convenio) {
        int id = 0;
      try {
           
            this.conexao = SQLConections.getInstance();
             this.statement = conexao.prepareStatement(SQLUtil.Convenio.INSERT);
            this.statement.setString(1, convenio.getNome());
            this.statement.setString(2, convenio.getTelefone());
            this.statement.setString(3, convenio.getEmail());
            this.statement.setBoolean(4, convenio.isAtivo());
             result = statement.executeQuery();
            
            if (result.next()) {
                id = result.getInt(1);
            }
            for(Paciente p:  convenio.getPacientes()){
                  int id_prontuario = new DaoProntuario().salvarProntuario(p.getProntuario());
                  int id_endereco = CommumDao.salvarEndereco(p.getEndereco());
                DaoList.salvarPaciente(p,id,id_prontuario,id_endereco);
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoConvenio.class.getName()).log(Level.SEVERE, null, ex);
        }
      return id;
}

    @Override
    public Convenio buscarConvenioPorId(int id) {
         Convenio convenio = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Convenio.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              convenio = new Convenio();
              
               convenio.setNome(result.getString(SQLUtil.Convenio.COL_NOME));
                convenio.setAtivo(result.getBoolean(SQLUtil.Convenio.COL_ATIVO));   
                convenio.setEmail(result.getString(SQLUtil.Convenio.COL_EMAIL));
                convenio.setTelefone(result.getString(SQLUtil.Convenio.COL_TELEFONE));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConvenio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convenio;
     }

    @Override
    public List<Convenio> getAllConvenio() {
         List<Convenio> convenios = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Convenio.NOME));
            this.result = this.statement.executeQuery();
            Convenio convenio;
            while (result.next()) {
                convenio = new Convenio();
                
             convenio.setNome(result.getString(SQLUtil.Convenio.COL_NOME));
                convenio.setAtivo(result.getBoolean(SQLUtil.Convenio.COL_ATIVO));   
                convenio.setEmail(result.getString(SQLUtil.Convenio.COL_EMAIL));
                convenio.setTelefone(result.getString(SQLUtil.Convenio.COL_TELEFONE));
                
                convenios.add(convenio);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConvenio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convenios;  }

    @Override
    public void editarConvenio(Convenio convenio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarConvenio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
