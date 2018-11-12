/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Funcionario {
    
  
    private String senha;
    private String nome;
    private int cpf;
    private Date data_nascimento;
    private float salario;
    
    private Endereco endereco;
    private Caixa caixa;
    private Estoque estoque;
    private Login usuario;
    
    private List<Tarefa> tarefas;
    private List<Contato> contatos;
    private List<Relatorio> relatorios;
    private List<Consulta> consultas;
    private List<Funcao> funcoes;
   
   public Funcionario(){}

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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
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
     * @return the estoque
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
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
     * @return the funcoes
     */
    public List<Funcao> getFuncoes() {
        return funcoes;
    }

    /**
     * @param funcoes the funcoes to set
     */
    public void setFuncoes(List<Funcao> funcoes) {
        this.funcoes = funcoes;
    }

   
   
     
}
