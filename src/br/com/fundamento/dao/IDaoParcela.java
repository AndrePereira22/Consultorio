/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Parcela;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoParcela {
      public void salvarParcela(Parcela parcela);
    public Parcela buscarParcelaPorId(int id);
    public List<Parcela> getAllParcela();
    public void editarParcela(Parcela parcela);
    public void ativarDesativarParcela(int id);
    
}
