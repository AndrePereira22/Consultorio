/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import br.com.fundamento.enuns.TipoDocumento;

/**
 *
 * @author prof Heldon
 */
public class Produto {

   
    private String nome;
    private String fabricante;
    private int quantidade_estoque;
    private int quantidade_minima;
    private double preco_compra;
    
    private Fornecedor fornecedor;
    private Estoque estoque;

    


    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }


    /**
     * @return the quantidade_estoque
     */
    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    /**
     * @param quantidade_estoque the quantidade_estoque to set
     */
    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    /**
     * @return the quantidade_minima
     */
    public int getQuantidade_minima() {
        return quantidade_minima;
    }

    /**
     * @param quantidade_minima the quantidade_minima to set
     */
    public void setQuantidade_minima(int quantidade_minima) {
        this.quantidade_minima = quantidade_minima;
    }

    /**
     * @return the preco_compra
     */
    public double getPreco_compra() {
        return preco_compra;
    }

    /**
     * @param preco_compra the preco_compra to set
     */
    public void setPreco_compra(double preco_compra) {
        this.preco_compra = preco_compra;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the estoque
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    
    
    
    
}
