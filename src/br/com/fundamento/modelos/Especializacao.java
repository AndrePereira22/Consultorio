/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.Calendar;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Especializacao {
    
    private String descricao;
    private  String horario_disponivel;
    private double  salario;
    private int id;
    
    private Medico medico;
    
    
    
    public Especializacao(){
        
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the horario_disponivel
     */
    public String getHorario_disponivel() {
        return horario_disponivel;
    }

    /**
     * @param horario_disponivel the horario_disponivel to set
     */
    public void setHorario_disponivel(String horario_disponivel) {
        this.horario_disponivel = horario_disponivel;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

   
    
}
