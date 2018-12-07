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
import br.com.fundamento.view.BuscarProduto;
import br.com.fundamento.view.CadastroFornecedor;
import br.com.fundamento.view.CadastroProduto;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleProduto implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroProduto cadastroProduto;
    private BuscarProduto buscarProduto;
    private List<Fornecedor> fornecedores;
    private Fornecedor fornecedor;
    private CadastroFornecedor cadastroFornecedor;

    IFachada fachada1 = Fachada.getInstance();

    public ControleProduto(TelaPrincipal telaPrincipal, CadastroProduto cadastroProduto, BuscarProduto buscarProduto) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroProduto = cadastroProduto;
        this.buscarProduto = buscarProduto;
        cadastroFornecedor = new CadastroFornecedor();

        telaPrincipal.getBotaoCadastarProduto().addActionListener(this);
        cadastroProduto.getBotaoCancelarProduto().addActionListener(this);
        cadastroProduto.getTxtFornecedor().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                PreencherBuscaFornecedor();
            }
        });
        cadastroProduto.getBotaonovo().addActionListener(this);
        cadastroProduto.getBotaoSalvarProduto().addActionListener(this);
        cadastroFornecedor.getBotaoSalvarFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoCancelarrFornecedor().addActionListener(this);
        buscarProduto.getBotaoAdicionarProduto().addActionListener(this);
        buscarProduto.getBotaoEditarProduto().addActionListener(this);
        buscarProduto.getBotaoExcluirProduto().addActionListener(this);
        buscarProduto.getBotaoFecharProduto().addActionListener(this);
        buscarProduto.getBotaoPesquisarProduto().addActionListener(this);
        cadastroProduto.getListafornecedor().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cadastroProduto.getListafornecedor().getMinSelectionIndex();
                try {

                    fornecedor = fornecedores.get(indice);
                    cadastroProduto.getTxtcnpj().setText(fornecedor.getCnpj());
                    cadastroProduto.getTxtFornecedor().setText(fornecedor.getNome_fantasia());
                } catch (Exception eu) {
                }
            }
        });
        buscarProduto.getTxtPesquisarProduto().addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                PreencherTabela();
            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoCadastarProduto()) {

            PreencherTabela();
            telaPrincipal.setEnabled(false);
            buscarProduto.setVisible(true);
        }
        if (e.getSource() == buscarProduto.getBotaoFecharProduto()) {
            telaPrincipal.setEnabled(true);
            buscarProduto.setVisible(false);
        }
        if (e.getSource() == buscarProduto.getBotaoAdicionarProduto()) {

            cadastroProduto.setVisible(true);
            PreencherBuscaFornecedor();
            buscarProduto.setVisible(false);
        }
        if (e.getSource() == cadastroFornecedor.getBotaoCancelarrFornecedor()) {
            cadastroFornecedor.setVisible(false);

        }
        if (e.getSource() == cadastroProduto.getBotaonovo()) {
            cadastroFornecedor.setVisible(true);
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
            fornecedor.setCnpj(cadastroFornecedor.getTxtcnpj().getText());
            fornecedor.setProdutos(new ArrayList<Produto>());
            fornecedor.setContato(con);
            fornecedor.setEndereco(end);
            fornecedor.setNome_fantasia(cadastroFornecedor.getTxtrazao1().getText());
            fornecedor.setRazao_social(cadastroFornecedor.getTxtrazao().getText());

            fachada1.salvarfornecedor(fornecedor);
            cadastroFornecedor.setVisible(false);
            PreencherBuscaFornecedor();

        }

        if (e.getSource() == cadastroProduto.getBotaoCancelarProduto()) {
            PreencherTabela();
            telaPrincipal.setEnabled(false);
            buscarProduto.setVisible(true);
            cadastroProduto.setVisible(false);
        }
        if (e.getSource() == buscarProduto.getBotaoPesquisarProduto()) {

            PreencherTabela();
        }
        if (e.getSource() == cadastroProduto.getBotaoSalvarProduto()) {

            Endereco end = new Endereco();
            end.setBairro("");
            end.setRua("");
            end.setCep("");
            end.setNumero("");
            end.setMunicipio("");
            end.setEstado("");

            Contato con = new Contato();
            con.setEmail("");
            con.setCelular("");
            con.setTelefone("");

            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setProdutos(new ArrayList<Produto>());
            fornecedor.setCnpj("");
            fornecedor.setContato(con);
            fornecedor.setEndereco(end);
            fornecedor.setNome_fantasia("");
            fornecedor.setRazao_social("");

            Estoque es = new Estoque();
            es.setDescricao("");
            es.setSaidasEstoque(new ArrayList<SaidaEstoque>());
            es.setProdutos(new ArrayList<Produto>());

            Produto produto = new Produto();
            produto.setEstoque(es);
            produto.setFornecedor(fornecedor);
            produto.setFabricante(cadastroProduto.getTxtFabricante().getText());
            produto.setNome(cadastroProduto.getTxtnomeproduto().getText());
            String vu = cadastroProduto.getTxtvalorunitario().getText();

            String q = cadastroProduto.getTxtquantidade().getText();

            vu = vu.replaceAll("[^0-9]", "");
            q = q.replaceAll("[^0-9]", "");

            double valor = 0;
            int quantidade = 0;

            try {
                valor = Double.parseDouble(vu);
                quantidade = Integer.parseInt(q);

            } catch (NumberFormatException erro) {
            }
            produto.setPreco_compra(valor);
            produto.setQuantidade_estoque(quantidade);
            produto.setFornecedor(fornecedor);

            if (fornecedor != null) {
                fachada1.salvarProduto(produto);
            }

            PreencherTabela();
            buscarProduto.setVisible(true);
            cadastroProduto.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }

    public void PreencherTabela() {
        List<Produto> produtos = fachada1.getPorBuscaProduto(buscarProduto.getTxtPesquisarProduto().getText());

        try {
            String[] colunas = new String[]{"Nome", "Fabricante", "Quantidade Estoque", "Preco Compra"};
            Object[][] dados = new Object[produtos.size()][4];
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                dados[i][0] = produto.getNome();
                dados[i][1] = produto.getFabricante();
                dados[i][2] = produto.getQuantidade_estoque();
                dados[i][3] = produto.getPreco_compra();
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            buscarProduto.getTabela().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void PreencherBuscaFornecedor() {

        fornecedores = fachada1.getPorBuscaFornecedor(cadastroProduto.getTxtFornecedor().getText());

        DefaultListModel model = new DefaultListModel();
        for (Fornecedor f : fornecedores) {

            model.addElement(f.getNome_fantasia());
        }

        cadastroProduto.getListafornecedor().setModel(model);

    }

}
