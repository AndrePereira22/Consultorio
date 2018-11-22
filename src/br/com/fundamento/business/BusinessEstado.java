/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoEstado;
import br.com.fundamento.dao.IDaoEstado;
import br.com.fundamento.modelos.Estado;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessEstado implements IBusinessEstado{
    
    IDaoEstado daoEstado;
    
    public BusinessEstado(){
        this.daoEstado = new DaoEstado();
    }

    @Override
    public void salvarEstado(Estado estado) {
        this.daoEstado.salvarEstado(estado);
   }

    @Override
    public Estado buscarEstadoPorId(int id) {
        return this.daoEstado.buscarEstadoPorId(id);
    }

    @Override
    public List<Estado> getAllEstado() {
        return this.daoEstado.getAllEstado();
    }

    @Override
    public void editarEstado(Estado estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEstado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
