/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

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
    private String  data;
    private int id;
    private Funcionario  funcionario;       
    
    private List<Pagamento> pagamentos;
    
          
    public Caixa(){
        
      
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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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
