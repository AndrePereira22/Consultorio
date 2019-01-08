/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoPagamento;
import br.com.fundamento.dao.IDaoPagamento;
import br.com.fundamento.modelos.Pagamento;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessPagamento implements IBusinessPagamento{
    IDaoPagamento daoPagamento;
    
    public BusinessPagamento(){
        this.daoPagamento = new DaoPagamento();
    }

    @Override
    public void salvarPagamento(Pagamento pagamento) {
        this.daoPagamento.salvarPagamento(pagamento);
    }

    @Override
    public Pagamento buscarPagamentoPorId(int id) {
        return this.daoPagamento.buscarPagamentoPorId(id);
    }

    @Override
    public List<Pagamento> getAllPagamento() {
    return this.daoPagamento.getAllPagamento();
    }

    @Override
    public void editarPagamento(Pagamento pagamento) {
    this.daoPagamento.editarPagamento(pagamento);
    }

    @Override
    public void ativarDesativarPagamento(int id) {
    this.daoPagamento.ativarDesativarPagamento(id);
    }
     
}
