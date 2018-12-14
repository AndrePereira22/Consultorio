/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoLogin;
import br.com.fundamento.dao.DaoProduto;
import br.com.fundamento.dao.IDaoLogin;
import br.com.fundamento.modelos.Login;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessLogin implements  IBusinessLogin{
    
    IDaoLogin daoLogin;
    public BusinessLogin () {
        this.daoLogin = new DaoLogin();
    }

    @Override
    public void salvarLogin(Login login) {
        this.daoLogin.salvarLogin(login);
        }

    @Override
    public Login buscarLoginPorId(int id) {
        return this.daoLogin.buscarLoginPorId(id);
    }

    @Override
    public List<Login> getAllLogin() {
       return this.daoLogin.getAllLogin();
    }

    @Override
    public void editarLogin(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarLogin(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login buscarLogin(String nome) {
      return this.daoLogin.buscarLoginFuncionario(nome);
    }

    @Override
    public Login buscarLoginMedico(String parametro,String nome) {
       return this.daoLogin.buscarLoginMedico(parametro,nome);
    }
    
}
