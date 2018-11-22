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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarEspecializacao(Especializacao especializacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEspecializacao(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
