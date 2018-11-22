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
public class Caixa {
    
    private int numero;
    private double  valor_abertura;
    private double valor_fechamento;
    private double valor_receita;
    private boolean  status;
    private Calendar  data;
    private List<Funcionario>  funcionarios;       
    
    private List<Pagamento> pagamentos;
    
    
            
    public Caixa(){
        
        this.data = Calendar.getInstance();
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
     * @return the valor_abertura
     */
    public double getValor_abertura() {
        return valor_abertura;
    }

    /**
     * @param valor_abertura the valor_abertura to set
     */
    public void setValor_abertura(double valor_abertura) {
        this.valor_abertura = valor_abertura;
    }

    /**
     * @return the valor_fechamento
     */
    public double getValor_fechamento() {
        return valor_fechamento;
    }

    /**
     * @param valor_fechamento the valor_fechamento to set
     */
    public void setValor_fechamento(double valor_fechamento) {
        this.valor_fechamento = valor_fechamento;
    }

    /**
     * @return the valor_receita
     */
    public double getValor_receita() {
        return valor_receita;
    }

    /**
     * @param valor_receita the valor_receita to set
     */
    public void setValor_receita(double valor_receita) {
        this.valor_receita = valor_receita;
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
     * @return the data
     */
    public String getData() {
        String d =  this.data.get(Calendar.DAY_OF_MONTH) +"/"+ this.data.get(Calendar.MONTH)+"/"+ this.data.get(Calendar.YEAR);
        return d;
    }

    /**
     * @param data the data to set
     */
    public void setData(int dia,int mes, int ano) {
         this.data.set(ano, mes, dia);
    }

    /**
     * @return the pagamentos
     */
    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    /**
     * @param pagamentos the pagamentos to set
     */
    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    /**
     * @return the funcionario
     */
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionarios(List<Funcionario> funcionario) {
        this.funcionarios = funcionario;
    }


    
    
    
}
