/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.fachada;

import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.ContaPagar;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.EntradaEstoque;
import br.com.fundamento.modelos.Especializacao;

import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;

import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.modelos.Relatorio;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public interface IFachada {
    
    public void salvarLogin(Login login);
    public Login buscarLoginPorId(int id);
    public List<Login> getAllLogin();
    public void editarLogin(Login login);
    public void ativarDesativarLogin(int id);
    public Login buscarLogin(String nome);
    public Login buscarLoginMedico(String parametro,String nome);

    public void salvarProduto(Produto produto);
    public Produto buscarProdutoPorId(int id);
    public List<Produto> getAllProdutos();
    public void editarProduto(Produto produto);
    public void ativarDesativarProduto(int id);
     public List<Produto> getPorBuscaProduto(String busca);
    
    public void salvarEstoque(Estoque estoque);
    public Estoque buscarEstoquePorId(int id);
    public List<Estoque> getAllEstoque();
    public void editarEstoque(Estoque estoque);
    public void ativarDesativarEstoqur(int id);
    
    public void salvarfornecedor(Fornecedor fornecedor);
    public Fornecedor buscarPorfornecedorId(int id);
    public List<Fornecedor> getAllfornecedor();
    public void editarfornecedor(Fornecedor fornecedor);
    public void ativarDesativarfornecedor(int id);
    public List<Fornecedor> getPorBuscaFornecedor(String busca);
    
    
    public int salvarCaixa(Caixa caixa);
    public Caixa buscarCaixaPorId(int id);
    public List<Caixa> getAllCaixa();
    public void editarCaixa(Caixa caixa);
    public void ativarDesativarCaixa(int id);
    
    public void salvarConsultorio(Consultorio consultorio);
    public Consultorio buscarConsultorioPorId(int id);
    public List<Consultorio> getAllConsultorio();
    public void editarConsultorio(Consultorio consultorio);
    public void ativarDesativarConsultorio(int id);
     public Consultorio bucarConsultorio();
     
    public void salvarContaPagar(ContaPagar contaPagar);
    public ContaPagar buscarContaPagarPorId(int id);
    public List<ContaPagar> getAllContaPagar();
    public void editarContaPagar(ContaPagar contaPagar);
    public void ativarDesativarContaPagar(int id);
 
    
    public void salvarConsulta(Consulta consulta);
    public Consulta buscarConsultaPorId(int id);
    public List<Consulta> getAllConsulta();
    public void editarConsulta(Consulta consulta);
    public void ativarDesativarConsulta(int id);
     public List<Consulta> getPorBuscaConsulta(String busca);
    
    public void salvarEspecializacao(Especializacao especializacao);
    public Especializacao buscarEspecializacaoPorId(int id);
    public List<Especializacao> getAllEspecializacao();
    public void editarEspecializacao(Especializacao especializacao);
    public void ativarDesativarEspecializacao(int id);
    public Especializacao buscarEspecializaco(String busca);
    

  
    
    
    public void salvarFuncionario(Funcionario funcionario);
    public Funcionario buscarFuncionarioPorId(int id);
    public List<Funcionario> getAllFuncionario();
    public void editarFuncionario(Funcionario funcionario);
    public void ativarDesativarFuncionario(int id);
    public List<Funcionario> getPorBuscaFuncionario(String busca);
    
    public void salvarMedico(Medico medico);
    public Medico buscarMedicoPorId(int id);
    public List<Medico> getAllMedico();
    public void editarMedico(Medico medico);
    public void ativarDesativarMedico(int id);
    public List<Medico> getPorBuscaMedico(String busca);
    public Medico BuscarMedico(String busca);
    
   
    public void salvarPaciente(Paciente paciente);
    public Paciente buscarPacientePorId(int id);
    public List<Paciente> getAllPaciente();
    public void editarPaciente(Paciente paciente);
    public void ativarDesativarPaciente(int id);
    public List<Paciente> getPorBusca(String busca);
     public Paciente buscarPaciente(String busca) ;
    
    public void salvarPagamento(Pagamento pagamento);
    public Pagamento buscarPagamentoPorId(int id);
    public List<Pagamento> getAllPagamento();
    public void editarPagamento(Pagamento pagamento);
    public void ativarDesativarPagamento(int id);
    
    public void salvarParcela(Parcela parcela);
    public Parcela buscarParcelaPorId(int id);
    public List<Parcela> getAllParcela();
    public void editarParcela(Parcela parcela);
    public void ativarDesativarParcela(int id);
    public List<Parcela> buscarParcela(int id);
    
    public void salvarProntuario(Prontuario prontuario);
    public Prontuario buscarProntuarioPorId(int id);
    public List<Prontuario> getAllProntuario();
    public void editarProntuario(Prontuario prontuario);
    public void ativarDesativarProntuario(int id);
    public Prontuario buscarProntuario(String busca);
    
    public void salvarSaidaEstoque(SaidaEstoque saidaEstoque);
    public SaidaEstoque buscarSaidaEstoquePorId(int id);
    public List<SaidaEstoque> getAllSaidaEstoque();
    public void editarSaidaEstoque(SaidaEstoque saidaEstoque);
    public void ativarDesativarSaidaEstoque(int id);
     public List<SaidaEstoque> getPorBuscaSaidaEstoque(String busca);
     
    public void salvarEntradaEstoque(EntradaEstoque entradaEstoque);
    public EntradaEstoque buscarEntradaEstoquePorId(int id);
    public List<EntradaEstoque> getAllEntradaEstoque();
    public void editarEntradaEstoque(EntradaEstoque entradaEstoque);
    public void ativarDesativarEntradaEstoque(int id);
    public List<EntradaEstoque> getPorBuscaEntradaEstoque(String busca);
    
    
    public void salvarTarefa(Tarefa tarefa);
    public Tarefa buscarTarefaPorId(int id);
    public List<Tarefa> getAllTarefa();
    public void editarTarefa(Tarefa tarefa);
    public void ativarDesativarTarefa(int id);
      public List<Tarefa> getPorBuscaTarefa(String busca);
    
    
    public void salvarRelatorio(Relatorio relatorio);
    public Relatorio  buscarRlatorioPorId(int id);
    public List<Relatorio> getAllRelatorio();
    public void editarRelatorio(Relatorio relatroio);
    public void ativarDesativarRelatorio(int id);
    
    
    

}
