/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoEntradaEstoque;
import br.com.fundamento.dao.DaoSaidaEstoque;
import br.com.fundamento.dao.IDaoEntradaEstoque;
import br.com.fundamento.dao.IDaoSaidaEstoque;
import br.com.fundamento.modelos.EntradaEstoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessEntradaEstoque implements IBusinessEntradaEstoque{
    
  IDaoEntradaEstoque daoEntradaEstoque;
    
    
    public BusinessEntradaEstoque(){
        this.daoEntradaEstoque = new DaoEntradaEstoque();
    }

    @Override
    public void salvarEntradaEstoque(EntradaEstoque entradaEstoque) {
   this.daoEntradaEstoque.salvarEntradaEstoque(entradaEstoque);
    }

    @Override
    public EntradaEstoque buscarEntradaEstoquePorId(int id) {
     return this.daoEntradaEstoque.buscarEntradaEstoquePorId(id);
    }

    @Override
    public List<EntradaEstoque> getAllEntradaEstoque() {
     return this.daoEntradaEstoque.getAllEntradaEstoque();
    }

    @Override
    public void editarEntradaEstoque(EntradaEstoque entradaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEntradaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntradaEstoque> getPorBuscaEntradaEstoque(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
