/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoMunicipio;
import br.com.fundamento.dao.IDaoMunicipio;
import br.com.fundamento.modelos.Municipio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessMunicipio implements IBusinessMunicipio{
    
    IDaoMunicipio daoMunicipio;
    
    public BusinessMunicipio(){
        this.daoMunicipio = new DaoMunicipio();
    }

    @Override
    public void salvarMunicipio(Municipio municipio) {
        this.daoMunicipio.salvarMunicipio(municipio);
    }

    @Override
    public Municipio buscarMunicipioPorId(int id) {
        return this.daoMunicipio.buscarMunicipioPorId(id);
    }

    @Override
    public List<Municipio> getAllMunicipio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarMunicipio(Municipio municipio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarMunicipio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
