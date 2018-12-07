/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Medico;
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
public class DaoConsultorio implements IDaoConsultorio {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarConsultorio(Consultorio consultorio) {
        int id = 0;
        try {
            int id_contato = new DaoContato().salvarContato(consultorio.getContato());
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Consultorio.INSERT);
            int id_endereco = CommumDao.salvarEndereco(consultorio.getEndereco());
            this.statement.setString(1, consultorio.getNome_fantasia());
            this.statement.setString(2, consultorio.getRazao_social());
            this.statement.setString(3, consultorio.getCnpj());
            this.statement.setInt(4, id_endereco);
            this.statement.setInt(5, id_contato);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            
            for (Medico m : consultorio.getMedicos()) {
                
                DaoList.salvarMedico(m, id,id_contato);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Consultorio buscarConsultorioPorId(int id) {
        Consultorio consultorio = null;
        int idE=0,idC=0;
        Endereco endereco=null;
        Contato contato=null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Consultorio.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                consultorio = new Consultorio();
                
                consultorio.setNome_fantasia(result.getString(SQLUtil.Consultorio.COL_NOME_fANTASIA));
                consultorio.setRazao_social(result.getString(SQLUtil.Consultorio.COL_RAZAO_SOCIAl));
                consultorio.setCnpj(result.getString(SQLUtil.Consultorio.COL_CNPJ));
                
                idE = result.getInt(SQLUtil.Consultorio.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Consultorio.COL_ID_CONTATO);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio.setEndereco(endereco);
                consultorio.setContato(contato);
                consultorio.setMedicos(new ArrayList<Medico>());
                
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultorio;
    }

    @Override
    public List<Consultorio> getAllConsultorio() {
         List<Consultorio> consultorios = new ArrayList<>();
         int idE=0,idC=0;
        Endereco endereco=null;
        Contato contato=null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Consultorio.NOME));
            this.result = this.statement.executeQuery();
            Consultorio consultorio;
            while (result.next()) {
                consultorio = new Consultorio();
                
               consultorio.setNome_fantasia(result.getString(SQLUtil.Consultorio.COL_NOME_fANTASIA));
               consultorio.setRazao_social(result.getString(SQLUtil.Consultorio.COL_RAZAO_SOCIAl));
               consultorio.setCnpj(result.getString(SQLUtil.Consultorio.COL_CNPJ));
                   
                idE = result.getInt(SQLUtil.Consultorio.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Consultorio.COL_ID_CONTATO);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio.setEndereco(endereco);
                consultorio.setContato(contato);
                
                consultorios.add(consultorio);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultorios; }

    @Override
    public void editarConsultorio(Consultorio consultorio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarConsultorio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultorio bucarConsultorio() {
          Consultorio consultorio = null;
          int idE=0,idC=0;
        Endereco endereco=null;
        Contato contato=null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Consultorio.BuscaConsultorio());
            this.result = this.statement.executeQuery();

            if (result.next()) {
                consultorio = new Consultorio();
                
                consultorio.setNome_fantasia(result.getString(SQLUtil.Consultorio.COL_NOME_fANTASIA));
                consultorio.setRazao_social(result.getString(SQLUtil.Consultorio.COL_RAZAO_SOCIAl));
                consultorio.setCnpj(result.getString(SQLUtil.Consultorio.COL_CNPJ));
                
                 idE = result.getInt(SQLUtil.Consultorio.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Consultorio.COL_ID_CONTATO);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio.setEndereco(endereco);
                consultorio.setContato(contato);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsultorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultorio;
    
    
        
        }
    
    
    

}
