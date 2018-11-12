/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoCliente;
import br.com.fundamento.dao.IDaoCliente;
import br.com.fundamento.modelos.Cliente;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class BusinessCliente implements IBusinessCliente{

    IDaoCliente daoCliente;
    
    public BusinessCliente(){
        this.daoCliente = new DaoCliente();
    }
    
    
    @Override
    public void salvar(Cliente cliente) {
            if ( !(cliente.getNome().split(" ").length >1)){
                //não validado
            }
            if(cliente.getCpf().length()>11){
                //não validado
            }
            
            this.daoCliente.salvar(cliente);
    
    
    }

    @Override
    public Cliente buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
