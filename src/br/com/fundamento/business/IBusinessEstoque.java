/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Login;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessEstoque {
    
    public void salvarEstoque(Estoque estoque);
    public Estoque buscarPorEstoqueId(int id);
    public List<Estoque> getAllEstoque();
    public void editarEstoque(Estoque estoque);
    public void ativarDesativarEstoque(int id);
    
}
