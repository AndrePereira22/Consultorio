/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import br.com.fundamento.enuns.TipoContato;

/**
 *
 * @author prof Heldon
 */
public class Contato {

    private TipoContato tipo;
    private String descricao;

    public Contato() {
    }

    public TipoContato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContato tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" +  " tipo=" + tipo + ", descricao=" + descricao + '}';
    }
    
    

}
