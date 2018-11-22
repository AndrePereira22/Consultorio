/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConections {

    public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/postgres";
    public static String USUARIO_POSTGRES = "postgres";
    public static String SENHA_POSTGRES = "";

    private static Connection conexao = null;

    private SQLConections() {

    }

    public static Connection getInstance() {
        try {
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL_POSTGRES, USUARIO_POSTGRES, SENHA_POSTGRES);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return conexao;
    }
}
