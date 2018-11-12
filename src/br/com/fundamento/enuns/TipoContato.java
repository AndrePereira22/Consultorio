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
public enum TipoContato {
    EMAIL("EMAIL"),
    TELEFONE("TELEFONE"),
    FACEBOOK("FACEBOOK");
    private String descricao;

    private TipoContato(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return this.descricao;
    }

}
