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
public class Medico {
    
    private String nome;
    private String data_nascimento;
    private String data_cadastro;
    private String cpf;
    private String sexo;
    private String rg;
    private String conselho;
    private int numero;
    private int id;
    private int id_end;
    private int id_contato;
    private int id_login;
    private int id_esp;
   
    private Especializacao especializacao;
    
    
    private Login login;
    private Endereco endereco;
    private Contato contato;
    
    
    
    public Medico (){
        
        
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
     * @return the login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
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
     * @return the id_end
     */
    public int getId_end() {
        return id_end;
    }

    /**
     * @param id_end the id_end to set
     */
    public void setId_end(int id_end) {
        this.id_end = id_end;
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
     * @param id_login the id_login to set
     */
    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    /**
     * @return the id_login
     */
    public int getId_login() {
        return id_login;
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
     * @return the especializacao
     */
    public Especializacao getEspecializacao() {
        return especializacao;
    }

    /**
     * @param especializacao the especializacao to set
     */
    public void setEspecializacao(Especializacao especializacao) {
        this.especializacao = especializacao;
    }

    /**
     * @return the id_esp
     */
    public int getId_esp() {
        return id_esp;
    }

    /**
     * @param id_esp the id_esp to set
     */
    public void setId_esp(int id_esp) {
        this.id_esp = id_esp;
    }

    /**
     * @return the conselho
     */
    public String getConselho() {
        return conselho;
    }

    /**
     * @param conselho the conselho to set
     */
    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
            
    
}
