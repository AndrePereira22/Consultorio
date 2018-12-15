

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Fornecedor;
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
 * @author prof Heldon
 */
public class DaoProduto implements IDaoProduto {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public int salvar(Produto produto) {
        int id = 0;
            
        try {
            
            int id_fornecedor = new DaoFornecedor().salvarfornecedor(produto.getFornecedor());
            int id_estoque = new DaoEstoque().salvarEstoque(produto.getEstoque());
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Produto.INSERT);
            this.statement.setString(1, produto.getNome());
            this.statement.setString(2, produto.getFabricante());
            this.statement.setInt(3, produto.getQuantidade_estoque());
            this.statement.setDouble(4, produto.getPreco_compra());
            this.statement.setInt(5, id_estoque);
            this.statement.setInt(6,id_fornecedor);

            statement.execute();
            
            if (result.next()) {
                id = result.getInt(1);
            }
            this.statement.close();
                    
        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
 return id;
    }

    @Override
    public Produto buscarPorId(int id) {
        Produto produto = null;
         Fornecedor fornecedor = null;
        Estoque estoque = null;
       int  idE=0 , idF=0;
        
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Produto.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                produto = new Produto();
               
                produto.setNome(result.getString(SQLUtil.Produto.COL_NOME_PRODUTO));
                produto.setFabricante(result.getString(SQLUtil.Produto.COL_FABRICANTE));
                produto.setQuantidade_estoque(result.getInt(SQLUtil.Produto.COL_QUANTIDADE_ESTOQUE));
                produto.setPreco_compra(result.getDouble(SQLUtil.Produto.COL_PRECO_COMPRA));
                
                idE = result.getInt(SQLUtil.Produto.COL_ID_ESTOQUE);
                idF = result.getInt(SQLUtil.Produto.COL_FORNECEDOR_ID);
                
                fornecedor=new DaoFornecedor().buscarPorfornecedorId(idF);
                estoque = new DaoEstoque().buscarEstoquePorId(idE);
                produto.setFornecedor(fornecedor);
                produto.setEstoque(estoque);
                
                 id = result.getInt(1);
                 produto.setId(id);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    @Override
    public List<Produto> getAll() {
        List<Produto> produtos = new ArrayList<>();
         Fornecedor fornecedor = null;
        Estoque estoque = null;
       int id, idE=0 , idF=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME));
            this.result = this.statement.executeQuery();
            Produto produto;
            while (result.next()) {
                produto = new Produto();
                
               produto.setNome(result.getString(SQLUtil.Produto.COL_NOME_PRODUTO));
                produto.setFabricante(result.getString(SQLUtil.Produto.COL_FABRICANTE));
                produto.setQuantidade_estoque(result.getInt(SQLUtil.Produto.COL_QUANTIDADE_ESTOQUE));
                produto.setPreco_compra(result.getDouble(SQLUtil.Produto.COL_PRECO_COMPRA));
                
                idE = result.getInt(SQLUtil.Produto.COL_ID_ESTOQUE);
                idF = result.getInt(SQLUtil.Produto.COL_FORNECEDOR_ID);
                
                fornecedor=new DaoFornecedor().buscarPorfornecedorId(idF);
                estoque = new DaoEstoque().buscarEstoquePorId(idE);
                produto.setFornecedor(fornecedor);
                produto.setEstoque(estoque);
                
                 id = result.getInt(1);
                 produto.setId(id);
                produtos.add(produto);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    @Override
    public void editar(Produto produto) {
        
         try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Produto.updateProduto(produto.getNome(), produto.getFabricante(),produto.getQuantidade_estoque(), produto.getPreco_compra(), produto.getId()));
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> getPorBuscaProduto(String busca) {
       List<Produto> produtos = new ArrayList<>();
       Fornecedor fornecedor = null;
        Estoque estoque = null;
       int id, idE=0 , idF=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Produto.selectPorBusca(busca));
            this.result = this.statement.executeQuery();
            Produto produto;
            while (result.next()) {
                produto = new Produto();
                
               produto.setNome(result.getString(SQLUtil.Produto.COL_NOME_PRODUTO));
                produto.setFabricante(result.getString(SQLUtil.Produto.COL_FABRICANTE));
                produto.setQuantidade_estoque(result.getInt(SQLUtil.Produto.COL_QUANTIDADE_ESTOQUE));
                produto.setPreco_compra(result.getDouble(SQLUtil.Produto.COL_PRECO_COMPRA));
                
                 idE = result.getInt(SQLUtil.Produto.COL_ID_ESTOQUE);
                idF = result.getInt(SQLUtil.Produto.COL_FORNECEDOR_ID);
                
                fornecedor=new DaoFornecedor().buscarPorfornecedorId(idF);
                estoque = new DaoEstoque().buscarEstoquePorId(idE);
                produto.setFornecedor(fornecedor);
                produto.setEstoque(estoque);
                
                 id = result.getInt(1);
                 produto.setId(id);
                produtos.add(produto);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;  }

}
