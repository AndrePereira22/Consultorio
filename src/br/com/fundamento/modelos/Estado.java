/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Estado {
    
    private List<Municipio> municipios;
    
    
    public Estado(){}

    /**
     * @return the municipios
     */
    public List<Municipio> getMunicipios() {
        return municipios;
    }

    /**
     * @param municipios the municipios to set
     */
    public void setMunicipios(List<Municipio> municipios) {
        this.municipios = municipios;
    }
    
}
