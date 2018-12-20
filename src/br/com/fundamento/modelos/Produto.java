/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;


/**
 *
 * @author prof Heldon
 */
public class Produto {

   
    private String nome;
    private String fabricante;
    private int quantidade_estoque;
    private double preco_compra;
    private int id;
    private int id_fornecedor;
    private int id_estoque;
    
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
     * @return the id_fornecedor
     */
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    /**
     * @param id_fornecedor the id_fornecedor to set
     */
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the id_estoque
     */
    public int getId_estoque() {
        return id_estoque;
    }

    /**
     * @param id_estoque the id_estoque to set
     */
    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    
    
    
    
}
