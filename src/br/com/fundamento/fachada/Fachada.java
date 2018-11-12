/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.fachada;

import br.com.fundamento.business.BusinessCliente;
import br.com.fundamento.business.BusinessProduto;
import br.com.fundamento.business.IBusinessCliente;
import br.com.fundamento.business.IBusinessProduto;
import br.com.fundamento.modelos.Cliente;
import br.com.fundamento.modelos.Produto;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class Fachada implements IFachada {
    
    private static Fachada instance;
    private IBusinessCliente businessCliente;
    private IBusinessProduto businessProduto;
    
    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }
    
    private Fachada() {
        this.businessCliente = new BusinessCliente();
        this.businessProduto = new BusinessProduto();
    }
    
    @Override
    public void salvarCliente(Cliente cliente) {
        this.businessCliente.salvar(cliente);
    }
    
    @Override
    public Cliente buscarClientePorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Cliente> getAllClientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void editarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void ativarDesativarCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void salvarProduto(Produto produto) {
        this.businessProduto.salvar(produto);
    }
    
    @Override
    public Produto buscarProdutoPorId(int id) {
        return this.businessProduto.buscarPorId(id);
        
    }
    
    @Override
    public List<Produto> getAllProdutos() {
        return this.businessProduto.getAll();
    }
    
    @Override
    public void editarProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void ativarDesativarProduto(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
