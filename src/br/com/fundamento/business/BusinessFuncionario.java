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
public class BusinessFuncionario implements IBusinessFuncionario{

    IDaoFuncionario daoFuncionario;
    
    public BusinessFuncionario(){
        this.daoFuncionario = new DaoFuncionario();
    }

    @Override
    public void salvarFuncionario(Funcionario funcionario) {
       this.daoFuncionario.salvarFuncionario(funcionario); 
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int id) {
        return this.daoFuncionario.buscarFuncionarioPorId(id);
    }

    @Override
    public List<Funcionario> getAllFuncionario() {
        return this.daoFuncionario.getAllFuncionario();
    }

    @Override
    public void editarFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
