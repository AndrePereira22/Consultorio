/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.principal;

import br.com.fundamento.dao.CommumDao;
import br.com.fundamento.enuns.TipoContato;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Convenio;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Estado;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Municipio;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.modelos.Relatorio;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.modelos.Tarefa;
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

        /// funcionando fachada1.salvarfornecedor(f);
        /// funcionando fachada1.salvarproduto(p);
        // funcionando fachada1.salvarLogin(l);
        // funcionando fachada1.salvarTarefa(t);
        // funcionando fachada1.salvarRelatorio(r);
        // FUNCIONANDO fachada1.salvarSaidaEstoque(SE);
        // funcionando fachada1.salvarEstado(e);
        // funcinando fachada1.salvarParcela(p);
        // fachada1.salvarEspecializacao(e);
        // funcionando   fachada1.salvarConsultorio(c);
        // ENDERECO FUNCIONADO;
        // CONTADO  FUNCIONADO  
        // FUNCIONANDO fachada1.salvarConvenio(co);
        // funcionando fachada1.salvarCaixa(c);
        // funcionando fachada1.salvarMunicipio(m);
        Estado et = new Estado();
        et.setNome("vh");
        et.setSigla("pe");
        
        Municipio mu = new Municipio();
        mu.setDescricao("ty");
        mu.setEstado(et);

        List<Municipio> muni = new ArrayList<>();
        muni.add(mu);
        muni.add(mu);
        muni.add(mu);
        
        et.setMunicipios(muni);
        
        Endereco e = new Endereco();
        e.setBairro("kckenkktr");
        e.setMunicipio(mu);
        
//        Fornecedor fo = new Fornecedor();
//        fo.setNome_fantasia("andre");
//
//        Contato contato1 = new Contato();
//        contato1.setTipo(TipoContato.EMAIL);
//        contato1.setDescricao("heldonjose@gmail.com");
//
//        Contato contato2 = new Contato();
//        contato2.setTipo(TipoContato.TELEFONE);
//        contato2.setDescricao("83-9-9627-9632");
//
//        List<Contato> contatos = new ArrayList<>();
//        contatos.add(contato1);
//        contatos.add(contato2);
//
//        fo.setContatos(contatos);
//        fo.setEndereco(e);
        Convenio c = new Convenio();
        c.setNome("glenda");

        Paciente p = new Paciente();
        p.setNome("andre");
        p.setConvenio(c);

        List<Paciente> pa = new ArrayList<>();

        pa.add(p);
        pa.add(p);
        pa.add(p);

        c.setPacientes(pa);

        Prontuario pro = new Prontuario();
        pro.setExames("exames");
        p.setProntuario(pro);
        p.setEndereco(e);
        
        Funcionario f = new Funcionario();
        f.setNome("Ande");
        
        Caixa cai = new Caixa();
        cai.setStatus(true);
        
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(f);
        cai.setFuncionarios(funcionarios);
        
        List<Pagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new Pagamento());
        cai.setPagamentos(pagamentos);
        
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(new Tarefa());
         tarefas.add(new Tarefa());
          tarefas.add(new Tarefa());
        f.setCaixa(cai);
        
        f.setTarefas(tarefas);
        List<Relatorio> relatorios = new ArrayList<>();
        relatorios.add(new Relatorio());
         relatorios.add(new Relatorio());
          relatorios.add(new Relatorio());
          f.setRelatorios(relatorios);
        
        
        fachada1.salvarFuncionario(f);
        
       // fachada1.salvarPaciente(p);

        // fachada1.salvarfornecedor(fo);
//fachada1.salvarMedico(m);
//fachada1.salvarEspecializacao(es);
//fachada1.salvarConsulta(cons);
//fachada1.salvarConsulta(cons);
    }
}
