/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.ContaPagar;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
import br.com.fundamento.view.FluxodeCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Glenda Alves de Lima
 */
public class DaoContaPagar implements IDaoContaPagar {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public int salvarContaPagar(ContaPagar contaPagar) {
        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.ContaPagar.INSERT);
            this.statement.setString(1, contaPagar.getData());
            this.statement.setString(2, contaPagar.getDescricao());
            this.statement.setDouble(3, contaPagar.getValor());
             this.statement.setString(4, contaPagar.getData_pagamento());
            this.statement.setInt(5, contaPagar.getConsultorio().getId());

               result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoContaPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public ContaPagar buscarContaPagarPorId(int id) {
        ContaPagar contaPagar = null;
        
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.ContaPagar.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                contaPagar = new ContaPagar();
                contaPagar.setData(result.getString(SQLUtil.ContaPagar.COL_VENCIMENTO));
                contaPagar.setDescricao(result.getString(SQLUtil.ContaPagar.COL_DESCRICAO));
                contaPagar.setValor(result.getDouble(SQLUtil.ContaPagar.COL_VALOR));
                

                id = result.getInt(1);
                contaPagar.setId(id);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContaPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaPagar;
    }

    @Override
    public List<ContaPagar> getAllContaPagar() {
        List<ContaPagar> contaPagars = new ArrayList<>();

        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.ContaPagar.NOME_TABELA));
            this.result = this.statement.executeQuery();
            ContaPagar contaPagar;
            while (result.next()) {
                contaPagar = new ContaPagar();

                contaPagar.setData(result.getString(SQLUtil.ContaPagar.COL_VENCIMENTO));
                contaPagar.setDescricao(result.getString(SQLUtil.ContaPagar.COL_DESCRICAO));
                contaPagar.setValor(result.getDouble(SQLUtil.ContaPagar.COL_VALOR));

                id = result.getInt(1);
                contaPagar.setId(id);

                contaPagars.add(contaPagar);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaPagars;
    }

    @Override
    public void editarContaPagar(ContaPagar contaPagar) {
          try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.ContaPagar.updateContaPagar(contaPagar.getData_pagamento(), contaPagar.getId()));

            statement.execute();
            statement.close();

   

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void ativarDesativarContaPagar(int id) {
        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.ContaPagar.desativar(id));

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContaPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ContaPagar> BuscarContaPagar(String data) {
        List<ContaPagar> contaPagars = new ArrayList<>();

        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.ContaPagar.selectPordia(data));
            this.result = this.statement.executeQuery();
            ContaPagar contaPagar;
            while (result.next()) {
                contaPagar = new ContaPagar();

                contaPagar.setData(result.getString(SQLUtil.ContaPagar.COL_VENCIMENTO));
                contaPagar.setDescricao(result.getString(SQLUtil.ContaPagar.COL_DESCRICAO));
                contaPagar.setValor(result.getDouble(SQLUtil.ContaPagar.COL_VALOR));

                id = result.getInt(1);
                contaPagar.setId(id);

                contaPagars.add(contaPagar);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaPagars;
    }

      public List<ContaPagar> BuscarContaVencimento(String data) {
        List<ContaPagar> contaPagars = new ArrayList<>();

        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.ContaPagar.selectvencimento(data));
            this.result = this.statement.executeQuery();
            ContaPagar contaPagar;
            while (result.next()) {
                contaPagar = new ContaPagar();

                contaPagar.setData(result.getString(SQLUtil.ContaPagar.COL_VENCIMENTO));
                contaPagar.setDescricao(result.getString(SQLUtil.ContaPagar.COL_DESCRICAO));
                contaPagar.setValor(result.getDouble(SQLUtil.ContaPagar.COL_VALOR));

                id = result.getInt(1);
                contaPagar.setId(id);

                contaPagars.add(contaPagar);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaPagars;
    }
       public List<ContaPagar> BuscarContaporPeriodo(String data,String date) {
        List<ContaPagar> contaPagars = new ArrayList<>();

        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.ContaPagar.buscarContaAPagarPeriodo(data,date));
            this.result = this.statement.executeQuery();
            ContaPagar contaPagar;
            while (result.next()) {
                contaPagar = new ContaPagar();

                contaPagar.setData(result.getString(SQLUtil.ContaPagar.COL_VENCIMENTO));
                contaPagar.setDescricao(result.getString(SQLUtil.ContaPagar.COL_DESCRICAO));
                contaPagar.setValor(result.getDouble(SQLUtil.ContaPagar.COL_VALOR));

                id = result.getInt(1);
                contaPagar.setId(id);

                contaPagars.add(contaPagar);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contaPagars;
    }

}
