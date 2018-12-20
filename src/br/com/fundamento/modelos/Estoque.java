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
public class Estoque {
    
    private List<Produto> produtos;
    private List<SaidaEstoque> saidasEstoque;
    private String descricao;
    private int id;
     
    public Estoque(){}

    /**
     * @return the produtos
     */
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * @return the saidasEstoque
     */
    public List<SaidaEstoque> getSaidasEstoque() {
        return saidasEstoque;
    }

    /**
     * @param saidasEstoque the saidasEstoque to set
     */
    public void setSaidasEstoque(List<SaidaEstoque> saidasEstoque) {
        this.saidasEstoque = saidasEstoque;
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


}
