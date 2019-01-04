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
public class EntradaEstoque {
    
      
    private String data;
    private int quantidade_entrada;
    private Produto produto;
    
    private int id_produto;

    public EntradaEstoque() {
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
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the quantidade_entrada
     */
    public int getQuantidade_entrada() {
        return quantidade_entrada;
    }

    /**
     * @param quantidade_entrada the quantidade_entrada to set
     */
    public void setQuantidade_entrada(int quantidade_entrada) {
        this.quantidade_entrada = quantidade_entrada;
    }
    
    
    
}
