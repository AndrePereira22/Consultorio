/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Login;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessLogin {
      public void salvarLogin(Login login);
    public Login buscarLoginPorId(int id);
    public List<Login> getAllLogin();
    public void editarLogin(Login login);
    public void ativarDesativarLogin(int id);
        public Login buscarLogin(String nome);
    
    
}
