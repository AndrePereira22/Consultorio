/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Cliente;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IBusinessCliente {
     public void salvar(Cliente cliente);
    public Cliente buscarPorId(int id);
    public List<Cliente> getAll();
    public void editar(Cliente cliente);
    public void ativarDesativar(int id);
}
