
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
public class Funcionario {

    private String nome;
    private int cpf;
    private Calendar data_nascimento;
    private float salario;
    private String funcao;

    private Endereco endereco;
    private Caixa caixa;
    private Login usuario;

    private List<Tarefa> tarefas;
    private List<Contato> contatos;
    private List<Relatorio> relatorios;
    private List<Consulta> consultas;
    private Login login;
    

    public Funcionario() {
         data_nascimento = Calendar.getInstance();
        
        
    }

    /**
     * @return the usuario
     */
    public Login getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Login usuario) {
        this.usuario = usuario;
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
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

     public String getDate_NascimentoString(){
        String d =  this.data_nascimento.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_nascimento.get(Calendar.MONTH)+"/"+ this.data_nascimento.get(Calendar.YEAR);
        return d;
    }
    
     public void setDate_nascimentoInt(int dia,int mes, int ano) {
         this.data_nascimento.set(ano, mes, dia);
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
     * @return the caixa
     */
    public Caixa getCaixa() {
        return caixa;
    }

    /**
     * @param caixa the caixa to set
     */
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    

    /**
     * @return the tarefas
     */
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    /**
     * @param tarefas the tarefas to set
     */
    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
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
     * @return the relatorios
     */
    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    /**
     * @param relatorios the relatorios to set
     */
    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
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

    /**
     * @return the funcao
     */
    public String getFuncao() {
        return funcao;
    }

    /**
     * @param funcao the funcao to set
     */
    public void setFuncao(String funcao) {
        this.funcao = funcao;
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

}
