/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Fornecedor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoFornecedor {
    
    public  int  salvarfornecedor(Fornecedor fornecedor);
    public Fornecedor buscarPorfornecedorId(int id);
    public List<Fornecedor> getAllfornecedor();
    public void editarfornecedor(Fornecedor fornecedor);
    public void ativarDesativarfornecedor(int id);
    
}
