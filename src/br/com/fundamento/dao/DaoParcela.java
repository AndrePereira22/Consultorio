/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Parcela;
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
public class DaoParcela implements IDaoParcela {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvarParcela(Parcela parcela) {
        try {
           
            int id_pagamento = new DaoPagamento().salvarPagamento(parcela.getPagamento());
            
            this.conexao = SQLConections.getInstance();

            this.statement = conexao.prepareStatement(SQLUtil.Parcela.INSERT);

            this.statement.setDouble(1, parcela.getValor());
            this.statement.setBoolean(2, parcela.isStatus());
            this.statement.setInt(3, parcela.getNumero());
            this.statement.setBoolean(4, parcela.isParcela_unica());
            this.statement.setInt(5, id_pagamento); 
            this.statement.setString(6, parcela.getData_vencimento());

            statement.execute();
            this.statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoParcela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Parcela buscarParcelaPorId(int id) {
        Parcela parcela = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Parcela.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                parcela = new Parcela();
                parcela.setNumero(result.getInt(SQLUtil.Parcela.COL_NUMERO));
                parcela.setValor(result.getDouble(SQLUtil.Parcela.COL_VALOR));
                parcela.setData_vencimento(result.getString(SQLUtil.Parcela.COL_DATA_VENCIMENTO));
                parcela.setStatus(result.getBoolean(SQLUtil.Parcela.COL_STATUS));
                parcela.setParcela_unica(result.getBoolean(SQLUtil.Parcela.COL_PARCELA_UNICA));

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoParcela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parcela;
    }

    @Override
    public List<Parcela> getAllParcela() {
        List<Parcela> parcelas = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Parcela.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Parcela parcela;
            while (result.next()) {
                parcela = new Parcela();
                
               parcela.setNumero(result.getInt(SQLUtil.Parcela.COL_NUMERO));
                parcela.setValor(result.getDouble(SQLUtil.Parcela.COL_VALOR));
                parcela.setData_vencimento(result.getString(SQLUtil.Parcela.COL_DATA_VENCIMENTO));
                parcela.setStatus(result.getBoolean(SQLUtil.Parcela.COL_STATUS));
                parcela.setParcela_unica(result.getBoolean(SQLUtil.Parcela.COL_PARCELA_UNICA));
                
                parcelas.add(parcela);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoParcela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parcelas; }

    @Override
    public void editarParcela(Parcela parcela) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarParcela(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
