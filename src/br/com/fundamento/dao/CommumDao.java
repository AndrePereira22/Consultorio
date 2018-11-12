/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.sql.SQLConections;
import br.com.fundamento.sql.SQLUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prof Heldon
 */
public class CommumDao {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    public static int salvarEndereco(Endereco end) {
        int id = 0;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT);
            statement.setString(1, end.getCep());
            statement.setString(2, end.getRua());
            statement.setString(3, end.getNumero());
            statement.setString(4, end.getBairro());
            statement.setString(5, end.getEstado());

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static void salvarContato(Contato contato, int cliente_id) {
        try {
            System.out.println(contato);
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Contato.INSERT);
            statement.setString(1, contato.getTipo().getValor());
            statement.setString(2, contato.getDescricao());
            statement.setInt(3, cliente_id);

            statement.execute();

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(CommumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
