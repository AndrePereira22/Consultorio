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
    
    private String nome;
    private String sigla;
    
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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
}
