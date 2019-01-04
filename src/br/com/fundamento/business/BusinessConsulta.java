/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoConsulta;
import br.com.fundamento.dao.IDaoConsulta;
import br.com.fundamento.modelos.Consulta;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessConsulta implements IBusinessConsulta{
    
    IDaoConsulta daoConsulta;
    
    public BusinessConsulta(){
        this.daoConsulta = new DaoConsulta();
    }

    @Override
    public void salvarConsulta(Consulta consulta) {
    this.daoConsulta.salvarConsulta(consulta);
    }

    @Override
    public Consulta buscarConsultaPorId(int id) {
       return this.daoConsulta.buscarConsultaPorId(id);
    }

    @Override
    public List<Consulta> getAllConsulta() {
        return this.daoConsulta.getAllConsulta();
    }

    @Override
    public void editarConsulta(Consulta consulta) {
     this.daoConsulta.editarConsulta(consulta);
    }

    @Override
    public void ativarDesativarConsulta(int id) {
     this.daoConsulta.ativarDesativarConsulta(id);
    }

    @Override
    public List<Consulta> getPorBuscaConsulta(String busca) {
       return this.daoConsulta.getPorBuscaConsulta(busca);
    }
    
    
}
