/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Relatorio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoRelatorio {
    
    public void salvar(Relatorio relatorio);
    public Relatorio  buscarPorId(int id);
    public List<Relatorio> getAll();
    public void editar(Relatorio relatroio);
    public void ativarDesativar(int id);
    
}
