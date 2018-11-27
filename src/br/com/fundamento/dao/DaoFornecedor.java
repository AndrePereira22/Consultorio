/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Contato;
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
 * @author Glenda Alves de Lima
 */
public class DaoFornecedor implements IDaoFornecedor {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarfornecedor(Fornecedor fornecedor) {
        int id = 0;
         int id_estoque=0;
        try {
            int id_contato = new DaoContato().salvarContato(fornecedor.getContato());
            int id_endereco = CommumDao.salvarEndereco(fornecedor.getEndereco());
            this.conexao = SQLConections.getInstance();

            this.statement = conexao.prepareStatement(SQLUtil.Fornecedor.INSERT);

            this.statement.setString(1, fornecedor.getNome_fantasia());
            this.statement.setString(2, fornecedor.getRazao_social());
            this.statement.setString(3, fornecedor.getCnpj());
            this.statement.setInt(4, id_endereco);
            this.statement.setInt(5, id_contato);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }  

            for(Produto p : fornecedor.getProdutos()){
                  
                id_estoque = new DaoEstoque().salvarEstoque(p.getEstoque());
                DaoList.salvarProduto(p, id_estoque, id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Fornecedor buscarPorfornecedorId(int id) {
        Fornecedor fornecedor = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Fornecedor.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                fornecedor = new Fornecedor();

                fornecedor.setNome_fantasia(result.getString(SQLUtil.Fornecedor.COL_NOME_FORNECEDOR));
                fornecedor.setRazao_social(result.getString(SQLUtil.Fornecedor.COL_RAZAO_SOCIAl));
                fornecedor.setCnpj(result.getString(SQLUtil.Fornecedor.COL_CNPJ));

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getAllfornecedor() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Fornecedor.NOME));
            this.result = this.statement.executeQuery();
            Fornecedor fornecedor;
            while (result.next()) {
                fornecedor = new Fornecedor();
                
                fornecedor.setNome_fantasia(result.getString(SQLUtil.Fornecedor.COL_NOME_FORNECEDOR));
                fornecedor.setRazao_social(result.getString(SQLUtil.Fornecedor.COL_RAZAO_SOCIAl));
                fornecedor.setCnpj(result.getString(SQLUtil.Fornecedor.COL_CNPJ));
                
                fornecedores.add(fornecedor);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;  }

    @Override
    public void editarfornecedor(Fornecedor fornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarfornecedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
