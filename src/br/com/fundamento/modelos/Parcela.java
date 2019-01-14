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
public class Parcela {
    

    private double valor;
    private String data_vencimento;
    private boolean  status;
    private int numero;
    private int id;
    private String data_pagamento;
    
    private  Pagamento pagamento;
    
    
    public Parcela(){
        
    }


    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
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

    /**
     * @return the pagamento
     */
    public Pagamento getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the data_vencimento
     */
    public String getData_vencimento() {
        return data_vencimento;
    }

    /**
     * @param data_vencimento the data_vencimento to set
     */
    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
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
     * @return the data_pagamento
     */
    public String getData_pagamento() {
        return data_pagamento;
    }

    /**
     * @param data_pagamento the data_pagamento to set
     */
    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

   
}
