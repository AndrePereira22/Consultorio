/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoEstoque;
import br.com.fundamento.dao.IDaoEstoque;
import br.com.fundamento.modelos.Estoque;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessEstoque implements IBusinessEstoque{
    
     IDaoEstoque daoEstoque;
    public BusinessEstoque () {
        this.daoEstoque = new DaoEstoque();
    }

    @Override
    public void salvarEstoque(Estoque estoque) {
        this.daoEstoque.salvarEstoque(estoque);
     }

    @Override
    public Estoque buscarPorEstoqueId(int id) {
       return this.daoEstoque.buscarEstoquePorId(id);
    }

    @Override
    public List<Estoque> getAllEstoque() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarEstoque(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
