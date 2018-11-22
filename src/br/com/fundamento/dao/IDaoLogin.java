/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Cliente;
import br.com.fundamento.modelos.Login;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoLogin {
    public int salvarLogin(Login login);
    public Login buscarLoginPorId(int id);
    public List<Login> getAllLogin();
    public void editarLogin(Login login);
    public void ativarDesativarLogin(int id);
    
}
