/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.ContaPagar;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessContaPagar {
    
    public void salvarContaPagar(ContaPagar contaPagar);
    public ContaPagar buscarContaPagarPorId(int id);
    public List<ContaPagar> getAllContaPagar();
    public void editarContaPagar(ContaPagar contaPagar);
    public void ativarDesativarContaPagar(int id);
    
}
