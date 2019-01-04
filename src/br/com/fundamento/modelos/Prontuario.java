/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Prontuario {

    private String exames;
    private String receitas;
    private String sintomas;
    private String Data;
    
    
    
    
    public Prontuario(){
        
    }

    /**
     * @return the exames
     */
    public String getExames() {
        return exames;
    }

    /**
     * @param exames the exames to set
     */
    public void setExames(String exames) {
        this.exames = exames;
    }

    /**
     * @return the receitas
     */
    public String getReceitas() {
        return receitas;
    }

    /**
     * @param receitas the receitas to set
     */
    public void setReceitas(String receitas) {
        this.receitas = receitas;
    }

    /**
     * @return the sintomas
     */
    public String getSintomas() {
        return sintomas;
    }

    /**
     * @param sintomas the sintomas to set
     */
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(String Data) {
        this.Data = Data;
    }

   



    
}
