/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoEspecializacao;
import br.com.fundamento.dao.IDaoEspecializacao;
import br.com.fundamento.modelos.Especializacao;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessEspecializacao implements IBusinessEspecializacao{

    IDaoEspecializacao daoEspecializacao;
    
    public BusinessEspecializacao(){
        this.daoEspecializacao = new DaoEspecializacao();
    }
    
    @Override
    public void salvarEspecializacao(Especializacao especializacao) {
       this.daoEspecializacao.salvarEspecializacao(especializacao);
    }

    @Override
    public Especializacao buscarEspecializacaoPorId(int id) {
       return this.daoEspecializacao.buscarEspecializacaoPorId(id);
    }

    @Override
    public List<Especializacao> getAllEspecializacao() {
        return this.daoEspecializacao.getAllEspecializacao();
    }

    @Override
    public void editarEspecializacao(Especializacao especializacao) {
      this.daoEspecializacao.editarEspecializacao(especializacao);
    }

    @Override
    public void ativarDesativarEspecializacao(int id) {
      this.daoEspecializacao.ativarDesativarEspecializacao(id);
    }

    @Override
    public Especializacao buscarEspecializaco(String busca) {
        return this.daoEspecializacao.buscarEspecializaco(busca);
    }
    
}
