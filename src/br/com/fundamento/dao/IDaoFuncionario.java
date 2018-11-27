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
    
    public int salvarFuncionario(Funcionario funcionario);
    public Funcionario buscarFuncionarioPorId(int id);
    public List<Funcionario> getAllFuncionario();
    public void editarFuncionario(Funcionario funcionario);
    public void ativarDesativarFuncionario(int id);
    public List<Funcionario> getPorBuscaFuncionario(String busca);
    
}
