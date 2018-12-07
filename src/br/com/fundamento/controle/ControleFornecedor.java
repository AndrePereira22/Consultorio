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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    IFachada fachada1 = Fachada.getInstance();

    public ControleFornecedor(TelaPrincipal telaPrincipal, CadastroFornecedor cadastroFornecedor, BuscarFornecedor buscarFornecedor) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroFornecedor = cadastroFornecedor;
        this.buscarFornecedor = buscarFornecedor;

        telaPrincipal.getBotaoCadastroFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoCancelarrFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoSalvarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoAdicionarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoEditarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoExcluirFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoFecharFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoPesquisarFornecedor().addActionListener(this);
        buscarFornecedor.getTxtPesquisarFornecedor().addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                preenchertabela();
            }

        });
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
        if (e.getSource() == cadastroFornecedor.getBotaoCancelarrFornecedor()) {
            telaPrincipal.setEnabled(false);
            buscarFornecedor.setVisible(true);
            cadastroFornecedor.setVisible(false);
        }
        if (e.getSource() == buscarFornecedor.getBotaoPesquisarFornecedor()) {
            preenchertabela();

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
            preenchertabela();
            buscarFornecedor.setVisible(true);
            cadastroFornecedor.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }

    public void preenchertabela() {

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
}
