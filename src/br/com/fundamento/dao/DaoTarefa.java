
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Tarefa;
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
public class DaoTarefa implements IDaoTarefa {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvarTarefa(Tarefa tarefa) {
         Consultorio c = new DaoConsultorio().bucarConsultorio();
        try {

            this.conexao = SQLConections.getInstance();

            this.statement = conexao.prepareStatement(SQLUtil.Tarefa.INSERT);

            this.statement.setString(1, tarefa.getDescricao());
            this.statement.setString(2, tarefa.getPrioridade());
            this.statement.setBoolean(3, tarefa.isStatus());
            this.statement.setString(4, tarefa.getData_inicio());
            this.statement.setString(5, tarefa.getData_termino());
            this.statement.setInt(6, c.getId());
            statement.execute();
            this.statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        Tarefa tarefa = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Tarefa.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                tarefa = new Tarefa();

                tarefa.setDescricao(result.getString(SQLUtil.Tarefa.COL_DESCRICAO));
                tarefa.setPrioridade(result.getString(SQLUtil.Tarefa.COL_PRIORIDADE));
                tarefa.setStatus(result.getBoolean(SQLUtil.Tarefa.COL_STATUS));
                tarefa.setData_inicio(result.getString(SQLUtil.Tarefa.COL_DATA_INICIO));
                tarefa.setData_termino(result.getString(SQLUtil.Tarefa.COL_DATA_TERMINO));
                id = result.getInt(1);
                tarefa.setId(id);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefa;
    }

    @Override
    public List<Tarefa> getAllTarefa() {
        List<Tarefa> tarefas = new ArrayList<>();
        int id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Tarefa.NOME));
            this.result = this.statement.executeQuery();
            Tarefa tarefa;
            while (result.next()) {
                tarefa = new Tarefa();

                tarefa.setDescricao(result.getString(SQLUtil.Tarefa.COL_DESCRICAO));
                tarefa.setPrioridade(result.getString(SQLUtil.Tarefa.COL_PRIORIDADE));
                tarefa.setStatus(result.getBoolean(SQLUtil.Tarefa.COL_STATUS));
                tarefa.setData_inicio(result.getString(SQLUtil.Tarefa.COL_DATA_INICIO));
                tarefa.setData_termino(result.getString(SQLUtil.Tarefa.COL_DATA_TERMINO));

                id = result.getInt(1);
                tarefa.setId(id);
                tarefas.add(tarefa);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefas;
    }

    @Override
    public void editarTarefa(Tarefa tarefa) {
        
              
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Tarefa.updateTarefa(tarefa.getDescricao(), tarefa.getPrioridade(), tarefa.isStatus(), tarefa.getData_termino(), tarefa.getId()));
         
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       }

    @Override
    public void ativarDesativarTarefa(int id) {
     try {
            this.conexao = SQLConections.getInstance();
            this.statement=this.conexao.prepareStatement(SQLUtil.Tarefa.desativar(id));
         
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    @Override
    public List<Tarefa> getPorBuscaTarefa(String busca) {
        List<Tarefa> tarefas = new ArrayList<>();
        int id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Tarefa.selectPorBusca(busca));
            this.result = this.statement.executeQuery();
            Tarefa tarefa;
            while (result.next()) {
                tarefa = new Tarefa();

                tarefa.setDescricao(result.getString(SQLUtil.Tarefa.COL_DESCRICAO));
                tarefa.setPrioridade(result.getString(SQLUtil.Tarefa.COL_PRIORIDADE));
                tarefa.setStatus(result.getBoolean(SQLUtil.Tarefa.COL_STATUS));
                tarefa.setData_inicio(result.getString(SQLUtil.Tarefa.COL_DATA_INICIO));
                tarefa.setData_termino(result.getString(SQLUtil.Tarefa.COL_DATA_TERMINO));

                id = result.getInt(1);
                tarefa.setId(id);
                tarefas.add(tarefa);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefas;
    }

}
