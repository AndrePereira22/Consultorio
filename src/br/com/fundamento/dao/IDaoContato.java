/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Contato;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoContato {
    
    public int salvarContato(Contato contato);
    public Contato  buscarContatoPorId(int id);
    public List<Contato> getAllContato();
    public void editarContato(Contato contato);
    public void ativarDesativarContato(int id);
    
}
