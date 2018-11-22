/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Parcela {
    

    private double valor;
    private Calendar data_vencimento;
    private boolean  status;
    private int numero;
    private boolean parcela_unica;
    
    private  Pagamento pagamento;
    
    
    public Parcela(){
        data_vencimento = Calendar.getInstance();
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

    /**
     * @return the data_vencimento
     */
    public String getData_vencimento() {
         String d =  this.data_vencimento.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_vencimento.get(Calendar.MONTH)+"/"+ this.data_vencimento.get(Calendar.YEAR);
        return d;
    }

    /**
     * @param data_vencimento the data_vencimento to set
     */
    public void setData_vencimento(int dia,int mes, int ano) {
         this.data_vencimento.set(ano, mes, dia);
    }
}
