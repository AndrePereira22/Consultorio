/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;


import br.com.fundamento.dao.DaoProduto;
import br.com.fundamento.dao.IDaoProduto;
import br.com.fundamento.modelos.Produto;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class BusinessProduto implements IBusinessProduto {

    IDaoProduto daoProduto;

    public BusinessProduto() {
        this.daoProduto = new DaoProduto();
    }

    @Override
    public void salvar(Produto produto) {
        this.daoProduto.salvar(produto);
    }

    @Override
    public Produto buscarPorId(int id) {
        return this.daoProduto.buscarPorId(id);
    }

    @Override
    public List<Produto> getAll() {
        return this.daoProduto.getAll();
    }

    @Override
    public void editar(Produto produto) {
      this.daoProduto.editar(produto);
    }

    @Override
    public void ativarDesativar(int id) {
    this.daoProduto.ativarDesativar(id);
    
    }

    @Override
    public List<Produto> getPorBuscaProduto(String busca) {
       return this.daoProduto.getPorBuscaProduto(busca);
    }
}
