/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.Date;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Paciente {
    
    private String nome;
    private Date data_nascimento;
    private Date data_cadastro;
    private String cpf;
    private String sexo;
    private int rg;
    
  
    private Convenio convenio;
    private Prontuario prontuario;
    
    
    public Paciente (){
        
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
     * @return the usuario
     */
    

    /**
     * @return the senha
     */
   

    /**
     * @return the data_nascimento
     */
    public Date getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the rg
     */
    public int getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(int rg) {
        this.rg = rg;
    }

    /**
     * @return the convenio
     */
    public Convenio getConvenio() {
        return convenio;
    }

    /**
     * @param convenio the convenio to set
     */
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    /**
     * @return the prontuario
     */
    public Prontuario getProntuario() {
        return prontuario;
    }

    /**
     * @param prontuario the prontuario to set
     */
    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }
    
}
