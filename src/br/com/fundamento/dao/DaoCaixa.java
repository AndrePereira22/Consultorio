
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Pagamento;
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
public class DaoCaixa implements IDaoCaixa {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarCaixa(Caixa caixa) {
        int id = 0;
        
        try {

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Caixa.INSERT);
            this.statement.setBoolean(1, caixa.isStatus());
            this.statement.setInt(2, caixa.getNumero());
            this.statement.setDouble(3, caixa.getValor_abertura());
            this.statement.setDouble(4, caixa.getValor_fechamento());
            this.statement.setDouble(5, caixa.getValor_receita());
            this.statement.setString(6, caixa.getData());
            this.statement.setInt(7, caixa.getFuncionario().getId());
            
            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Pagamento p : caixa.getPagamentos()) {
                DaoList.salvarPagamento(p, id);
            }
           

        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Caixa buscarCaixaPorId(int id) {
        Caixa caixa = null;
        int idF=0;
        Funcionario funcionario;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Caixa.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                caixa = new Caixa();
                
                caixa.setStatus(result.getBoolean(SQLUtil.Caixa.COL_STATUS));
                caixa.setNumero(result.getInt(SQLUtil.Caixa.COL_NUMERO));
                caixa.setValor_abertura(result.getInt(SQLUtil.Caixa.COL_VALOR_ABERTURA));
                caixa.setValor_fechamento(result.getInt(SQLUtil.Caixa.COL_VALOR_FECHAMENTO));
                caixa.setValor_receita(result.getInt(SQLUtil.Caixa.COL_LUCRO_DIARIO));
               caixa.setData(result.getString(SQLUtil.Caixa.COL_DATA));
               
               idF= result.getInt(SQLUtil.Caixa.COL_ID_FUNCIONARIO);
               funcionario = new DaoFuncionario().buscarFuncionarioPorId(idF);
               caixa.setFuncionario(funcionario);
               
               id = result.getInt(1);
                caixa.setId(id);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caixa;
    }

    @Override
    public List<Caixa> getAllCaixa() {
         List<Caixa> caixas = new ArrayList<>();
         int id;
         int idF=0;
        Funcionario funcionario;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Caixa.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Caixa caixa;
            while (result.next()) {
                caixa = new Caixa();
                
                caixa.setStatus(result.getBoolean(SQLUtil.Caixa.COL_STATUS));
                caixa.setNumero(result.getInt(SQLUtil.Caixa.COL_NUMERO));
                caixa.setValor_abertura(result.getInt(SQLUtil.Caixa.COL_VALOR_ABERTURA));
                caixa.setValor_fechamento(result.getInt(SQLUtil.Caixa.COL_VALOR_FECHAMENTO));
                caixa.setValor_receita(result.getInt(SQLUtil.Caixa.COL_LUCRO_DIARIO));
                caixa.setData(result.getString(SQLUtil.Caixa.COL_DATA));
                
                
               idF= result.getInt(SQLUtil.Caixa.COL_ID_FUNCIONARIO);
               funcionario = new DaoFuncionario().buscarFuncionarioPorId(idF);
               caixa.setFuncionario(funcionario);
               
                id = result.getInt(1);
                caixa.setId(id);
                caixas.add(caixa);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caixas;   }

    @Override
    public void editarCaixa(Caixa c) {
     try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Caixa.updateCaixa(c.isStatus(), c.getValor_fechamento(), c.getValor_receita(), c.getId()));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fecharCaixa(Caixa c) {
     try {
            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Caixa.fecharCaixa(c.isStatus(), c.getValor_receita(), c.getId()));
            
            
            statement.execute();
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ativarDesativarCaixa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Caixa buscarCaixaPorData(String data) {
        Caixa caixa = null;
        int idF=0,id=0;
        Funcionario funcionario;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Caixa.caixaPorData(data));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                caixa = new Caixa();
                
                caixa.setStatus(result.getBoolean(SQLUtil.Caixa.COL_STATUS));
                caixa.setNumero(result.getInt(SQLUtil.Caixa.COL_NUMERO));
                caixa.setValor_abertura(result.getInt(SQLUtil.Caixa.COL_VALOR_ABERTURA));
                caixa.setValor_fechamento(result.getInt(SQLUtil.Caixa.COL_VALOR_FECHAMENTO));
                caixa.setValor_receita(result.getInt(SQLUtil.Caixa.COL_LUCRO_DIARIO));
               caixa.setData(result.getString(SQLUtil.Caixa.COL_DATA));
               
               idF= result.getInt(SQLUtil.Caixa.COL_ID_FUNCIONARIO);
               funcionario = new DaoFuncionario().buscarFuncionarioPorId(idF);
               caixa.setPagamentos(new ArrayList<Pagamento>());
               caixa.setFuncionario(funcionario);
               
               id = result.getInt(1);
                caixa.setId(id);
            }
            
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caixa;
    }
     public Caixa buscarUltimoCaixa() {
        Caixa caixa = null;
       
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Caixa.UltimoCaixa());
            this.result = this.statement.executeQuery();

            if (result.next()) {
                caixa = new Caixa();
               
                caixa.setValor_fechamento(result.getInt(SQLUtil.Caixa.COL_VALOR_FECHAMENTO));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caixa;
    }

}
