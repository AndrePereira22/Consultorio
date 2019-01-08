/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Paciente;
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
public class DaoPaciente implements IDaoPaciente {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarPaciente(Paciente paciente) {
        int id = 0;
        try {

            int id_contato = new DaoContato().salvarContato(paciente.getContato());
            int id_endereco = CommumDao.salvarEndereco(paciente.getEndereco());

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT);
            this.statement.setString(1, paciente.getNome());
            this.statement.setString(2, paciente.getCpf());
            this.statement.setString(3, paciente.getSexo());
            this.statement.setString(4, paciente.getData_nascimento());
            this.statement.setString(5, paciente.getData_cadastro());
            this.statement.setString(6, paciente.getRg());
            this.statement.setString(7, paciente.getConvenio());
            this.statement.setInt(8, id_endereco);
            this.statement.setInt(9, id_contato);  
            

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
           

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        Paciente paciente = null;
        
        Contato contato=null;
        Endereco endereco=null;
        int idC=0,idE=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Paciente.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                paciente = new Paciente();
                
                paciente.setNome(result.getString(SQLUtil.Paciente.COL_NOME));
                paciente.setData_nascimento(result.getString(SQLUtil.Paciente.COL_DATA_NASCIMENTO));
                paciente.setData_cadastro(result.getString(SQLUtil.Paciente.COL_DATA_CADASTRO));
                paciente.setCpf(result.getString(SQLUtil.Paciente.COL_CPF));
                paciente.setSexo(result.getString(SQLUtil.Paciente.COL_SEXO));
                paciente.setRg(result.getString(SQLUtil.Paciente.COL_RG));
                paciente.setConvenio(result.getString(SQLUtil.Paciente.COL_CONVENIO));
                
               
                idE = result.getInt(SQLUtil.Paciente.COL_ENDERECO_ID);
                idC = result.getInt(SQLUtil.Paciente.COL_ID_CONTATO);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                paciente.setEndereco(endereco);
                paciente.setContato(contato);
                
                paciente.setId_contato(idC);
                paciente.setId_endereco(idE);
                
                id = result.getInt(1);
                 paciente.setId(id);
                
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public List<Paciente> getAllPaciente() {
        
    List<Paciente> pacientes = new ArrayList<>();
    
        Contato contato=null;
        Endereco endereco=null;
        int idC=0,idE=0,id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Paciente.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Paciente paciente;
            while (result.next()) {
                paciente = new Paciente();
                
             paciente.setNome(result.getString(SQLUtil.Paciente.COL_NOME));
                paciente.setData_nascimento(result.getString(SQLUtil.Paciente.COL_DATA_NASCIMENTO));
                paciente.setData_cadastro(result.getString(SQLUtil.Paciente.COL_DATA_CADASTRO));
                paciente.setCpf(result.getString(SQLUtil.Paciente.COL_CPF));
                paciente.setSexo(result.getString(SQLUtil.Paciente.COL_SEXO));
                paciente.setRg(result.getString(SQLUtil.Paciente.COL_RG));
                  paciente.setConvenio(result.getString(SQLUtil.Paciente.COL_CONVENIO));
                
                  
               
                idE = result.getInt(SQLUtil.Paciente.COL_ENDERECO_ID);
                idC = result.getInt(SQLUtil.Paciente.COL_ID_CONTATO);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                paciente.setEndereco(endereco);
                paciente.setContato(contato);
                
                
                paciente.setId_contato(idC);
                paciente.setId_endereco(idE);
                
                id = result.getInt(1);
                 paciente.setId(id);
                  
                pacientes.add(paciente);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    
    }
 public List<Paciente> getPorBusca(String busca) {
    List<Paciente> pacientes = new ArrayList<>();
   
        Contato contato=null;
        Endereco endereco=null;
        int idC=0,idE=0,id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Paciente.selectPorBusca(busca));
            this.result = this.statement.executeQuery();
            Paciente paciente;
            while (result.next()) {
                paciente = new Paciente();
                
                paciente.setNome(result.getString(SQLUtil.Paciente.COL_NOME));
                paciente.setData_nascimento(result.getString(SQLUtil.Paciente.COL_DATA_NASCIMENTO));
                paciente.setData_cadastro(result.getString(SQLUtil.Paciente.COL_DATA_CADASTRO));
                paciente.setCpf(result.getString(SQLUtil.Paciente.COL_CPF));
                paciente.setSexo(result.getString(SQLUtil.Paciente.COL_SEXO));
                paciente.setRg(result.getString(SQLUtil.Paciente.COL_RG));
                paciente.setConvenio(result.getString(SQLUtil.Paciente.COL_CONVENIO));
                
               
                idE = result.getInt(SQLUtil.Paciente.COL_ENDERECO_ID);
                idC = result.getInt(SQLUtil.Paciente.COL_ID_CONTATO);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                paciente.setEndereco(endereco);
                paciente.setContato(contato);
                
                
                
                paciente.setId_contato(idC);
                paciente.setId_endereco(idE);
                
                id = result.getInt(1);
                 paciente.setId(id);
                 pacientes.add(paciente);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacientes;
    
    }
    @Override
    public void editarPaciente(Paciente paciente) {
    
       
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Paciente.updatePaciente(paciente.getNome(),paciente.getCpf(),paciente.getRg(),paciente.getConvenio(),paciente.getId()));
         
           
            statement.execute();
            statement.close();
             for (Prontuario p : paciente.getProntuarios()){
                DaoList.salvarProntuario(p, paciente.getId());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
   CommumDao.editarEndereco(paciente.getEndereco(), paciente.getId_endereco());
   CommumDao.editarContato(paciente.getContato(), paciente.getId_contato());
       }

    @Override
    public void ativarDesativarPaciente(int id) {
            try {
            this.conexao = SQLConections.getInstance();
            this.statement=this.conexao.prepareStatement(SQLUtil.Paciente.desativar(id));
         
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }}
     @Override
     public Paciente buscarPaciente(String busca) {
         
        Paciente paciente = null;
        Contato contato=null;
        Endereco endereco=null;
        int id=0;
        int idC=0,idE=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Paciente.buscarPaciente(busca));
            result = statement.executeQuery();

            if (result.next()) {
                paciente = new Paciente();
                
                paciente.setNome(result.getString(SQLUtil.Paciente.COL_NOME));
                paciente.setData_nascimento(result.getString(SQLUtil.Paciente.COL_DATA_NASCIMENTO));
                paciente.setData_cadastro(result.getString(SQLUtil.Paciente.COL_DATA_CADASTRO));
                paciente.setCpf(result.getString(SQLUtil.Paciente.COL_CPF));
                paciente.setSexo(result.getString(SQLUtil.Paciente.COL_SEXO));
                paciente.setRg(result.getString(SQLUtil.Paciente.COL_RG));
                paciente.setConvenio(result.getString(SQLUtil.Paciente.COL_CONVENIO));
                
                idE = result.getInt(SQLUtil.Paciente.COL_ENDERECO_ID);
                idC = result.getInt(SQLUtil.Paciente.COL_ID_CONTATO);
                
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                
                
                paciente.setEndereco(endereco);
                paciente.setContato(contato);
                
                paciente.setId_contato(idC);
                paciente.setId_endereco(idE);
                
                id = result.getInt(1);
                 paciente.setId(id);
                 
                
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        paciente.setId(id);
        return paciente;
    }

}
