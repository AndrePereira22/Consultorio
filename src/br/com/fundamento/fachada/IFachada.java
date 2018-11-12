/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.fachada;

import br.com.fundamento.modelos.Cliente;
import br.com.fundamento.modelos.Produto;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IFachada {

    public void salvarCliente(Cliente cliente);

    public Cliente buscarClientePorId(int id);

    public List<Cliente> getAllClientes();

    public void editarCliente(Cliente cliente);

    public void ativarDesativarCliente(int id);

    public void salvarProduto(Produto produto);

    public Produto buscarProdutoPorId(int id);

    public List<Produto> getAllProdutos();

    public void editarProduto(Produto produto);

    public void ativarDesativarProduto(int id);

}
