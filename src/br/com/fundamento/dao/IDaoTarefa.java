/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoTarefa {
    public void salvarTarefa(Tarefa tarefa);
    public Tarefa buscarTarefaPorId(int id);
    public List<Tarefa> getAllTarefa();
    public void editarTarefa(Tarefa tarefa);
    public void ativarDesativarTarefa(int id);
    
}
