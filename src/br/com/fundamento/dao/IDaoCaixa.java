/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Login;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoCaixa {
    
    public int salvarCaixa(Caixa caixa);
    public Caixa buscarCaixaPorId(int id);
    public List<Caixa> getAllCaixa();
    public void editarCaixa(Caixa caixa);
    public void ativarDesativarCaixa(int id);
    
}
