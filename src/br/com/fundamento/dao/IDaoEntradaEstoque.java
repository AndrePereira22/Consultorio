/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.EntradaEstoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoEntradaEstoque {
    public int salvarEntradaEstoque(EntradaEstoque entradaEstoque);
    public EntradaEstoque buscarEntradaEstoquePorId(int id);
    public List<EntradaEstoque> getAllEntradaEstoque();
    public void editarEntradaEstoque(EntradaEstoque entradaEstoque);
    public void ativarDesativarEntradaEstoque(int id);
    public List<EntradaEstoque> getPorBuscaEntradaEstoque(String busca);
    
    
}
