/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoContaPagar;
import br.com.fundamento.dao.IDaoContaPagar;
import br.com.fundamento.modelos.ContaPagar;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessContaPagar implements IBusinessContaPagar{
    
     IDaoContaPagar daoContaPagar;
    
    
    public BusinessContaPagar(){
        this.daoContaPagar = new DaoContaPagar();
    }

    @Override
    public void salvarContaPagar(ContaPagar contaPagar) {
       this.daoContaPagar.salvarContaPagar(contaPagar);
               }

    @Override
    public ContaPagar buscarContaPagarPorId(int id) {
   return  this.daoContaPagar.buscarContaPagarPorId(id);
    }

    @Override
    public List<ContaPagar> getAllContaPagar() {
   return this.daoContaPagar.getAllContaPagar();
    }

    @Override
    public void editarContaPagar(ContaPagar contaPagar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarContaPagar(int id) {
    this.daoContaPagar.ativarDesativarContaPagar(id);
    }
    
}
