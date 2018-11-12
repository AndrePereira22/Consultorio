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
public class Parcela {
    
    private int id;
    private double valor;
    private Date data_vencimento;
    private boolean  status;
    private String tipo;
    private int numero;
    private boolean parcela_unica;
    
    private  Pagamento pagamento;
    
    
    public Parcela(){
        
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
     * @return the data_vencimento
     */
    public Date getData_vencimento() {
        return data_vencimento;
    }

    /**
     * @param data_vencimento the data_vencimento to set
     */
    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the parcela_unica
     */
    public boolean isParcela_unica() {
        return parcela_unica;
    }

    /**
     * @param parcela_unica the parcela_unica to set
     */
    public void setParcela_unica(boolean parcela_unica) {
        this.parcela_unica = parcela_unica;
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
}
