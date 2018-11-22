/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoMedico;
import br.com.fundamento.dao.IDaoMedico;
import br.com.fundamento.modelos.Medico;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessMedico implements IBusinessMedico{
    
    IDaoMedico daoMedico;
    
    public BusinessMedico(){
        this.daoMedico = new DaoMedico();
    }

    @Override
    public void salvarMedico(Medico medico) {
       this.daoMedico.salvarMedico(medico);
    }

    @Override
    public Medico buscarMedicoPorId(int id) {
        return this.daoMedico.buscarMedicoPorId(id);
    }

    @Override
    public List<Medico> getAllMedico() {
       return this.daoMedico.getAllMedico();
    }

    @Override
    public void editarMedico(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
