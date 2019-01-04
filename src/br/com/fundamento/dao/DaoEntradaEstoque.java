/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.EntradaEstoque;
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
public class DaoEntradaEstoque implements IDaoEntradaEstoque {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public int salvarEntradaEstoque(EntradaEstoque entradaEstoque) {
int id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.EntradaEstoque.INSERT);
            this.statement.setString(1, entradaEstoque.getData());
            this.statement.setInt(2, entradaEstoque.getQuantidade_entrada());
           this.statement.setInt(3, entradaEstoque.getProduto().getId());

            

            statement.execute();
            this.statement.close();
            
            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoEntradaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
  return id;
    }

    @Override
    public EntradaEstoque buscarEntradaEstoquePorId(int id) {
        EntradaEstoque entrada_Estoque = null;
        Produto produto = null;
        int idP;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.EntradaEstoque.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                entrada_Estoque = new EntradaEstoque();

                entrada_Estoque.setData(result.getString(SQLUtil.EntradaEstoque.COL_DATA));
                entrada_Estoque.setQuantidade_entrada(result.getInt(SQLUtil.EntradaEstoque.COL_QUANTIDADE_ENTRADA));

                idP = result.getInt(SQLUtil.EntradaEstoque.COL_ID_PRODUTO);
                produto = new DaoProduto().buscarPorId(idP);
                entrada_Estoque.setProduto(produto);

                id = result.getInt(1);
                produto.setId(id);

                entrada_Estoque.setId_produto(idP);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entrada_Estoque;
    }

    @Override
    public List<EntradaEstoque> getAllEntradaEstoque() {
        List<EntradaEstoque> entrada_Estoques = new ArrayList<>();
        Produto produto = null;
        int idP = 0, id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.EntradaEstoque.NOME_TABELA));
            this.result = this.statement.executeQuery();
            EntradaEstoque entrada_Estoque;
            while (result.next()) {
                entrada_Estoque = new EntradaEstoque();

                entrada_Estoque.setData(result.getString(SQLUtil.EntradaEstoque.COL_DATA));
              entrada_Estoque.setQuantidade_entrada(result.getInt(SQLUtil.EntradaEstoque.COL_QUANTIDADE_ENTRADA));

                idP = result.getInt(SQLUtil.EntradaEstoque.COL_ID_PRODUTO);
                produto = new DaoProduto().buscarPorId(idP);
                entrada_Estoque.setProduto(produto);

                id = result.getInt(1);
                produto.setId(id);

                entrada_Estoque.setId_produto(idP);

                entrada_Estoques.add(entrada_Estoque);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoSaidaEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entrada_Estoques;
    }

    @Override
    public void editarEntradaEstoque(EntradaEstoque entradaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEntradaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntradaEstoque> getPorBuscaEntradaEstoque(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
