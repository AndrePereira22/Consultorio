/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Municipio;
import br.com.fundamento.modelos.Relatorio;
import br.com.fundamento.modelos.Tarefa;
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
public class DaoFuncionario implements IDaoFuncionario {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarFuncionario(Funcionario funcionario) {
        int id = 0;
        try {

            int id_caixa = new DaoCaixa().salvarCaixa(funcionario.getCaixa());
            int id_login = new DaoLogin().salvarLogin(funcionario.getLogin());
            int id_endereco = CommumDao.salvarEndereco(funcionario.getEndereco());

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT);
            this.statement.setString(1, funcionario.getNome());
            this.statement.setInt(2, id_caixa);
            this.statement.setInt(3, funcionario.getCpf());
            this.statement.setDouble(4, funcionario.getSalario());
            this.statement.setString(5, funcionario.getFuncao());
            this.statement.setString(6, funcionario.getDate_NascimentoString());
            this.statement.setInt(7, id_login);
            this.statement.setInt(8, id_endereco);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Tarefa t : funcionario.getTarefas()) {
                DaoList.salvarTarefa(t, id);
            }
            for (Relatorio r : funcionario.getRelatorios()) {
                DaoList.salvarRelatorio(r, id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int id) {
        Funcionario funcionario = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Funcionario.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                funcionario = new Funcionario();
                
                funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
                funcionario.setCpf(result.getInt(SQLUtil.Funcionario.COL_CPF));
                //  funcionario.setDate_nascimentoInt(result.getString(SQLUtil.Funcionario.COL_DATA_NASCIMENTO));
                funcionario.setSalario(result.getFloat(SQLUtil.Funcionario.COL_SALARIO));
                funcionario.setFuncao(result.getString(SQLUtil.Funcionario.COL_FUNCAO));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> getAllFuncionario() {
        List<Funcionario> Funcionarios = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Funcionario.NOME));
            this.result = this.statement.executeQuery();
            Funcionario funcionario;
            while (result.next()) {
                funcionario = new Funcionario();
                
               funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
                funcionario.setCpf(result.getInt(SQLUtil.Funcionario.COL_CPF));
                //  funcionario.setDate_nascimentoInt(result.getString(SQLUtil.Funcionario.COL_DATA_NASCIMENTO));
                funcionario.setSalario(result.getFloat(SQLUtil.Funcionario.COL_SALARIO));
                funcionario.setFuncao(result.getString(SQLUtil.Funcionario.COL_FUNCAO));
                
                Funcionarios.add(funcionario);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Funcionarios; }

    @Override
    public void editarFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
