/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;


import br.com.fundamento.modelos.Funcionario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoFuncionario {
    
     public void salvar(Funcionario funcionario);
    public Funcionario buscarPorId(int id);
    public List<Funcionario> getAll();
    public void editar(Funcionario funcionario);
    public void ativarDesativar(int id);
    
}
