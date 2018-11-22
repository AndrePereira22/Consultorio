/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.SaidaEstoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessSaidaEstoque {
    
     public void salvarSaidaEstoque(SaidaEstoque saidaEstoque);
    public SaidaEstoque buscarSaidaEstoquePorId(int id);
    public List<SaidaEstoque> getAllSaidaEstoque();
    public void editarSaidaEstoque(SaidaEstoque saidaEstoque);
    public void ativarDesativarSaidaEstoque(int id);
    
}
