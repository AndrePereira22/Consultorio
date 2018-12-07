
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.principal;

import br.com.fundamento.controle.ControleCaixa;
import br.com.fundamento.controle.ControleConsulta;
import br.com.fundamento.controle.ControlePrincipal;
import br.com.fundamento.controle.ControleFornecedor;
import br.com.fundamento.controle.ControleMedico;
import br.com.fundamento.controle.ControlePaciente;
import br.com.fundamento.controle.ControleProduto;
import br.com.fundamento.controle.ControleTarefa;
import br.com.fundamento.controle.ControlerFuncionario;
import br.com.fundamento.dao.CommumDao;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.view.AtualizarConsultorio;
import br.com.fundamento.view.BuscarCaixa;
import br.com.fundamento.view.BuscarFornecedor;
import br.com.fundamento.view.BuscarFuncionario;
import br.com.fundamento.view.BuscarMedico;
import br.com.fundamento.view.BuscarPaciente;
import br.com.fundamento.view.BuscarProduto;
import br.com.fundamento.view.BuscarTarefa;
import br.com.fundamento.view.CadastroCaixa;
import br.com.fundamento.view.CadastroConsultas;
import br.com.fundamento.view.CadastroFornecedor;
import br.com.fundamento.view.CadastroFuncionario;
import br.com.fundamento.view.CadastroMedico;
import br.com.fundamento.view.CadastroPaciente;
import br.com.fundamento.view.CadastroProduto;
import br.com.fundamento.view.CadastroTarefas;
import br.com.fundamento.view.TelaPagamento;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.util.ArrayList;

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
        CadastroCaixa cadastroCaixa = new CadastroCaixa();
        AtualizarConsultorio atualizarConsultorio = new AtualizarConsultorio();
        TelaPagamento pagamento = new TelaPagamento();
                
                
        
        
        BuscarMedico buscarMedico = new BuscarMedico();
        BuscarFuncionario buscarFuncionario = new BuscarFuncionario();
         BuscarPaciente buscarPaciente = new BuscarPaciente();
         BuscarFornecedor buscarFornecedor = new  BuscarFornecedor();
       BuscarProduto buscarProduto = new BuscarProduto();
         BuscarTarefa buscarTarefa = new BuscarTarefa();
         agendamento agendamento = new agendamento();
         BuscarCaixa buscarCaixa = new BuscarCaixa();

        ControlerFuncionario controlerFuncionario = new ControlerFuncionario(cadastroFuncionario, telaPrincipal, buscarFuncionario);
        ControlePaciente controlePaciente = new ControlePaciente(telaPrincipal, cadastroPaciente,buscarPaciente);
        ControleMedico controleMedico = new ControleMedico(telaPrincipal, cadastroMedico, buscarMedico);
        ControleFornecedor controleFornecedor = new ControleFornecedor(telaPrincipal, cadastroFornecedor, buscarFornecedor);
       ControleProduto controleProduto = new ControleProduto(telaPrincipal, cp, buscarProduto);
        ControleTarefa controleTarefa = new ControleTarefa(telaPrincipal, cadastroTarefas, buscarTarefa);
        ControleConsulta controleConsulta = new ControleConsulta(telaPrincipal, cadastroConsultas, agendamento,pagamento);
        ControleCaixa controleCaixa = new ControleCaixa(telaPrincipal, cadastroCaixa, buscarCaixa);
        ControlePrincipal controleConsultorio = new ControlePrincipal(telaPrincipal, atualizarConsultorio,telaLogin);

  
     
    }
}
