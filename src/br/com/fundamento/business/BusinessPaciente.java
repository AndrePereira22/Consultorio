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
     return this.daoPaciente.getAllPaciente();
    }

    @Override
    public void editarPaciente(Paciente paciente) {
     this.daoPaciente.editarPaciente(paciente);
    }

    @Override
    public void ativarDesativarPaciente(int id) {
        this.daoPaciente.ativarDesativarPaciente(id);
    }

    @Override
    public List<Paciente> getPorBusca(String busca) {
     return this.daoPaciente.getPorBusca(busca);
    }

    @Override
    public Paciente buscarPaciente(String busca) {
         return this.daoPaciente.buscarPaciente(busca);
    }
    

}
