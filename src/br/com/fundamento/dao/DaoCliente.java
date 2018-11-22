/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Cliente;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class DaoCliente implements IDaoCliente {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;
    

    @Override
    public void salvar(Cliente cliente) {
        try {
            int id_endereco = CommumDao.salvarEndereco(cliente.getEndereco());
            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Cliente.INSERT);
            this.statement.setString(1, cliente.getNome());
            this.statement.setString(2, cliente.getCpf());
            this.statement.setString(3, cliente.getTipo().getValor());
            this.statement.setString(4, cliente.getDocumento());
            this.statement.setInt(5, id_endereco);
            this.result = this.statement.executeQuery();
            int id_cliente = 0;
            if (result.next()) {
                id_cliente = result.getInt(1);
            }
            this.statement.close();
            
            for (Contato c : cliente.getContatos()) {
               // CommumDao.salvarContato(c, id_cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Cliente buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
