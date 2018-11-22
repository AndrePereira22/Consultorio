/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Funcionario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessFuncionario {
    
    public void salvarFuncionario(Funcionario funcionario);
    public Funcionario buscarFuncionarioPorId(int id);
    public List<Funcionario> getAllFuncionario();
    public void editarFuncionario(Funcionario funcionario);
    public void ativarDesativarFuncionario(int id);    
}
