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
public class SaidaEstoque {
    
    
  private String nome;
    private String fabricante;
    private int quantidade_saida;
    private Estoque estoque;
    
    public SaidaEstoque(){
        
    }

   

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
     * @return the quantidade_saida
     */
    public int getQuantidade_saida() {
        return quantidade_saida;
    }

    /**
     * @param quantidade_saida the quantidade_saida to set
     */
    public void setQuantidade_saida(int quantidade_saida) {
        this.quantidade_saida = quantidade_saida;
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
