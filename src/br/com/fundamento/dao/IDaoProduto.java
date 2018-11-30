/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;


import br.com.fundamento.modelos.Produto;
import java.util.List;

public interface IDaoProduto {
    
    public void salvar(Produto produto);
    public Produto buscarPorId(int id);
    public List<Produto> getAll();
    public void editar(Produto produto);
    public void ativarDesativar(int id);
    public List<Produto> getPorBuscaProduto(String busca);
    
    
    
}
