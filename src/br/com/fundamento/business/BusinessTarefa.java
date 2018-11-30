/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;


import br.com.fundamento.dao.DaoTarefa;
import br.com.fundamento.dao.IDaoTarefa;
import br.com.fundamento.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessTarefa implements IBusinessTarefa{
    
    IDaoTarefa daoTarefa ;
     public BusinessTarefa(){
        this.daoTarefa = new DaoTarefa();
    }
    
    

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        this.daoTarefa.salvarTarefa(tarefa);}

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        return this.daoTarefa.buscarTarefaPorId(id);
    }

    @Override
    public List<Tarefa> getAllTarefa() {
       return this.daoTarefa.getAllTarefa();
    }

    @Override
    public void editarTarefa(Tarefa tarefa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarTarefa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tarefa> getPorBuscaTarefa(String busca) {
       return  this.daoTarefa.getPorBuscaTarefa(busca);
    }
    
}
