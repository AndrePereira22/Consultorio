/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoPaciente;
import br.com.fundamento.dao.IDaoPaciente;
import br.com.fundamento.modelos.Paciente;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessPaciente implements IBusinessPaciente{
    
      IDaoPaciente daoPaciente;
    
     public BusinessPaciente(){
        this.daoPaciente = new DaoPaciente();
    }

    @Override
    public void salvarPaciente(Paciente paciente) {
       this.daoPaciente.salvarPaciente(paciente);
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
       return this.daoPaciente.buscarPacientePorId(id);
    }

    @Override
    public List<Paciente> getAllPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
