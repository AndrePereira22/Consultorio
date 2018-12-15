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
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Login;
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
public class DaoMedico implements IDaoMedico {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarMedico(Medico medico) {
        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            int id_contato = new DaoContato().salvarContato(medico.getContato());
            int id_consultorio = new DaoConsultorio().salvarConsultorio(medico.getConsultorio());
            int id_login = new DaoLogin().salvarLogin(medico.getLogin());
            int id_endereco = CommumDao.salvarEndereco(medico.getEndereco());

            this.statement = conexao.prepareStatement(SQLUtil.Medico.INSERT);
            this.statement.setString(1, medico.getNome());
            this.statement.setString(2, medico.getSexo());
            this.statement.setInt(3, medico.getRg());
            this.statement.setInt(4, id_consultorio);
            this.statement.setString(5, medico.getCpf());
            this.statement.setString(6, medico.getData_nascimento());
            this.statement.setString(7, medico.getData_cadastro());
            this.statement.setInt(8, id_login);
            this.statement.setInt(9, id_endereco);
            this.statement.setInt(10, id_contato);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Especializacao e : medico.getEspecializacoes()) {
                DaoList.salvarEspecializacao(e, id);
            }
            for (Consulta c : medico.getConsultas()) {
                int id_pagamento = new DaoPagamento().salvarPagamento(c.getPagamento());
                int id_paciente = new DaoPaciente().salvarPaciente(c.getPaciente());
                DaoList.salvarConsulta(c, id, id_pagamento, id_paciente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Medico buscarMedicoPorId(int id) {
        Medico medico = null;
        Endereco endereco=null;
        Contato contato=null;
        Consultorio consultorio=null;
        Login login=null;
        int idE=0,idC=0,idCons=0,idL=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Medico.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                medico = new Medico();
                
                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
                medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
               medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getInt(SQLUtil.Medico.COL_RG));
                idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idCons = result.getInt(SQLUtil.Medico.COL_ID_CONSULTORIO);
                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio = new DaoConsultorio().buscarConsultorioPorId(idCons);
                login =  new DaoLogin().buscarLoginPorId(idL);
               
                medico.setContato(contato);
                medico.setEndereco(endereco);
                medico.setConsultorio(consultorio);
                medico.setLogin(login);
                medico.setConsultas(new ArrayList<Consulta>());
                medico.setEspecializacoes(new ArrayList<Especializacao>());
                
                 id = result.getInt(1);
                medico.setId(id);
                
                medico.setId_end(idE);  
                medico.setId_contato(idC);
                medico.setId_login(idL);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }

    @Override
    public List<Medico> getAllMedico() {
        List<Medico> medicos = new ArrayList<>();
         Endereco endereco=null;
        Contato contato=null;
        Consultorio consultorio=null;
        Login login=null;
        int idE=0,idC=0,idCons=0,idL=0,id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Medico.NOME));
            this.result = this.statement.executeQuery();
            Medico medico;
            while (result.next()) {
                medico = new Medico();
                
                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
               medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
               medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getInt(SQLUtil.Medico.COL_RG));
                 idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
               
                 idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idCons = result.getInt(SQLUtil.Medico.COL_ID_CONSULTORIO);
                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio = new DaoConsultorio().buscarConsultorioPorId(idCons);
                login =  new DaoLogin().buscarLoginPorId(idL);
               
                medico.setContato(contato);
                medico.setEndereco(endereco);
                medico.setConsultorio(consultorio);
                medico.setLogin(login);
                medico.setConsultas(new ArrayList<Consulta>());
                medico.setEspecializacoes(new ArrayList<Especializacao>());
                medico.setId_contato(idC);
                medico.setId_end(idE);
                medico.setId_login(idL);
                
                id = result.getInt(1);
                 medico.setId(id);
                medicos.add(medico);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;}

    @Override
    public void editarMedico(Medico medico) {
        
      
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.updateMedico(medico.getNome(),medico.getCpf(),medico.getRg(),medico.getId()));
            System.out.println(medico.getId());
            
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
                CommumDao.editarEndereco(medico.getEndereco(), medico.getId_end());
                CommumDao.editarContato(medico.getContato(), medico.getId_contato());
                new DaoLogin().editarLogin(medico.getLogin());
                
      
        }

    @Override
    public void ativarDesativarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medico> getPorBuscaMedico(String busca) {
        List<Medico> medicos = new ArrayList<>();
         Endereco endereco=null;
        Contato contato=null;
        Consultorio consultorio=null;
        Login login=null;
        int idE=0,idC=0,idCons=0,idL=0,id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.selectPorBusca(busca));
            this.result = this.statement.executeQuery();
            Medico medico;
            while (result.next()) {
                medico = new Medico();
                
                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
               medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
               medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getInt(SQLUtil.Medico.COL_RG));
                 idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idCons = result.getInt(SQLUtil.Medico.COL_ID_CONSULTORIO);
                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio = new DaoConsultorio().buscarConsultorioPorId(idCons);
                login =  new DaoLogin().buscarLoginPorId(idL);
                medico.setContato(contato);
                medico.setEndereco(endereco);
                medico.setConsultorio(consultorio);
                medico.setLogin(login);
                medico.setConsultas(new ArrayList<Consulta>());
                medico.setEspecializacoes(new ArrayList<Especializacao>());
                medico.setId_contato(idC);
                medico.setId_end(idE);
                medico.setId_login(idL);
                
                id = result.getInt(1);
                 medico.setId(id);
                medicos.add(medico);
                
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;   
      }
     public Medico BuscarMedico(String busca) {
     Medico medico = new Medico();
      Endereco endereco=null;
        Contato contato=null;
        Consultorio consultorio=null;
        Login login=null;
        int idE=0,idC=0,idCons=0,idL=0,id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.buscarMedico(busca));
            this.result = this.statement.executeQuery();
           
            while (result.next()) {
                
                
             medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
               medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
               medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getInt(SQLUtil.Medico.COL_RG));
                 idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idCons = result.getInt(SQLUtil.Medico.COL_ID_CONSULTORIO);
                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                consultorio = new DaoConsultorio().buscarConsultorioPorId(idCons);
                login =  new DaoLogin().buscarLoginPorId(idL);
                medico.setContato(contato);
                medico.setEndereco(endereco);
                medico.setConsultorio(consultorio);
                medico.setLogin(login);
                
                medico.setId_contato(idC);
                medico.setId_end(idE);
                medico.setId_login(idL);
                
                id = result.getInt(1);
                 medico.setId(id);
             
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico; 
     }

}
