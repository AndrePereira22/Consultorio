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
public class Tarefa {
    
    private int id;
    private Date date_inicio;
    private Date date_termino;
    private String descricao;
    private int prioridade;
    private boolean status;
    
    private Funcionario funcionario;
    
    public Tarefa(){
        
    }

    /**
     * @return the date_inicio
     */
    public Date getDate_inicio() {
        return date_inicio;
    }

    /**
     * @param date_inicio the date_inicio to set
     */
    public void setDate_inicio(Date date_inicio) {
        this.date_inicio = date_inicio;
    }

    /**
     * @return the date_termino
     */
    public Date getDate_termino() {
        return date_termino;
    }

    /**
     * @param date_termino the date_termino to set
     */
    public void setDate_termino(Date date_termino) {
        this.date_termino = date_termino;
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
     * @return the prioridade
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
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
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
