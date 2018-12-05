/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Especializacao;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoEspecializacao {
    
    public void salvarEspecializacao(Especializacao especializacao);
    public Especializacao buscarEspecializacaoPorId(int id);
    public List<Especializacao> getAllEspecializacao();
    public void editarEspecializacao(Especializacao especializacao);
    public void ativarDesativarEspecializacao(int id);
     public Especializacao buscarEspecializaco(String busca) ;
    
}
