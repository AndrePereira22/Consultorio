/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoParcela;
import br.com.fundamento.dao.IDaoParcela;
import br.com.fundamento.modelos.Parcela;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessParcela implements IBusinessParcela{
    
    IDaoParcela daoParcela;
    
    public BusinessParcela(){
        this.daoParcela = new DaoParcela();
    }

    @Override
    public void salvarParcela(Parcela parcela) {
       this.daoParcela.salvarParcela(parcela);
    }

    @Override
    public Parcela buscarParcelaPorId(int id) {
       return this.daoParcela.buscarParcelaPorId(id);
    }

    @Override
    public List<Parcela> getAllParcela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarParcela(Parcela parcela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarParcela(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
