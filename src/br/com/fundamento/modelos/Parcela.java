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
    private boolean parcela_unica;
    
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
        return data_vencimento;
    }

    /**
     * @param data_vencimento the data_vencimento to set
     */
    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

   
}
