/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.SaidaEstoque;
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
public class DaoEstoque implements  IDaoEstoque{

    private Connection conexao;
    private PreparedStatement statement;
     private static ResultSet result;

    @Override
    public int salvarEstoque(Estoque estoque) {
         int id_estoque = 0;
         int id_fornecedor = 0;
         try {
             int id_consultorio = new DaoConsultorio().salvarConsultorio(estoque.getConsultorio());
            this.conexao = SQLConections.getInstance();
           
            this.statement = conexao.prepareStatement(SQLUtil.Estoque.INSERT);
             this.statement.setString(1, estoque.getDescricao());
              this.statement.setInt(2, id_consultorio);
             
              result = statement.executeQuery();

            if (result.next()) {
                id_estoque = result.getInt(1);
            }

            for (Produto p : estoque.getProdutos()) {
                 id_fornecedor = new DaoFornecedor().salvarfornecedor(p.getFornecedor());
  
                DaoList.salvarProduto(p, id_estoque,id_fornecedor);
                   
            }
             for (SaidaEstoque s : estoque.getSaidasEstoque()) {
               
                DaoList.salvarSaidaEstoque(s,id_estoque);
                
            }
                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
         return id_estoque;
                 
    }

    @Override
    public Estoque buscarEstoquePorId(int id) {
        Estoque estoque = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Estoque.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
              estoque = new Estoque();
               estoque.setDescricao(result.getString(SQLUtil.Estoque.COL_DESCRICAO));
                       
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoque;
    }

    @Override
    public List<Estoque> getAllEstoque() {
        List<Estoque> estoques = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Estoque.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Estoque estoque;
            while (result.next()) {
                estoque = new Estoque();
                estoque.setDescricao(result.getString(SQLUtil.Estoque.COL_DESCRICAO));
                
                estoques.add(estoque);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoques;  }

    @Override
    public void editarEstoque(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
