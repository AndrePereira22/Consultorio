/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoFornecedor;
import br.com.fundamento.dao.DaoProduto;
import br.com.fundamento.dao.IDaoFornecedor;
import br.com.fundamento.dao.IDaoProduto;
import br.com.fundamento.modelos.Fornecedor;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessFornecedor implements IBusinessFornecedor{
    
    IDaoFornecedor daoFornecedor;

    public BusinessFornecedor () {
        this.daoFornecedor = new DaoFornecedor();
    }

    @Override
    public void salvarfornecedor(Fornecedor fornecedor) {
       this.daoFornecedor.salvarfornecedor(fornecedor);
    }

    @Override
    public Fornecedor buscarPorfornecedorId(int id) {
       return this.daoFornecedor.buscarPorfornecedorId(id);
    }

    @Override
    public List<Fornecedor> getAllfornecedor() {
        return this.daoFornecedor.getAllfornecedor();
    }

    @Override
    public void editarfornecedor(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarfornecedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
