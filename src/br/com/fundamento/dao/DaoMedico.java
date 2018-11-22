/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Medico;
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
public class DaoMedico implements IDaoMedico {

    private Connection conexao;
    private PreparedStatement statement;
    private static ResultSet result;

    @Override
    public int salvarMedico(Medico medico) {
        int id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            int id_consultorio = new DaoConsultorio().salvarConsultorio(medico.getConsultorio());
            int id_login = new DaoLogin().salvarLogin(medico.getLogin());
            int id_endereco = CommumDao.salvarEndereco(medico.getEndereco());

            this.statement = conexao.prepareStatement(SQLUtil.Medico.INSERT);
            this.statement.setString(1, medico.getNome());
            this.statement.setString(2, medico.getSexo());
            this.statement.setInt(3, medico.getRg());
            this.statement.setInt(4, id_consultorio);
            this.statement.setString(5, medico.getCpf());
            this.statement.setString(6, medico.getDate_nascimentoString());
            this.statement.setString(7, medico.getDate_cadastroString());
            this.statement.setInt(8, id_login);
            this.statement.setInt(9, id_endereco);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }
            for (Especializacao e : medico.getEspecializacoes()) {
                DaoList.salvarEspecializacao(e, id);
            }
            for (Consulta c : medico.getConsultas()) {
                int id_pagamento = new DaoPagamento().salvarPagamento(c.getPagamento());
                int id_paciente = new DaoPaciente().salvarPaciente(c.getPaciente());
                DaoList.salvarConsulta(c, id, id_pagamento, id_consultorio, id_paciente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Medico buscarMedicoPorId(int id) {
        Medico medico = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Medico.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                medico = new Medico();
                
                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
               // medico.setDate_nascimentoInt(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
               // medico.setDate_cadastroInt(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getInt(SQLUtil.Medico.COL_RG));
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }

    @Override
    public List<Medico> getAllMedico() {
        List<Medico> medicos = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Medico.NOME));
            this.result = this.statement.executeQuery();
            Medico medico;
            while (result.next()) {
                medico = new Medico();
                
                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
               // medico.setDate_nascimentoInt(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
               // medico.setDate_cadastroInt(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getInt(SQLUtil.Medico.COL_RG));
                
                medicos.add(medico);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;}

    @Override
    public void editarMedico(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarMedico(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
