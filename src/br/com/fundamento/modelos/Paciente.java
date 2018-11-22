/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Paciente {
    
    
    
    private String nome;
    private Calendar data_nascimento;
    private Calendar data_cadastro;
    private String cpf;
    private String sexo;
    private int rg;
    
  
    private Convenio convenio;
    private Prontuario prontuario;
     private Endereco endereco;
    private List<Contato> contatos;
    private List<Consulta> consultas;
   
    
    
    public Paciente (){
        this.data_nascimento = Calendar.getInstance();
        this.data_cadastro = Calendar.getInstance();
        
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
public String getData_nascimentoString() {
    
        return "";
    }
   
    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the data_cadastro
     */
    public Calendar getData_cadastro() {
        return data_cadastro;
    }
    
       public String getDate_cadastroString() {
        String d =  this.data_cadastro.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_cadastro.get(Calendar.MONTH)+"/"+ this.data_cadastro.get(Calendar.YEAR);
        return d;
    }

   
    public void setDate_cadastroInt(int dia,int mes, int ano) {
        this.data_cadastro.set(ano, mes, dia);
    }
    
     public String getDate_nascimentoString() {
        String d =  this.data_nascimento.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_nascimento.get(Calendar.MONTH)+"/"+ this.data_nascimento.get(Calendar.YEAR);
        return d;
    }

   
    public void setDate_nascimentoInt(int dia,int mes, int ano) {
        this.data_nascimento.set(ano, mes, dia);
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

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the contatos
     */
    public List<Contato> getContatos() {
        return contatos;
    }

    /**
     * @param contatos the contatos to set
     */
    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    /**
     * @return the consultas
     */
    public List<Consulta> getConsultas() {
        return consultas;
    }

    /**
     * @param consultas the consultas to set
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    
}