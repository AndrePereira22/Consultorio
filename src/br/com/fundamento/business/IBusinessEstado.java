/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Estado;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessEstado {
    
     public void salvarEstado(Estado estado);
    public Estado buscarEstadoPorId(int id);
    public List<Estado> getAllEstado();
    public void editarEstado(Estado estado);
    public void ativarDesativarEstado(int id);
}
