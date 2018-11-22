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
    private Calendar horario_disponivel;
    private float  salario;
    
    private Medico medico;
    
    
    
    public Especializacao(){
        this.horario_disponivel= Calendar.getInstance();
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
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
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
         String d =  this.horario_disponivel.get(Calendar.HOUR_OF_DAY) + ":" + this.horario_disponivel.get(Calendar.MINUTE);
        return d;
    }

    /**
     * @param horario_disponivel the horario_disponivel to set
     */
    public void setHorario_disponivel(int hora,int minuto) {
    this.horario_disponivel.set(Calendar.YEAR, Calendar.DAY_OF_MONTH,Calendar.DAY_OF_MONTH, hora, minuto, 0);
       
        
    }
    
}
