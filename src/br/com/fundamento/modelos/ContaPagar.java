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
public class ContaPagar {

    private String data;
    private String descricao;
    private double valor;
    private int id;
    private String data_pagamento;
    private Consultorio consultorio;

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
     * @return the consultorio
     */
    public Consultorio getConsultorio() {
        return consultorio;
    }

    /**
     * @param consultorio the consultorio to set
     */
    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
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
