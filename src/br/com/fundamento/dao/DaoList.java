/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Relatorio;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.modelos.Tarefa;
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
 * @author Glenda Alves de Lima
 */
public class DaoList {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    public static void salvarProduto(Produto produto, int estoque_id, int id_fornecedor) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Produto.INSERT);
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getFabricante());
            statement.setInt(3, produto.getQuantidade_estoque());
            statement.setInt(4, produto.getQuantidade_minima());
            statement.setDouble(5, produto.getPreco_compra());
            statement.setInt(6, estoque_id);
            statement.setInt(7, id_fornecedor);

            statement.execute();

            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarSaidaEstoque(SaidaEstoque saidaEstoque, int estoque_id) {

        try {

            conexao = SQLConections.getInstance();

            statement = conexao.prepareStatement(SQLUtil.SaidaEstoque.INSERT);

            statement.setString(1, saidaEstoque.getNome());
            statement.setString(2, saidaEstoque.getFabricante());
            statement.setInt(3, saidaEstoque.getQuantidade_saida());
            statement.setInt(4, estoque_id);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void salvarParcelas(Parcela parcela, int id_pagamento) {

        try {

            conexao = SQLConections.getInstance();

            statement = conexao.prepareStatement(SQLUtil.Parcela.INSERT);

            statement.setDouble(1, parcela.getValor());
            statement.setBoolean(2, parcela.isStatus());
            statement.setInt(3, parcela.getNumero());
            statement.setBoolean(4, parcela.isParcela_unica());
            statement.setInt(5, id_pagamento);
            statement.setString(6, parcela.getData_vencimento());
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarPagamento(Pagamento pagamento, int id_caixa) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Pagamento.INSERT);
            statement.setDouble(1, pagamento.getValor_total());
            statement.setBoolean(2, pagamento.isStatus());
            statement.setString(3, pagamento.getForma_pagamento());
            statement.setDouble(4, pagamento.getQuantidade_parcelas());
            statement.setInt(5, id_caixa);
            statement.setString(6, pagamento.getData_vencimento());

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarEspecializacao(Especializacao especializacao, int id_medico) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Especializacao.INSERT);
            statement.setString(1, especializacao.getDescricao());
            statement.setDouble(2, especializacao.getSalario());
            statement.setInt(3, id_medico);
            statement.setString(4, especializacao.getHorario_disponivel());

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarPaciente(Paciente paciente, int id_convenio, int id_prontuario, int id_endereco , int id_contato) {

        try {

            
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Paciente.INSERT);
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getCpf());
            statement.setString(3, paciente.getSexo());
            statement.setString(4, paciente.getData_nascimento());
            statement.setString(5, paciente.getData_cadastro());
            statement.setInt(6, paciente.getRg());
            statement.setInt(7, id_convenio);
            statement.setInt(8, id_prontuario);
            statement.setInt(9, id_endereco);
            statement.setInt(10, id_contato);
            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarFuncionario(Funcionario funcionario, int id_caixa, int id_login, int id_contato) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT);
            statement.setString(1, funcionario.getNome());
            statement.setInt(2, id_caixa);
            statement.setString(3, funcionario.getCpf());
            statement.setDouble(4, funcionario.getSalario());
            statement.setString(5, funcionario.getFuncao());
            statement.setString(6, funcionario.getData_nascimento());
            statement.setInt(7, id_login);
            statement.setInt(8, id_contato);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarTarefa(Tarefa tarefa, int id_funcionario) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Tarefa.INSERT);

            statement.setString(1, tarefa.getDescricao());
            statement.setInt(2, tarefa.getPrioridade());
            statement.setBoolean(3, tarefa.isStatus());
            statement.setInt(4, id_funcionario);
            statement.setString(5, tarefa.getData_inicio());
            statement.setString(6, tarefa.getData_termino());

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarRelatorio(Relatorio relatorio, int id_funcionario) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Relatorio.INSERT);

            statement.setString(1, relatorio.getDescricao());
            statement.setString(2, relatorio.getRelatorio());
            statement.setInt(3, id_funcionario);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarConsulta(Consulta consulta, int id_medico, int id_pagamento, int id_consultorio, int id_paciente) {

        try {

            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Consulta.INSERT);

            statement.setString(1, consulta.getTipo());
            statement.setBoolean(2, consulta.isAgendamento());
            statement.setInt(3, id_paciente);
            statement.setInt(4, id_medico);
            statement.setInt(5, id_consultorio);
            statement.setInt(6, id_pagamento);
            statement.setString(7, consulta.getData_hora());

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

    public static void salvarMedico(Medico medico, int id_consultorio, int id_contato) {

        try {

            conexao = SQLConections.getInstance();
            int id_login = new DaoLogin().salvarLogin(medico.getLogin());
            statement = conexao.prepareStatement(SQLUtil.Medico.INSERT);
            statement.setString(1, medico.getNome());
            statement.setString(2, medico.getSexo());
            statement.setInt(3, medico.getRg());
            statement.setInt(4, id_consultorio);
            statement.setString(5, medico.getCpf());
            statement.setString(6, medico.getData_nascimento());
            statement.setString(7, medico.getData_cadastro());
            statement.setInt(8, id_login);
            statement.setInt(9, id_contato);

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvarconsulta(Consulta consulta, int id_paciente) {

        try {
            
            int id_pagamento = new DaoPagamento().salvarPagamento(consulta.getPagamento());
            int id_consultorio = new DaoConsultorio().salvarConsultorio(consulta.getConsultorio());
            int id_medico = new DaoMedico().salvarMedico(consulta.getMedico());
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Consulta.INSERT);
            statement.setString(1, consulta.getTipo());
            statement.setBoolean(2, consulta.isAgendamento());
            statement.setInt(3, id_paciente);
            statement.setInt(4, id_medico);
            statement.setInt(5, id_consultorio);
            statement.setInt(6, id_pagamento);
            statement.setString(7, consulta.getData_hora());

            statement.execute();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
