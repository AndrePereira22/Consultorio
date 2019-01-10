/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoCaixa;
import br.com.fundamento.dao.IDaoCaixa;
import br.com.fundamento.modelos.Caixa;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessCaixa  implements IBusinessCaixa{
    
    IDaoCaixa daoCaixa ;
    
    public BusinessCaixa (){
        this.daoCaixa =  new DaoCaixa();
    }

    @Override
    public int salvarCaixa(Caixa caixa) {
      return this.daoCaixa.salvarCaixa(caixa);
    }

    @Override
    public Caixa buscarCaixaPorId(int id) {
        return this.daoCaixa.buscarCaixaPorId(id);
    }

    @Override
    public List<Caixa> getAllCaixa() {
       return this.daoCaixa.getAllCaixa();
    }

    @Override
    public void editarCaixa(Caixa caixa) {
   this.daoCaixa.editarCaixa(caixa);
    }

    @Override
    public void ativarDesativarCaixa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
