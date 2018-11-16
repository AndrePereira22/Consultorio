/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.principal;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Convenio;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Estado;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Produto;
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
        // List<Produto> produtos = fachada1.getAllProdutos();
        // Produto produto = fachada1.buscarProdutoPorId(2);
//        
//        Endereco end  = new Endereco();
//        end.setCep("58701090");
//        end.setBairro("Santo Antonio");
//        end.setNumero("Q51L10");
//        end.setEstado("PB");
//        cliente.setEndereco(end);
//        
//        Contato contato1 = new Contato();
//        contato1.setTipo(TipoContato.EMAIL);
//        contato1.setDescricao("heldonjose@gmail.com");
//        
//        
//        Contato contato2 = new Contato();
//        contato2.setTipo(TipoContato.TELEFONE);
//        contato2.setDescricao("83-9-9627-9632");
//        
//        List<Contato> contatos = new ArrayList<>();
//        contatos.add(contato1);
//        contatos.add(contato2);
//        
//        cliente.setContatos(contatos);
//        
//        fachada1.salvarCliente(cliente);
    }

}
