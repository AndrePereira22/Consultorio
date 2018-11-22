
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Tarefa;
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
public class DaoTarefa  implements IDaoTarefa{

     private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
     
    
    @Override
    public void salvarTarefa(Tarefa tarefa) {
       try {
            int id_funcionario = new DaoFuncionario().salvarFuncionario(tarefa.getFuncionario());
            
            this.conexao = SQLConections.getInstance();
         
             this.statement = conexao.prepareStatement(SQLUtil.Tarefa.INSERT);
        
            this.statement.setString(1,tarefa.getDescricao());
            this.statement.setInt(2,  tarefa.getPrioridade());
            this.statement.setBoolean(3, tarefa.isStatus());
            this.statement.setInt(4, id_funcionario);
            this.statement.setString(5, tarefa.getDate_inicioString());
             this.statement.setString(6, tarefa.getDate_terminoString());
             
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
               tarefa.setPrioridade(result.getInt(SQLUtil.Tarefa.COL_PRIORIDADE));
               tarefa.setStatus(result.getBoolean(SQLUtil.Tarefa.COL_STATUS));
             //  tarefa.setDate_inicioInt(result.getString(SQLUtil.Tarefa.COL_DATA_INICIO));
             //  tarefa.setDate_terminoInt(result.getString(SQLUtil.Tarefa.COL_DATA_TERMINO));
               
                       
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tarefa;
    }

    @Override
    public List<Tarefa> getAllTarefa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarTarefa(Tarefa tarefa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarTarefa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
