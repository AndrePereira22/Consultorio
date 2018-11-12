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
public class Especializacao {
    
    private String descricao;
    private int horario_disponivel;
    private float  salario;
    
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
     * @return the horario_disponivel
     */
    public int getHorario_disponivel() {
        return horario_disponivel;
    }

    /**
     * @param horario_disponivel the horario_disponivel to set
     */
    public void setHorario_disponivel(int horario_disponivel) {
        this.horario_disponivel = horario_disponivel;
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
    
}
