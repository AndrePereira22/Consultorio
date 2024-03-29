/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.fachada;

import br.com.fundamento.business.BusinessCaixa;
import br.com.fundamento.business.BusinessConsulta;
import br.com.fundamento.business.BusinessConsultorio;
import br.com.fundamento.business.BusinessContaPagar;
import br.com.fundamento.business.BusinessEntradaEstoque;
import br.com.fundamento.business.BusinessEspecializacao;
import br.com.fundamento.business.BusinessEstoque;
import br.com.fundamento.business.BusinessFornecedor;
import br.com.fundamento.business.BusinessFuncionario;
import br.com.fundamento.business.BusinessLogin;
import br.com.fundamento.business.BusinessMedico;
import br.com.fundamento.business.BusinessPaciente;
import br.com.fundamento.business.BusinessPagamento;
import br.com.fundamento.business.BusinessParcela;
import br.com.fundamento.business.BusinessProduto;
import br.com.fundamento.business.BusinessProntuario;
import br.com.fundamento.business.BusinessSaidaEstoque;
import br.com.fundamento.business.BusinessTarefa;
import br.com.fundamento.business.IBusinessCaixa;
import br.com.fundamento.business.IBusinessConsulta;
import br.com.fundamento.business.IBusinessConsultorio;
import br.com.fundamento.business.IBusinessContaPagar;
import br.com.fundamento.business.IBusinessEntradaEstoque;

import br.com.fundamento.business.IBusinessEspecializacao;
import br.com.fundamento.business.IBusinessEstoque;
import br.com.fundamento.business.IBusinessFornecedor;
import br.com.fundamento.business.IBusinessFuncionario;
import br.com.fundamento.business.IBusinessLogin;
import br.com.fundamento.business.IBusinessMedico;
import br.com.fundamento.business.IBusinessPaciente;
import br.com.fundamento.business.IBusinessPagamento;
import br.com.fundamento.business.IBusinessParcela;
import br.com.fundamento.business.IBusinessProduto;
import br.com.fundamento.business.IBusinessProntuario;
import br.com.fundamento.business.IBusinessSaidaEstoque;
import br.com.fundamento.business.IBusinessTarefa;
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
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.modelos.Tarefa;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class Fachada implements IFachada {

    private static Fachada instance;
    private IBusinessProduto businessProduto;
    private IBusinessLogin businessLogin;
    private IBusinessEstoque businessEstoque;
    private IBusinessFornecedor businessFornecedor;
    private IBusinessTarefa businessTarefa;
    private IBusinessSaidaEstoque businessSaidaEstoque;
    private IBusinessParcela businessParcela;
    private IBusinessEspecializacao businessEspecializacao;
    private IBusinessConsultorio businessConsultorio;
    private IBusinessCaixa businessCaixa;
    private IBusinessConsulta businessConsulta;
    private IBusinessFuncionario businessFuncionario;
    private IBusinessMedico businessMedico;
    private IBusinessPaciente businessPaciente;
    private IBusinessPagamento businessPagamento;
    private IBusinessProntuario businessProntuario;
    private IBusinessEntradaEstoque businessEntradaEstoque;
    private IBusinessContaPagar businessContaPagar;

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    private Fachada() {

        this.businessProduto = new BusinessProduto();
        this.businessLogin = new BusinessLogin();
        this.businessEstoque = new BusinessEstoque();
        this.businessFornecedor = new BusinessFornecedor();
        this.businessTarefa = new BusinessTarefa();
        this.businessSaidaEstoque = new BusinessSaidaEstoque();
        this.businessParcela = new BusinessParcela();
        this.businessEspecializacao = new BusinessEspecializacao();
        this.businessConsultorio = new BusinessConsultorio();
        this.businessCaixa = new BusinessCaixa();
        this.businessConsulta = new BusinessConsulta();
        this.businessFuncionario = new BusinessFuncionario();
        this.businessMedico = new BusinessMedico();
        this.businessPaciente = new BusinessPaciente();
        this.businessPagamento = new BusinessPagamento();
        this.businessProntuario = new BusinessProntuario();
        this.businessEntradaEstoque = new BusinessEntradaEstoque();
        this.businessContaPagar = new BusinessContaPagar();

    }

    @Override
    public void salvarProduto(Produto produto) {
        this.businessProduto.salvar(produto);
    }

    @Override
    public Produto buscarProdutoPorId(int id) {
        return this.businessProduto.buscarPorId(id);

    }

    @Override
    public List<Produto> getAllProdutos() {
        return this.businessProduto.getAll();
    }

    @Override
    public void editarProduto(Produto produto) {
        this.businessProduto.editar(produto);
    }

    @Override
    public void ativarDesativarProduto(int id) {
        this.businessProduto.ativarDesativar(id);
    }

    @Override
    public void ativarDesativarLogin(int id) {
        this.businessLogin.ativarDesativarLogin(id);
    }

    @Override
    public void salvarLogin(Login login) {
        this.businessLogin.salvarLogin(login);
    }

    @Override
    public void editarLogin(Login login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login buscarLoginPorId(int id) {
        return this.businessLogin.buscarLoginPorId(id);
    }

    @Override
    public List<Login> getAllLogin() {
        return this.businessLogin.getAllLogin();
    }

    public void salvarEstoque(Estoque estoque) {
        this.businessEstoque.salvarEstoque(estoque);
    }

    @Override
    public Estoque buscarEstoquePorId(int id) {
        return this.businessEstoque.buscarPorEstoqueId(id);
    }

    @Override
    public List<Estoque> getAllEstoque() {
        return this.businessEstoque.getAllEstoque();
    }

    @Override
    public void editarEstoque(Estoque estoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEstoqur(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarfornecedor(Fornecedor fornecedor) {
        this.businessFornecedor.salvarfornecedor(fornecedor);
    }

    @Override
    public Fornecedor buscarPorfornecedorId(int id) {
        return this.businessFornecedor.buscarPorfornecedorId(id);
    }

    @Override
    public List<Fornecedor> getAllfornecedor() {
        return this.businessFornecedor.getAllfornecedor();
    }

    @Override
    public void editarfornecedor(Fornecedor fornecedor) {
        this.businessFornecedor.editarfornecedor(fornecedor);
    }

    @Override
    public void ativarDesativarfornecedor(int id) {
        this.businessFornecedor.ativarDesativarfornecedor(id);
    }

    @Override
    public List<Fornecedor> getPorBuscaFornecedor(String busca) {
        return this.businessFornecedor.getPorBuscaFornecedor(busca);
    }

    @Override
    public int salvarCaixa(Caixa caixa) {
        return this.businessCaixa.salvarCaixa(caixa);
    }

    @Override
    public Caixa buscarCaixaPorId(int id) {
        return this.businessCaixa.buscarCaixaPorId(id);
    }

    @Override
    public List<Caixa> getAllCaixa() {
        return this.businessCaixa.getAllCaixa();
    }

    @Override
    public void editarCaixa(Caixa caixa) {
   this.businessCaixa.editarCaixa(caixa);
    }

    @Override
    public void ativarDesativarCaixa(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarConsulta(Consulta consulta) {
        this.businessConsulta.salvarConsulta(consulta);
    }

    @Override
    public Consulta buscarConsultaPorId(int id) {
        return this.businessConsulta.buscarConsultaPorId(id);
    }

    @Override
    public List<Consulta> getAllConsulta() {
        return this.businessConsulta.getAllConsulta();
    }

    @Override
    public void editarConsulta(Consulta consulta) {
      this.businessConsulta.editarConsulta(consulta);
    }

    @Override
    public void ativarDesativarConsulta(int id) {
       this.businessConsulta.ativarDesativarConsulta(id);
    }

    @Override
    public void salvarEspecializacao(Especializacao especializacao) {

        this.businessEspecializacao.salvarEspecializacao(especializacao);
    }

    @Override
    public Especializacao buscarEspecializacaoPorId(int id) {
        return this.businessEspecializacao.buscarEspecializacaoPorId(id);
    }

    @Override
    public List<Especializacao> getAllEspecializacao() {
        return this.businessEspecializacao.getAllEspecializacao();
    }

    @Override
    public void editarEspecializacao(Especializacao especializacao) {
        this.businessEspecializacao.editarEspecializacao(especializacao);
    }

    @Override
    public void ativarDesativarEspecializacao(int id) {
        this.businessEspecializacao.ativarDesativarEspecializacao(id);
    }

    @Override
    public void salvarFuncionario(Funcionario funcionario) {
        this.businessFuncionario.salvarFuncionario(funcionario);
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int id) {
        return this.businessFuncionario.buscarFuncionarioPorId(id);
    }

    @Override
    public List<Funcionario> getAllFuncionario() {
        return this.businessFuncionario.getAllFuncionario();

    }

    @Override
    public void editarFuncionario(Funcionario funcionario) {
        this.businessFuncionario.editarFuncionario(funcionario);
    }

    @Override
    public void ativarDesativarFuncionario(int id) {
        this.businessFuncionario.ativarDesativarFuncionario(id);
    }

    @Override
    public List<Funcionario> getPorBuscaFuncionario(String busca) {
        return this.businessFuncionario.getPorBuscaFuncionario(busca);

    }

    @Override
    public void salvarMedico(Medico medico) {
        this.businessMedico.salvarMedico(medico);
    }

    @Override
    public Medico buscarMedicoPorId(int id) {
        return this.businessMedico.buscarMedicoPorId(id);
    }

    @Override
    public List<Medico> getAllMedico() {
        return this.businessMedico.getAllMedico();
    }

    @Override
    public void editarMedico(Medico medico) {
        this.businessMedico.editarMedico(medico);
    }

    @Override
    public void ativarDesativarMedico(int id) {
        this.businessMedico.ativarDesativarMedico(id);

    }

    @Override
    public List<Medico> getPorBuscaMedico(String busca) {
        return this.businessMedico.getPorBuscaMedico(busca);
    }

    @Override
    public void salvarPaciente(Paciente paciente) {
        this.businessPaciente.salvarPaciente(paciente);
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        return this.businessPaciente.buscarPacientePorId(id);
    }

    @Override
    public List<Paciente> getAllPaciente() {
        return this.businessPaciente.getAllPaciente();
    }

    @Override
    public void editarPaciente(Paciente paciente) {
        this.businessPaciente.editarPaciente(paciente);
    }

    @Override
    public void ativarDesativarPaciente(int id) {
        this.businessPaciente.ativarDesativarPaciente(id);
    }

    @Override
    public List<Paciente> getPorBusca(String busca) {
        return this.businessPaciente.getPorBusca(busca);
    }

    @Override
    public void salvarPagamento(Pagamento pagamento) {
        this.businessPagamento.salvarPagamento(pagamento);
    }

    @Override
    public Pagamento buscarPagamentoPorId(int id) {
        return this.businessPagamento.buscarPagamentoPorId(id);
    }

    @Override
    public List<Pagamento> getAllPagamento() {
        return this.businessPagamento.getAllPagamento();
    }

    @Override
    public void editarPagamento(Pagamento pagamento) {
    this.businessPagamento.editarPagamento(pagamento);
    }

    @Override
    public void ativarDesativarPagamento(int id) {
     this.businessPagamento.ativarDesativarPagamento(id);
    }

    @Override
    public void salvarParcela(Parcela parcela) {
        this.businessParcela.salvarParcela(parcela);
    }

    @Override
    public Parcela buscarParcelaPorId(int id) {
        return this.businessParcela.buscarParcelaPorId(id);
    }

    @Override
    public List<Parcela> getAllParcela() {
        return this.businessParcela.getAllParcela();
    }

    @Override
    public void editarParcela(Parcela parcela) {
    this.businessParcela.editarParcela(parcela);
    }

    @Override
    public void ativarDesativarParcela(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarProntuario(Prontuario prontuario) {
        this.businessProntuario.salvarProntuario(prontuario);
    }

    @Override
    public Prontuario buscarProntuarioPorId(int id) {
        return this.businessProntuario.buscarProntuarioPorId(id);
    }

    @Override
    public List<Prontuario> getAllProntuario() {
        return this.businessProntuario.getAllProntuario();
    }

    @Override
    public void editarProntuario(Prontuario prontuario) {
        this.businessProntuario.editarProntuario(prontuario);
    }

    @Override
    public void ativarDesativarProntuario(int id) {
        this.businessProntuario.ativarDesativarProntuario(id);
    }

    @Override
    public void salvarSaidaEstoque(SaidaEstoque saidaEstoque) {
        this.businessSaidaEstoque.salvarSaidaEstoque(saidaEstoque);
    }

    @Override
    public SaidaEstoque buscarSaidaEstoquePorId(int id) {
        return this.businessSaidaEstoque.buscarSaidaEstoquePorId(id);
    }

    @Override
    public List<SaidaEstoque> getAllSaidaEstoque() {
        return this.businessSaidaEstoque.getAllSaidaEstoque();
    }

    @Override
    public void editarSaidaEstoque(SaidaEstoque saidaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarSaidaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        this.businessTarefa.salvarTarefa(tarefa);
    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        return this.businessTarefa.buscarTarefaPorId(id);
    }

    @Override
    public List<Tarefa> getAllTarefa() {
        return this.businessTarefa.getAllTarefa();
    }

    @Override
    public void editarTarefa(Tarefa tarefa) {
        this.businessTarefa.editarTarefa(tarefa);
    }

    @Override
    public void ativarDesativarTarefa(int id) {
        this.businessTarefa.ativarDesativarTarefa(id);
    }

   

    @Override
    public void salvarConsultorio(Consultorio consultorio) {
        this.businessConsultorio.salvarConsultorio(consultorio);
    }

    @Override
    public Consultorio buscarConsultorioPorId(int id) {
        return this.businessConsultorio.buscarConsultorioPorId(id);
    }

    @Override
    public List<Consultorio> getAllConsultorio() {
        return this.businessConsultorio.getAllConsultorio();
    }

    @Override
    public void editarConsultorio(Consultorio consultorio) {
        this.businessConsultorio.editarConsultorio(consultorio);
    }

    @Override
    public void ativarDesativarConsultorio(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> getPorBuscaProduto(String busca) {
        return this.businessProduto.getPorBuscaProduto(busca);
    }

    @Override
    public List<Tarefa> getPorBuscaTarefa(String busca) {
        return this.businessTarefa.getPorBuscaTarefa(busca);
    }

    @Override
    public List<Consulta> getPorBuscaConsulta(String busca) {
        return this.businessConsulta.getPorBuscaConsulta(busca);
    }

    @Override
    public Medico BuscarMedico(String busca) {
        return this.businessMedico.getBuscarMedico(busca);
    }

    @Override
    public Login buscarLogin(String nome) {
        return this.businessLogin.buscarLogin(nome);
    }

    @Override
    public Login buscarLoginMedico(String parametro, String nome) {
        return this.businessLogin.buscarLoginMedico(parametro, nome);
    }

    @Override
    public Consultorio bucarConsultorio() {
        return this.businessConsultorio.bucarConsultorio();
    }

    @Override
    public Especializacao buscarEspecializaco(String busca) {
        return this.businessEspecializacao.buscarEspecializaco(busca);
    }

    @Override
    public Paciente buscarPaciente(String busca) {
        return this.businessPaciente.buscarPaciente(busca);
    }

    @Override
    public Prontuario buscarProntuario(String busca) {
        return this.businessProntuario.buscarProntuario(busca);
    }

    @Override
    public List<SaidaEstoque> getPorBuscaSaidaEstoque(String busca) {
        return this.businessSaidaEstoque.getPorBuscaSaidaEstoque(busca);
    }

    @Override
    public void salvarEntradaEstoque(EntradaEstoque entradaEstoque) {
    this.businessEntradaEstoque.salvarEntradaEstoque(entradaEstoque);
    }

    @Override

    public EntradaEstoque buscarEntradaEstoquePorId(int id) {
        return this.businessEntradaEstoque.buscarEntradaEstoquePorId(id);
    }

    @Override
    public List<EntradaEstoque> getAllEntradaEstoque() {
      return  this.businessEntradaEstoque.getAllEntradaEstoque();
    }

    @Override
    public void editarEntradaEstoque(EntradaEstoque entradaEstoque) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ativarDesativarEntradaEstoque(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntradaEstoque> getPorBuscaEntradaEstoque(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarContaPagar(ContaPagar contaPagar) {
     this.businessContaPagar.salvarContaPagar(contaPagar);
    }

    @Override
    public ContaPagar buscarContaPagarPorId(int id) {
      return  this.businessContaPagar.buscarContaPagarPorId(id);
    }

    @Override
    public List<ContaPagar> getAllContaPagar() {
     return  this.businessContaPagar.getAllContaPagar();
    }

    @Override
    public void editarContaPagar(ContaPagar contaPagar) {
     this.businessContaPagar.editarContaPagar(contaPagar);
    }

    @Override
    public void ativarDesativarContaPagar(int id) {
     this.businessContaPagar.ativarDesativarContaPagar(id);
    }

    @Override
    public List<Parcela> buscarParcela(int id) {
    return  this.businessParcela.buscarParcela(id);
    }
}
