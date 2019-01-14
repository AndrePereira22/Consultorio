
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.principal;

import br.com.fundamento.controle.ControleCaixa;
import br.com.fundamento.controle.ControleConsulta;
import br.com.fundamento.controle.ControleEstoque;
import br.com.fundamento.controle.ControlePrincipal;
import br.com.fundamento.controle.ControleFornecedor;
import br.com.fundamento.controle.ControleMedico;
import br.com.fundamento.controle.ControlePaciente;
import br.com.fundamento.controle.ControleProduto;
import br.com.fundamento.controle.ControleRelatorios;
import br.com.fundamento.controle.ControleTarefa;
import br.com.fundamento.controle.ControlerFuncionario;
import br.com.fundamento.dao.DaoCaixa;
import br.com.fundamento.dao.DaoConsulta;
import br.com.fundamento.dao.DaoContaPagar;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.ContaPagar;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.view.BuscarContaApagar;
import br.com.fundamento.view.BuscarContaaReceber;
import br.com.fundamento.view.BuscarEntradaEstoque;
import br.com.fundamento.view.BuscarFornecedor;
import br.com.fundamento.view.BuscarFuncionario;
import br.com.fundamento.view.BuscarMedico;
import br.com.fundamento.view.BuscarPaciente;
import br.com.fundamento.view.BuscarProduto;
import br.com.fundamento.view.BuscarSaidaEstoque;
import br.com.fundamento.view.BuscarTarefa;
import br.com.fundamento.view.CadastroConsultas;
import br.com.fundamento.view.CadastroFornecedor;
import br.com.fundamento.view.CadastroFuncionario;
import br.com.fundamento.view.CadastroMedico;
import br.com.fundamento.view.CadastroPaciente;
import br.com.fundamento.view.CadastroProduto;
import br.com.fundamento.view.CadastroTarefas;
import br.com.fundamento.view.ContaReceber;
import br.com.fundamento.view.ContaaPagar;
import br.com.fundamento.view.Entrada_Estoque;
import br.com.fundamento.view.FluxodeCaixa;
import br.com.fundamento.view.Recibo;
import br.com.fundamento.view.Relatorio;
import br.com.fundamento.view.Saida_Es;
import br.com.fundamento.modelos.EntradaEstoque;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.view.AtualizarConsultorio;
import br.com.fundamento.view.Historico;
import br.com.fundamento.view.ListaConsulta;
import br.com.fundamento.view.Receita_Exames;
import br.com.fundamento.view.TelaProntuario;
import br.com.fundamento.view.TelaPagamento;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author prof Heldon
 */
public class Main {

    public static void main(String[] a) {

        IFachada fachada1 = Fachada.getInstance();

        TelaLogin telaLogin = new TelaLogin();
        TelaPrincipal telaPrincipal = new TelaPrincipal();

        CadastroFornecedor cadastroFornecedor = new CadastroFornecedor();
        CadastroPaciente cadastroPaciente = new CadastroPaciente();
        CadastroFuncionario cadastroFuncionario = new CadastroFuncionario();
        CadastroMedico cadastroMedico = new CadastroMedico();
        CadastroProduto cadastroProduto = new CadastroProduto();
        CadastroProduto cp = new CadastroProduto();
        CadastroTarefas cadastroTarefas = new CadastroTarefas();
        CadastroConsultas cadastroConsultas = new CadastroConsultas();
        TelaPagamento pagamento = new TelaPagamento();
        FluxodeCaixa fluxodeCaixa = new FluxodeCaixa();
        ContaReceber contaReceber = new ContaReceber();
        ContaaPagar contaaPagar = new ContaaPagar();
        Entrada_Estoque entrada_Estoque = new Entrada_Estoque();
        Saida_Es saida_Estoque = new Saida_Es();
        Relatorio relatorio = new Relatorio();
        Recibo recibo = new Recibo();
        ListaConsulta lconsulta = new ListaConsulta();
        TelaProntuario prontuario = new TelaProntuario();
        Historico historico = new Historico();
        AtualizarConsultorio atualizarConsultorio = new AtualizarConsultorio();
        Receita_Exames exames= new Receita_Exames();

        BuscarMedico buscarMedico = new BuscarMedico();
        BuscarFuncionario buscarFuncionario = new BuscarFuncionario();
        BuscarPaciente buscarPaciente = new BuscarPaciente();
        BuscarFornecedor buscarFornecedor = new BuscarFornecedor();
        BuscarProduto buscarProduto = new BuscarProduto();
        BuscarTarefa buscarTarefa = new BuscarTarefa();
        BuscarContaApagar buscarContaApagar = new BuscarContaApagar();
        BuscarContaaReceber buscarContaaReceber = new BuscarContaaReceber();
        agendamento agendamento = new agendamento();
        BuscarSaidaEstoque buscarSaidaEstoque = new BuscarSaidaEstoque();
        BuscarEntradaEstoque buscarEntradaEstoque = new BuscarEntradaEstoque();

        ControlerFuncionario controlerFuncionario = new ControlerFuncionario(cadastroFuncionario, telaPrincipal, buscarFuncionario);
        ControlePaciente controlePaciente = new ControlePaciente(telaPrincipal, cadastroPaciente, buscarPaciente);
        ControleMedico controleMedico = new ControleMedico(telaPrincipal, cadastroMedico, buscarMedico);
        ControleFornecedor controleFornecedor = new ControleFornecedor(telaPrincipal, cadastroFornecedor, buscarFornecedor);
        ControleProduto controleProduto = new ControleProduto(telaPrincipal, cp, buscarProduto);
        ControleTarefa controleTarefa = new ControleTarefa(telaPrincipal, cadastroTarefas, buscarTarefa);
        ControleConsulta controleConsulta = new ControleConsulta(telaPrincipal, cadastroConsultas, agendamento, pagamento);
        ControlePrincipal controleConsultorio = new ControlePrincipal(telaPrincipal, telaLogin, lconsulta, prontuario, historico, atualizarConsultorio,exames);
        ControleCaixa controleCaixa = new ControleCaixa(telaPrincipal, fluxodeCaixa, buscarContaApagar, buscarContaaReceber, contaReceber, contaaPagar);
        ControleEstoque controleEstoque = new ControleEstoque(telaPrincipal, saida_Estoque, entrada_Estoque, buscarSaidaEstoque, buscarEntradaEstoque);
        ControleRelatorios controleRelatorios =  new ControleRelatorios(telaPrincipal, relatorio, recibo);
       
        






    } 
}
