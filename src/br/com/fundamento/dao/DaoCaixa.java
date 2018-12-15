
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Pagamento;
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

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Pagamento p : caixa.getPagamentos()) {
                DaoList.salvarPagamento(p, id);
            }
            for (Funcionario f : caixa.getFuncionarios()) {
                int id_login = new DaoLogin().salvarLogin(f.getLogin());
                 int id_contato = new DaoContato().salvarContato(f.getContato());

                DaoList.salvarFuncionario(f, id, id_login,id_contato);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Caixa buscarCaixaPorId(int id) {
        Caixa caixa = null;
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
    public void editarCaixa(Caixa caixa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarCaixa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
