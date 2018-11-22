/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Municipio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessMunicipio {
     public void salvarMunicipio(Municipio municipio);
    public Municipio buscarMunicipioPorId(int id);
    public List<Municipio> getAllMunicipio();
    public void editarMunicipio(Municipio municipio);
    public void ativarDesativarMunicipio(int id);
    
}
