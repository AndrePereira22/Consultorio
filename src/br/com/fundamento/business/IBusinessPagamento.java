/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Pagamento;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessPagamento {
     public void salvarPagamento(Pagamento pagamento);
    public Pagamento buscarPagamentoPorId(int id);
    public List<Pagamento> getAllPagamento();
    public void editarPagamento(Pagamento pagamento);
    public void ativarDesativarPagamento(int id);
    
}
