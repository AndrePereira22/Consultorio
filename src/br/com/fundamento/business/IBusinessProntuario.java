/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Prontuario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessProntuario {
    
     public void salvarProntuario(Prontuario prontuario);
    public Prontuario buscarProntuarioPorId(int id);
    public List<Prontuario> getAllProntuario();
    public void editarProntuario(Prontuario prontuario);
    public void ativarDesativarProntuario(int id);
    
    
}
