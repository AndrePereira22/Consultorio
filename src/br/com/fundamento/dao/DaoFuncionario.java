/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
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

            
            int id_login = new DaoLogin().salvarLogin(funcionario.getLogin());
            int id_endereco = CommumDao.salvarEndereco(funcionario.getEndereco());
            int id_contato = new DaoContato().salvarContato(funcionario.getContato());

            this.conexao = SQLConections.getInstance();
            this.statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT);
            this.statement.setString(1, funcionario.getNome());
            this.statement.setString(2, funcionario.getCpf());
            this.statement.setDouble(3, funcionario.getSalario());
            this.statement.setString(4, funcionario.getFuncao());
            this.statement.setString(5, funcionario.getData_nascimento());
            this.statement.setInt(6, id_login);
            this.statement.setInt(7, id_endereco);
           this.statement.setInt(8, id_contato);

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int id) {
        Funcionario funcionario = null;
         Endereco endereco=null;
        Contato contato=null;
        Login login=null;
         int idE=0,idC=0,idL=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Funcionario.NOME, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                funcionario = new Funcionario();
                
                funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
                funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
                funcionario.setData_nascimento(result.getString(SQLUtil.Funcionario.COL_DATA_NASCIMENTO));
                funcionario.setSalario(result.getDouble(SQLUtil.Funcionario.COL_SALARIO));
                funcionario.setFuncao(result.getString(SQLUtil.Funcionario.COL_FUNCAO));
                
                idE = result.getInt(SQLUtil.Funcionario.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Funcionario.COL_ID_CONTATO);
                idL = result.getInt(SQLUtil.Funcionario.COL_ID_LOGIN);
                
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                login =  new DaoLogin().buscarLoginPorId(idL);
                
                funcionario.setContato(contato);
                funcionario.setEndereco(endereco);
                funcionario.setLogin(login);
                
                id = result.getInt(1);
                funcionario.setId(id);
                
                funcionario.setId_endereco(idE);  
                funcionario.setId_contato(idC);
                funcionario.setId_login(idL);
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
         Endereco endereco=null;
        Contato contato=null;
        Login login=null;
         int idE=0,idC=0,idL=0,id;
        
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Funcionario.NOME));
            this.result = this.statement.executeQuery();
            Funcionario funcionario;
            while (result.next()) {
                funcionario = new Funcionario();
                
               funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
                funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
                funcionario.setData_nascimento(result.getString(SQLUtil.Funcionario.COL_DATA_NASCIMENTO));
                funcionario.setSalario(result.getDouble(SQLUtil.Funcionario.COL_SALARIO));
                funcionario.setFuncao(result.getString(SQLUtil.Funcionario.COL_FUNCAO));
                
                idE = result.getInt(SQLUtil.Funcionario.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Funcionario.COL_ID_CONTATO);
                idL = result.getInt(SQLUtil.Funcionario.COL_ID_LOGIN);
                
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                login =  new DaoLogin().buscarLoginPorId(idL);
                
                funcionario.setContato(contato);
                funcionario.setEndereco(endereco);
                funcionario.setLogin(login);
                
                id = result.getInt(1);
                funcionario.setId(id);
                
                funcionario.setId_endereco(idE);  
                funcionario.setId_contato(idC);
                funcionario.setId_login(idL);
                
                Funcionarios.add(funcionario);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Funcionarios; 
    }

    @Override
    public void editarFuncionario(Funcionario funcionario) {
          
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.updateFuncionario(funcionario.getNome(),funcionario.getCpf(),funcionario.getSalario(),funcionario.getFuncao(),funcionario.getId()));
         
           
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
   CommumDao.editarEndereco(funcionario.getEndereco(), funcionario.getId_endereco());
   CommumDao.editarContato(funcionario.getContato(), funcionario.getId_contato());
  new DaoLogin().editarLogin(funcionario.getLogin() );

        
       }

    @Override
    public void ativarDesativarFuncionario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Funcionario buscarFuncionario(String usuario) {
        Funcionario funcionario = null;
         Endereco endereco=null;
        Contato contato=null;
        Login login=null;
         int idE=0,idC=0,idL=0,id=0;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.BuscarFuncionario(usuario));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                funcionario = new Funcionario();
                
                funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
                funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
                funcionario.setData_nascimento(result.getString(SQLUtil.Funcionario.COL_DATA_NASCIMENTO));
                funcionario.setSalario(result.getDouble(SQLUtil.Funcionario.COL_SALARIO));
                funcionario.setFuncao(result.getString(SQLUtil.Funcionario.COL_FUNCAO));
                
                idE = result.getInt(SQLUtil.Funcionario.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Funcionario.COL_ID_CONTATO);
                idL = result.getInt(SQLUtil.Funcionario.COL_ID_LOGIN);
                
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                login =  new DaoLogin().buscarLoginPorId(idL);
                
                funcionario.setContato(contato);
                funcionario.setEndereco(endereco);
                funcionario.setLogin(login);
                
                id = result.getInt(1);
                funcionario.setId(id);
                
                funcionario.setId_endereco(idE);  
                funcionario.setId_contato(idC);
                funcionario.setId_login(idL);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }
    @Override
    public List<Funcionario> getPorBuscaFuncionario(String busca) {
    List<Funcionario> Funcionarios = new ArrayList<>();
     Endereco endereco=null;
        Contato contato=null;
        Login login=null;
         int idE=0,idC=0,idL=0,id;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.selectPorBusca(busca));
            this.result = this.statement.executeQuery();
            Funcionario funcionario;
            while (result.next()) {
                funcionario = new Funcionario();
                
               funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
                funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
                funcionario.setData_nascimento(result.getString(SQLUtil.Funcionario.COL_DATA_NASCIMENTO));
                funcionario.setSalario(result.getDouble(SQLUtil.Funcionario.COL_SALARIO));
                funcionario.setFuncao(result.getString(SQLUtil.Funcionario.COL_FUNCAO));
                
                 idE = result.getInt(SQLUtil.Funcionario.COL_ID_ENDERECO);
                idC = result.getInt(SQLUtil.Funcionario.COL_ID_CONTATO);
                idL = result.getInt(SQLUtil.Funcionario.COL_ID_LOGIN);
                
                endereco = CommumDao.bucarEnderecoPorId(idE);
                contato = CommumDao.bucarContatoPorId(idC);
                login =  new DaoLogin().buscarLoginPorId(idL);
                
                funcionario.setContato(contato);
                funcionario.setEndereco(endereco);
                funcionario.setLogin(login);
                
                id = result.getInt(1);
                funcionario.setId(id);
                
                funcionario.setId_endereco(idE);  
                funcionario.setId_contato(idC);
                funcionario.setId_login(idL);
                Funcionarios.add(funcionario);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Funcionarios; 
    }

}
