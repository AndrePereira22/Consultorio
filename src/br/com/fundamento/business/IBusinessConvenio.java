/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Convenio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessConvenio {
    
    public void salvarConvenio(Convenio convenio);
    public Convenio buscarConvenioPorId(int id);
    public List<Convenio> getAllConvenio();
    public void editarConvenio(Convenio convenio);
    public void ativarDesativarConvenio(int id);
    
}
