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
public class Tarefa {
    
   
    private Calendar data_inicio;
    private Calendar data_termino ;
    private String descricao;
    private int prioridade;
    private boolean status;
    
    private Funcionario funcionario;
    
    public Tarefa(){
    data_inicio= Calendar.getInstance();
    data_termino =Calendar.getInstance();
        
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

   

    /**
     * @return the date_termino
     */
    public String getDate_terminoString() {
        String d =  this.data_termino.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_termino.get(Calendar.MONTH)+"/"+ this.data_termino.get(Calendar.YEAR);
        return d;
    }

   
    public void setDate_terminoInt(int dia,int mes, int ano) {
        this.data_termino.set(ano, mes, dia);
    }
    
    public String getDate_inicioString(){
        String d =  this.data_inicio.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_inicio.get(Calendar.MONTH)+"/"+ this.data_inicio.get(Calendar.YEAR);
        return d;
    }
    
     public void setDate_inicioInt(int dia,int mes, int ano) {
         this.data_inicio.set(ano, mes, dia);
    }

   
    
    
}
