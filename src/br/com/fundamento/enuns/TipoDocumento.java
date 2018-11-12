/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.enuns;

/**
 *
 * @author prof Heldon
 */
public enum TipoDocumento {
    RG("RG"),
    CPF("CPF");
    private String descricao;

    private TipoDocumento(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return this.descricao;
    }

}
