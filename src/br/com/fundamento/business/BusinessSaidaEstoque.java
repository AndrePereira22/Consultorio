/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoSaidaEstoque;
import br.com.fundamento.dao.IDaoSaidaEstoque;
import br.com.fundamento.modelos.SaidaEstoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessSaidaEstoque implements IBusinessSaidaEstoque{
    
    IDaoSaidaEstoque daoSaidaEstoque;
    
    
    public BusinessSaidaEstoque(){
        this.daoSaidaEstoque = new DaoSaidaEstoque();
    }

    @Override
    public void salvarSaidaEstoque(SaidaEstoque saidaEstoque) {
       this.daoSaidaEstoque.salvarSaidaEstoque(saidaEstoque);
    }

    @Override
    public SaidaEstoque buscarSaidaEstoquePorId(int id) {
       return this.daoSaidaEstoque.buscarSaidaEstoquePorId(id);
    }

    @Override
    public List<SaidaEstoque> getAllSaidaEstoque() {
        return this.daoSaidaEstoque.getAllSaidaEstoque();
    }

    @Override
    public void editarSaidaEstoque(SaidaEstoque saidaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarSaidaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
