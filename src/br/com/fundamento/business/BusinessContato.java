/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoContato;
import br.com.fundamento.dao.IDaoContato;
import br.com.fundamento.modelos.Contato;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessContato implements IBusinessContato{
    
    IDaoContato daoContato;
    
    public BusinessContato(){
        this.daoContato = new DaoContato();
    }
    

    @Override
    public void salvarContato(Contato contato) {
      this.daoContato.salvarContato(contato);
    }

    @Override
    public Contato buscarContatoPorId(int id) {
        return this.daoContato.buscarContatoPorId(id);
    }

    @Override
    public List<Contato> getAllContato() {
        return  this.daoContato.getAllContato();
    }

    @Override
    public void editarContato(Contato contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarContato(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
