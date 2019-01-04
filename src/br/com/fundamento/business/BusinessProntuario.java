/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoProntuario;
import br.com.fundamento.dao.IDaoProntuario;
import br.com.fundamento.modelos.Prontuario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessProntuario implements IBusinessProntuario{
    
    IDaoProntuario daoProntuario;
    
    public BusinessProntuario (){
        this.daoProntuario = new DaoProntuario();
    }

    @Override
    public void salvarProntuario(Prontuario prontuario) {
       this.daoProntuario.salvarProntuario(prontuario);
    }

    @Override
    public Prontuario buscarProntuarioPorId(int id) {
        return this.daoProntuario.buscarProntuarioPorId(id);
    }

    @Override
    public List<Prontuario> getAllProntuario() {
        return this.daoProntuario.getAllProntuario();
    }

    @Override
    public void editarProntuario(Prontuario prontuario) {
    this.daoProntuario.editarProntuario(prontuario);
    }

    @Override
    public void ativarDesativarProntuario(int id) {
      this.daoProntuario.ativarDesativarProntuario(id);
    }

    @Override
    public Prontuario buscarProntuario(String busca) {
      return  this.daoProntuario.buscarProntuario(busca);
    }
    
}
