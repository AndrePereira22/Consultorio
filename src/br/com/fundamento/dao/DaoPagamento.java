/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

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

            int id_caixa = new DaoCaixa().salvarCaixa(pagamento.getCaixa());
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Pagamento.INSERT);
            this.statement.setDouble(1, pagamento.getValor_total());
            this.statement.setBoolean(2, pagamento.isStatus());
            this.statement.setString(3, pagamento.getForma_pagamento());
            this.statement.setDouble(4, pagamento.getQuantidade_parcelas());
            this.statement.setInt(5, id_caixa);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Parcela p : pagamento.getParcelas()) {
                DaoList.salvarParcelas(p, id);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarPagamento(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
