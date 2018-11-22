/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.dao.DaoRelatorio;
import br.com.fundamento.dao.IDaoRelatorio;
import br.com.fundamento.modelos.Relatorio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BusinessRelatorio implements IBusinessRelatorio {

    IDaoRelatorio daoRelatorio;
    
    public BusinessRelatorio(){
        this.daoRelatorio = new DaoRelatorio();
    }
    
    @Override
    public void salvar(Relatorio relatorio) {
       this.daoRelatorio.salvar(relatorio);
    }

    @Override
    public Relatorio buscarPorId(int id) {
        return this.daoRelatorio.buscarPorId(id);
    }

    @Override
    public List<Relatorio> getAll() {
       return this.daoRelatorio.getAll();
    }

    @Override
    public void editar(Relatorio relatroio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
