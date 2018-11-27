/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.SaidaEstoque;
import br.com.fundamento.view.BuscarFornecedor;
import br.com.fundamento.view.CadastroFornecedor;
import br.com.fundamento.view.CadastroProduto;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleFornecedor implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroFornecedor cadastroFornecedor;
    private BuscarFornecedor buscarFornecedor;
    private CadastroProduto cadastroProduto;
    List<Produto> produtos = new ArrayList<Produto>();
    IFachada fachada1 = Fachada.getInstance();

    public ControleFornecedor(TelaPrincipal telaPrincipal, CadastroFornecedor cadastroFornecedor, BuscarFornecedor buscarFornecedor, CadastroProduto cadastroProduto) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroFornecedor = cadastroFornecedor;
        this.buscarFornecedor = buscarFornecedor;
        this.cadastroProduto = cadastroProduto;

        telaPrincipal.getBotaoCadastroFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoCancelarrFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoSalvarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoAdicionarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoEditarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoExcluirFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoFecharFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoPesquisarFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoAdicionarProduto().addActionListener(this);
        this.cadastroProduto.getBotaoSalvarProduto().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoCadastroFornecedor()) {
            preenchertabela();

            telaPrincipal.setEnabled(false);
            buscarFornecedor.setVisible(true);
        }
        if (e.getSource() == buscarFornecedor.getBotaoFecharFornecedor()) {
            telaPrincipal.setEnabled(true);
            buscarFornecedor.setVisible(false);
        }
        if (e.getSource() == buscarFornecedor.getBotaoAdicionarFornecedor()) {

            cadastroFornecedor.setVisible(true);
            buscarFornecedor.setVisible(false);
        }
        if(e.getSource()== cadastroFornecedor.getBotaoAdicionarProduto()){
            cadastroProduto.setVisible(true);
            
            
        }
        if(e.getSource() == cadastroProduto.getBotaoSalvarProduto()){
            
            Estoque estoque = new Estoque();
            estoque.setDescricao("principal");
            estoque.setProdutos(new ArrayList<Produto>());
            estoque.setSaidasEstoque(new ArrayList<SaidaEstoque>());
            
            Produto produto = new Produto();
            produto.setEstoque(estoque);
            produto.setFabricante(cadastroProduto.getTxtFabricante().getText());
            produto.setFornecedor(null);
            produto.setNome(cadastroProduto.getTxtnomeproduto().getText());
            String  vu= cadastroProduto.getTxtvalorunitario().getText();
            String  q= cadastroProduto.getTxtquantidade().getText();
            String  qe= cadastroProduto.getTxtQuantidadeEstoque().getText();
            vu = vu.replaceAll("[^0-9]", "");
            q = q.replaceAll("[^0-9]", "");
            qe = qe.replaceAll("[^0-9]", "");
            double valor = 0;
            int quantidade = 0;
            int quantidadeestoque=0;

            try {
                valor = Double.parseDouble(vu);
                quantidade = Integer.parseInt(q);
                quantidadeestoque = Integer.parseInt(qe);
            } catch (NumberFormatException erro) {
            }
            produto.setPreco_compra(valor);
            produto.setQuantidade_estoque(quantidadeestoque);
            produto.setQuantidade_minima(quantidade);
            
            produtos.add(produto);
            cadastroProduto.setVisible(false);
        }
        if (e.getSource() == cadastroFornecedor.getBotaoCancelarrFornecedor()) {
            telaPrincipal.setEnabled(false);
            buscarFornecedor.setVisible(true);
            cadastroFornecedor.setVisible(false);
        }
        if(e.getSource() == buscarFornecedor.getBotaoPesquisarFornecedor()){
            
        List<Fornecedor> fornecedores = fachada1.getPorBuscaFornecedor(buscarFornecedor.getTxtPesquisarFornecedor().getText());

        try {
            String[] colunas = new String[]{"Nome Fantasia", "Razao Social", "cnpj"};
            Object[][] dados = new Object[fornecedores.size()][3];
            for (int i = 0; i < fornecedores.size(); i++) {
                Fornecedor fornecedor = fornecedores.get(i);
                dados[i][0] = fornecedor.getNome_fantasia();
                dados[i][1] = fornecedor.getRazao_social();
                dados[i][2] = fornecedor.getCnpj();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            buscarFornecedor.getTabelaCoFornecedor().setModel(dataModel);
        } catch (Exception ex) {

        }
    
        }
        if (e.getSource() == cadastroFornecedor.getBotaoSalvarFornecedor()) {
            
            

            Endereco end = new Endereco();
            end.setBairro(cadastroFornecedor.getTxtbairro().getText());
            end.setRua(cadastroFornecedor.getTxtrua().getText());
            end.setCep(cadastroFornecedor.getTxtcep().getText());
            end.setNumero(cadastroFornecedor.getTxtnumero().getText());
            end.setMunicipio(cadastroFornecedor.getTxtcidade().getText());
            end.setEstado(cadastroFornecedor.getTxtUf().getSelectedItem().toString());

            Contato con = new Contato();
            con.setEmail(cadastroFornecedor.getTxtemail().getText());
            con.setCelular(cadastroFornecedor.getTxtcelular().getText());
            con.setTelefone(cadastroFornecedor.getTxttelefone().getText());

            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setProdutos(produtos);
            fornecedor.setCnpj(cadastroFornecedor.getTxtcnpj().getText());
            fornecedor.setContato(con);
            fornecedor.setEndereco(end);
            fornecedor.setNome_fantasia(cadastroFornecedor.getTxtrazao1().getText());
            fornecedor.setRazao_social(cadastroFornecedor.getTxtrazao().getText());

            fachada1.salvarfornecedor(fornecedor);
            produtos.clear();
            preenchertabela();
            buscarFornecedor.setVisible(true);
            cadastroFornecedor.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }

    public void preenchertabela() {

        List<Fornecedor> fornecedores = fachada1.getAllfornecedor();

        try {
            String[] colunas = new String[]{"Nome Fantasia", "Razao Social", "cnpj"};
            Object[][] dados = new Object[fornecedores.size()][3];
            for (int i = 0; i < fornecedores.size(); i++) {
                Fornecedor fornecedor = fornecedores.get(i);
                dados[i][0] = fornecedor.getNome_fantasia();
                dados[i][1] = fornecedor.getRazao_social();
                dados[i][2] = fornecedor.getCnpj();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            buscarFornecedor.getTabelaCoFornecedor().setModel(dataModel);
        } catch (Exception ex) {

        }
    }

}
