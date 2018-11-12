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
    private String relatorios;
    
    private Medico medico;
    private Paciente paciente;
    
    
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
     * @return the relatorios
     */
    public String getRelatorios() {
        return relatorios;
    }

    /**
     * @param relatorios the relatorios to set
     */
    public void setRelatorios(String relatorios) {
        this.relatorios = relatorios;
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
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
}
