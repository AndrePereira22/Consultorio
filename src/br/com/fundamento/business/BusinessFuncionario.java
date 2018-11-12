/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoFuncionario;
import br.com.fundamento.dao.IDaoFuncionario;
import br.com.fundamento.modelos.Funcionario;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessFuncionario implements IBusinnesFuncionario{

    IDaoFuncionario daoFuncionario;
    
    @Override
    public void salvar(Funcionario funcionario) {
       this.daoFuncionario = new DaoFuncionario();
    }

    @Override
    public Funcionario buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
