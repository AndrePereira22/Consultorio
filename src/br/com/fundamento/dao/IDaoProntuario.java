/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Prontuario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoProntuario {
    
     public int salvarProntuario(Prontuario prontuario);
    public Prontuario buscarProntuarioPorId(int id);
    public List<Prontuario> getAllProntuario();
    public void editarProntuario(Prontuario prontuario);
    public void ativarDesativarProntuario(int id);
    public Prontuario buscarProntuario(String busca);
    
    
}
