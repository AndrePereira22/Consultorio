/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoConsultorio;
import br.com.fundamento.dao.IDaoConsultorio;
import br.com.fundamento.modelos.Consultorio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessConsultorio implements IBusinessConsultorio{
    IDaoConsultorio daoConsultorio;
    
    public BusinessConsultorio (){
        this.daoConsultorio = new DaoConsultorio();
    }
    

    @Override
    public void salvarConsultorio(Consultorio consultorio) {
        this.daoConsultorio.salvarConsultorio(consultorio);
    }

    @Override
    public Consultorio buscarConsultorioPorId(int id) {
       return  this.daoConsultorio.buscarConsultorioPorId(id);
    }

    @Override
    public List<Consultorio> getAllConsultorio() {
       return  this.daoConsultorio.getAllConsultorio();
    }

    @Override
    public void editarConsultorio(Consultorio consultorio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarConsultorio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
