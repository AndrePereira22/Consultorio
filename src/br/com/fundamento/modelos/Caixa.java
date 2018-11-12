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
public class Caixa {
    
    private int id;
    private int numero;
    private Date date_abertura;
    private Date date_fechamento;
    private float valor_receita;
    
    private List<Funcionario> funcionarios;
    private List<Pagamento> pagamentos;
    
    
            
    public Caixa(){}

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
     * @return the date_abertura
     */
    public Date getDate_abertura() {
        return date_abertura;
    }

    /**
     * @param date_abertura the date_abertura to set
     */
    public void setDate_abertura(Date date_abertura) {
        this.date_abertura = date_abertura;
    }

    /**
     * @return the date_fechamento
     */
    public Date getDate_fechamento() {
        return date_fechamento;
    }

    /**
     * @param date_fechamento the date_fechamento to set
     */
    public void setDate_fechamento(Date date_fechamento) {
        this.date_fechamento = date_fechamento;
    }

    /**
     * @return the valor_receita
     */
    public float getValor_receita() {
        return valor_receita;
    }

    /**
     * @param valor_receita the valor_receita to set
     */
    public void setValor_receita(float valor_receita) {
        this.valor_receita = valor_receita;
    }

    /**
     * @return the funcionarios
     */
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    /**
     * @param funcionarios the funcionarios to set
     */
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
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
    
    
}
