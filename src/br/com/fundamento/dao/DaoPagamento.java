/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
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
public class DaoPagamento implements IDaoPagamento {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarPagamento(Pagamento pagamento) {
        int id = 0;
        try {

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Pagamento.INSERT);
            this.statement.setDouble(1, pagamento.getValor_total());
            this.statement.setBoolean(2, pagamento.isStatus());
            this.statement.setString(3, pagamento.getForma_pagamento());
            this.statement.setDouble(4, pagamento.getQuantidade_parcelas());
            this.statement.setInt(5, pagamento.getCaixa().getId());

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(DaoPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;

    }

    @Override
    public Pagamento buscarPagamentoPorId(int id) {
        Pagamento pagamento = null;
  
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Pagamento.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                pagamento = new Pagamento();

                pagamento.setValor_total(result.getDouble(SQLUtil.Pagamento.COL_VALOR_TOTAL));
                pagamento.setStatus(result.getBoolean(SQLUtil.Pagamento.COL_STATUS));
                pagamento.setForma_pagamento(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO));
                pagamento.setQuantidade_parcelas(result.getInt(SQLUtil.Pagamento.COL_QUANTIDADE_PARCELAS));
               
              pagamento.setId(id);
            
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagamento;
    }

    @Override
    public List<Pagamento> getAllPagamento() {
        List<Pagamento> pagamentos = new ArrayList<>();
        Caixa c = null;
        int idC =0,idP=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Pagamento.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Pagamento pagamento;
            while (result.next()) {
                pagamento = new Pagamento();

                pagamento.setValor_total(result.getDouble(SQLUtil.Pagamento.COL_VALOR_TOTAL));
                pagamento.setStatus(result.getBoolean(SQLUtil.Pagamento.COL_STATUS));
                pagamento.setForma_pagamento(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO));
                pagamento.setQuantidade_parcelas(result.getInt(SQLUtil.Pagamento.COL_QUANTIDADE_PARCELAS));
                
                idC = result.getInt(SQLUtil.Pagamento.COL_CAIXA_ID);
                c = new DaoCaixa().buscarCaixaPorId(idC);
                
                idP= result.getInt(1);
                pagamento.setCaixa(c);
                pagamento.setId(idP);

                pagamentos.add(pagamento);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagamentos;
    }

    @Override
    public void editarPagamento(Pagamento pagamento) {
     try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Pagamento.updatePagamento(pagamento.getValor_total(), pagamento.getForma_pagamento(), pagamento.getQuantidade_parcelas(), pagamento.getId()));
            
            
            statement.execute();
            statement.close();
            
           for(Parcela p : pagamento.getParcelas()){
               DaoList.salvarParcelas(p, pagamento.getId());
           }
         
        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

    @Override
    public void ativarDesativarPagamento(int id) {

         try {
            this.conexao = SQLConections.getInstance();
            this.statement=this.conexao.prepareStatement(SQLUtil.Pagamento.desativar(id));
         
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public List<Pagamento> buscarpagamento() {
        List<Pagamento> pagamentos = new ArrayList<>();
        
        int idC =0,idP=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Pagamento.buscarpagamento());
            this.result = this.statement.executeQuery();
            Pagamento pagamento;
            while (result.next()) {
                pagamento = new Pagamento();

                pagamento.setValor_total(result.getDouble(SQLUtil.Pagamento.COL_VALOR_TOTAL));
                pagamento.setForma_pagamento(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO));
                pagamento.setQuantidade_parcelas(result.getInt(SQLUtil.Pagamento.COL_QUANTIDADE_PARCELAS));

                 
                
                idP= result.getInt(1);
                
                pagamento.setId(idP);

                pagamentos.add(pagamento);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPagamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pagamentos;
    }

}
