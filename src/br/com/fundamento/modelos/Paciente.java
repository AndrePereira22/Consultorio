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
public class Paciente {
 
    private String nome;
    private String data_nascimento;
    private String data_cadastro;
    private String cpf;
    private String sexo;
    private String rg;
    private String convenio;
    private int id;
    private int id_endereco;
    private int id_contato;
    private List<Prontuario> prontuarios;
     private Endereco endereco;
     private Contato contato;
    
   
    


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
     * @return the contato
     */
    public Contato getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /**
     * @return the data_nascimento
     */
    public String getData_nascimento() {
        return data_nascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    /**
     * @return the data_cadastro
     */
    public String getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the convenio
     */
    public String getConvenio() {
        return convenio;
    }

    /**
     * @param convenio the convenio to set
     */
    public void setConvenio(String convenio) {
        this.convenio = convenio;
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

    /**
     * @return the id_endereco
     */
    public int getId_endereco() {
        return id_endereco;
    }

    /**
     * @param id_endereco the id_endereco to set
     */
    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    /**
     * @return the id_contato
     */
    public int getId_contato() {
        return id_contato;
    }

    /**
     * @param id_contato the id_contato to set
     */
    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

   

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the prontuarios
     */
    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    /**
     * @param prontuarios the prontuarios to set
     */
    public void setProntuarios(List<Prontuario> prontuarios) {
        this.prontuarios = prontuarios;
    }

    
}