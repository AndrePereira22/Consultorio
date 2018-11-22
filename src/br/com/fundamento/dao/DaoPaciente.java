/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Cliente;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Paciente;
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
 * @author Glenda Alves de Lima
 */
public class DaoPaciente implements IDaoPaciente {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarPaciente(Paciente paciente) {
        int id = 0;
        try {

            int id_convenio = new DaoConvenio().salvarConvenio(paciente.getConvenio());
            int id_prontuario = new DaoProntuario().salvarProntuario(paciente.getProntuario());
            int id_endereco = CommumDao.salvarEndereco(paciente.getEndereco());

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT);
            this.statement.setString(1, paciente.getNome());
            this.statement.setString(2, paciente.getCpf());
            this.statement.setString(3, paciente.getSexo());
            this.statement.setString(4, paciente.getData_nascimentoString());
            this.statement.setString(5, paciente.getDate_cadastroString());
            this.statement.setInt(6, paciente.getRg());
            this.statement.setInt(7, id_convenio);
            this.statement.setInt(8, id_prontuario);
            this.statement.setInt(9, id_endereco);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Consulta c : paciente.getConsultas()) {
                DaoList.salvarconsulta(c, id);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        Paciente paciente = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Paciente.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                paciente = new Paciente();
                
                paciente.setNome(result.getString(SQLUtil.Paciente.COL_NOME));
                // paciente.setDate_nascimentoInt(result.getString(SQLUtil.Paciente.COL_DATA_NASCIMENTO));
                // paciente.setDate_cadastroInt(result.getString(SQLUtil.Paciente.COL_DATA_CADASTRO,));
                paciente.setCpf(result.getString(SQLUtil.Paciente.COL_CPF));
                paciente.setSexo(result.getString(SQLUtil.Paciente.COL_SEXO));
                paciente.setRg(result.getInt(SQLUtil.Paciente.COL_RG));

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paciente;
    }

    @Override
    public List<Paciente> getAllPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarPaciente(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarPaciente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}