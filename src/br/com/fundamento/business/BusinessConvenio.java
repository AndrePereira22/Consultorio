/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoConvenio;
import br.com.fundamento.dao.IDaoConvenio;
import br.com.fundamento.modelos.Convenio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessConvenio implements IBusinessConvenio{
    IDaoConvenio daoConvenio;
     public BusinessConvenio(){
         this.daoConvenio = new DaoConvenio();
     }

    @Override
    public void salvarConvenio(Convenio convenio) {
       this.daoConvenio.salvarConvenio(convenio);}

    @Override
    public Convenio buscarConvenioPorId(int id) {
        return this.daoConvenio.buscarConvenioPorId(id);
    }

    @Override
    public List<Convenio> getAllConvenio() {
        return this.daoConvenio.getAllConvenio();
    }

    @Override
    public void editarConvenio(Convenio convenio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarConvenio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
