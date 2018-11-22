/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
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
public class DaoConsulta implements IDaoConsulta{
    
     private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarConsulta(Consulta consulta) {
              int id = 0;
      try {
    
          int id_pagamento = new DaoPagamento().salvarPagamento(consulta.getPagamento());
          int id_consultorio = new DaoConsultorio().salvarConsultorio(consulta.getConsultorio());
          int id_medico = new DaoMedico().salvarMedico(consulta.getMedico());
          int id_paciente = new DaoPaciente().salvarPaciente(consulta.getPaciente());
             
            this.conexao = SQLConections.getInstance();
             this.statement = conexao.prepareStatement(SQLUtil.Consulta.INSERT);
            
            this.statement.setString(1, consulta.getTipo());
            this.statement.setBoolean(2, consulta.isAgendamento());
            this.statement.setInt(3, id_paciente);
            this.statement.setInt(4, id_medico);
            this.statement.setInt(5, id_consultorio);
            this.statement.setInt(6, id_pagamento);
            this.statement.setString(7, consulta.getDate_horsString());
            
         
             
        result = statement.executeQuery();
            
            if (result.next()) {
                id = result.getInt(1);
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    return id;
            }

    @Override
    public Consulta buscarConsultaPorId(int id) {
          Consulta consulta = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Consulta.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              consulta = new Consulta();
              
              //consulta.setDate_horaInt(result.getString(SQLUtil.Consulta.COL_DATA_HORA));
               consulta.setTipo(result.getString(SQLUtil.Consulta.COL_TIPO));
               consulta.setAgendamento(result.getBoolean(SQLUtil.Consulta.COL_AGENDAMENTO));
              
              
               
                       
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consulta;
    }
        

    @Override
    public List<Consulta> getAllConsulta() {
         List<Consulta> consultas = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Consulta.NOME));
            this.result = this.statement.executeQuery();
            Consulta consulta;
            while (result.next()) {
                consulta = new Consulta();
                
                
              //consulta.setDate_horaInt(result.getString(SQLUtil.Consulta.COL_DATA_HORA));
               consulta.setTipo(result.getString(SQLUtil.Consulta.COL_TIPO));
               consulta.setAgendamento(result.getBoolean(SQLUtil.Consulta.COL_AGENDAMENTO));
              
                
                consultas.add(consulta);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consultas;  }

    @Override
    public void editarConsulta(Consulta consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarConsulta(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
