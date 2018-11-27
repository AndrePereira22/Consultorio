/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Produto;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessFornecedor {
    public void salvarfornecedor(Fornecedor fornecedor);
    public Fornecedor buscarPorfornecedorId(int id);
    public List<Fornecedor> getAllfornecedor();
    public void editarfornecedor(Fornecedor fornecedor);
    public void ativarDesativarfornecedor(int id);
    public List<Fornecedor> getPorBuscaFornecedor(String busca);
    
}
