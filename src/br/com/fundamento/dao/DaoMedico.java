/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Login;
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
            int id_contato = new DaoContato().salvarContato(medico.getContato());
            int id_login = new DaoLogin().salvarLogin(medico.getLogin());
            int id_endereco = CommumDao.salvarEndereco(medico.getEndereco());
            int id_especializacao = new DaoEspecializacao().salvarEspecializacao(medico.getEspecializacao());

            this.statement = conexao.prepareStatement(SQLUtil.Medico.INSERT);
            this.statement.setString(1, medico.getNome());
            this.statement.setString(2, medico.getSexo());
            this.statement.setString(3, medico.getRg());
            this.statement.setString(4, medico.getCpf());
            this.statement.setString(5, medico.getData_nascimento());
            this.statement.setString(6, medico.getData_cadastro());
            this.statement.setString(7, medico.getConselho());
            this.statement.setInt(8, medico.getNumero());
            this.statement.setInt(9, id_login);
            this.statement.setInt(10, id_endereco);
            this.statement.setInt(11, id_contato);
            this.statement.setInt(12, id_especializacao);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Medico buscarMedicoPorId(int id) {
        Medico medico = null;
        Endereco endereco = null;
        Contato contato = null;
        Especializacao especializacao = null;
        Login login = null;
        int idE = 0, idC = 0, idL = 0, idEsp = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Medico.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                medico = new Medico();

                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
                medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
                medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getString(SQLUtil.Medico.COL_RG));
                medico.setConselho(result.getString(SQLUtil.Medico.COL_CONSELHO));
                medico.setNumero(result.getInt(SQLUtil.Medico.COL_NUMERO));
                idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idEsp = result.getInt(SQLUtil.Medico.COL_ID_ESPECIALIZACAO);

                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);

                login = new DaoLogin().buscarLoginPorId(idL);

                medico.setContato(contato);
                medico.setEndereco(endereco);
                especializacao = new DaoEspecializacao().buscarEspecializacaoPorId(idEsp);
                medico.setLogin(login);

                medico.setEspecializacao(especializacao);

                id = result.getInt(1);
                medico.setId(id);

                medico.setId_end(idE);
                medico.setId_contato(idC);
                medico.setId_login(idL);
                medico.setId_esp(idEsp);

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
        Endereco endereco = null;
        Contato contato = null;
        Especializacao especializacao = null;
        Login login = null;
        int idE = 0, idC = 0, idL = 0, id, idEsp = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Medico.NOME));
            this.result = this.statement.executeQuery();
            Medico medico;
            while (result.next()) {
                medico = new Medico();

                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
                medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
                medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getString(SQLUtil.Medico.COL_RG));
                medico.setConselho(result.getString(SQLUtil.Medico.COL_CONSELHO));
                medico.setNumero(result.getInt(SQLUtil.Medico.COL_NUMERO));
                idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idEsp = result.getInt(SQLUtil.Medico.COL_ID_ESPECIALIZACAO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idEsp = result.getInt(SQLUtil.Medico.COL_ID_ESPECIALIZACAO);

                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);

                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                especializacao = new DaoEspecializacao().buscarEspecializacaoPorId(idEsp);
                login = new DaoLogin().buscarLoginPorId(idL);

                medico.setContato(contato);
                medico.setEndereco(endereco);

                medico.setLogin(login);
                medico.setId_esp(idEsp);

                medico.setId_contato(idC);
                medico.setId_end(idE);
                medico.setId_login(idL);

                id = result.getInt(1);
                medico.setId(id);
                medicos.add(medico);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }

    @Override
    public void editarMedico(Medico medico) {

        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.updateMedico(medico.getNome(), medico.getCpf(), medico.getRg(), medico.getId()));

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        CommumDao.editarEndereco(medico.getEndereco(), medico.getId_end());
        CommumDao.editarContato(medico.getContato(), medico.getId_contato());
        new DaoLogin().editarLogin(medico.getLogin());
        new DaoEspecializacao().editarEspecializacao(medico.getEspecializacao());

    }

    @Override
    public void ativarDesativarMedico(int id) {
        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Medico.desativar(id));

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoEspecializacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Medico> getPorBuscaMedico(String busca) {
        List<Medico> medicos = new ArrayList<>();
        Endereco endereco = null;
        Contato contato = null;
        Especializacao esp;
        Login login = null;
        int idE = 0, idC = 0, idL = 0, id, idEsp = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.selectPorBusca(busca));
            this.result = this.statement.executeQuery();
            Medico medico;
            while (result.next()) {
                medico = new Medico();

                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
                medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
                medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getString(SQLUtil.Medico.COL_RG));
                medico.setConselho(result.getString(SQLUtil.Medico.COL_CONSELHO));
                medico.setNumero(result.getInt(SQLUtil.Medico.COL_NUMERO));
                idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idEsp = result.getInt(SQLUtil.Medico.COL_ID_ESPECIALIZACAO);
                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                esp = new DaoEspecializacao().buscarEspecializacaoPorId(idEsp);
                login = new DaoLogin().buscarLoginPorId(idL);

                medico.setContato(contato);
                medico.setEndereco(endereco);
                medico.setEspecializacao(esp);
                medico.setLogin(login);

                medico.setId_esp(idEsp);
                medico.setId_contato(idC);
                medico.setId_end(idE);
                medico.setId_login(idL);

                id = result.getInt(1);
                medico.setId(id);
                medicos.add(medico);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medicos;
    }

    public Medico BuscarMedico(String busca) {
        Medico medico = new Medico();
        Endereco endereco = null;
        Contato contato = null;
        Especializacao esp;
        Login login = null;
        int idE = 0, idC = 0, idL = 0, id, idEsp = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.buscarMedico(busca));
            this.result = this.statement.executeQuery();

            while (result.next()) {

                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
                medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
                medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getString(SQLUtil.Medico.COL_RG));
                medico.setConselho(result.getString(SQLUtil.Medico.COL_CONSELHO));
                medico.setNumero(result.getInt(SQLUtil.Medico.COL_NUMERO));
                idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idEsp = result.getInt(SQLUtil.Medico.COL_ID_ESPECIALIZACAO);
                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                esp = new DaoEspecializacao().buscarEspecializacaoPorId(idEsp);

                login = new DaoLogin().buscarLoginPorId(idL);
                medico.setContato(contato);
                medico.setEndereco(endereco);

                medico.setLogin(login);
                medico.setEspecializacao(esp);

                medico.setId_contato(idC);
                medico.setId_end(idE);
                medico.setId_login(idL);

                id = result.getInt(1);
                medico.setId(id);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }

    public Medico buscarMedico(String usuario, String senha) {
        Medico medico = null;
        Endereco endereco = null;
        Contato contato = null;
        Especializacao especializacao = null;
        Login login = null;
        int idE = 0, idC = 0, idL = 0, idEsp = 0, id = 0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Medico.BuscaMedico(usuario, senha));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                medico = new Medico();

                medico.setNome(result.getString(SQLUtil.Medico.COL_NOME));
                medico.setData_nascimento(result.getString(SQLUtil.Medico.COL_DATA_NASCIMENTO));
                medico.setData_cadastro(result.getString(SQLUtil.Medico.COL_DATA_CADASTRO));
                medico.setCpf(result.getString(SQLUtil.Medico.COL_DATA_CPF));
                medico.setSexo(result.getString(SQLUtil.Medico.COL_SEXO));
                medico.setRg(result.getString(SQLUtil.Medico.COL_RG));
                medico.setConselho(result.getString(SQLUtil.Medico.COL_CONSELHO));
                medico.setNumero(result.getInt(SQLUtil.Medico.COL_NUMERO));
                idE = result.getInt(SQLUtil.Medico.COL_ENDERECO);
                idC = result.getInt(SQLUtil.Medico.COL_ID_CONTATO);
                idEsp = result.getInt(SQLUtil.Medico.COL_ID_ESPECIALIZACAO);

                idL = result.getInt(SQLUtil.Medico.COL_ID_LOGIN);
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);

                login = new DaoLogin().buscarLoginPorId(idL);

                medico.setContato(contato);
                medico.setEndereco(endereco);
                especializacao = new DaoEspecializacao().buscarEspecializacaoPorId(idEsp);
                medico.setLogin(login);

                medico.setEspecializacao(especializacao);

                id = result.getInt(1);
                medico.setId(id);

                medico.setId_end(idE);
                medico.setId_contato(idC);
                medico.setId_login(idL);
                medico.setId_esp(idEsp);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medico;
    }
}
