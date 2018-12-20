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
import br.com.fundamento.modelos.Render;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleProduto implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroProduto cadastroProduto,cp;
    private BuscarProduto buscarProduto;
    private List<Fornecedor> fornecedores;
    private Fornecedor fornecedor;
    private List<Estoque> estoques;
    private Estoque estoque;
    private CadastroFornecedor cadastroFornecedor;
    private JButton btn1, btn2;
    private  List<Produto> produtos;
    private Produto p;

    IFachada fachada1 = Fachada.getInstance();

    public ControleProduto(TelaPrincipal telaPrincipal, CadastroProduto cadastroProduto, BuscarProduto buscarProduto) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroProduto = cadastroProduto;
        this.buscarProduto = buscarProduto;
        cadastroFornecedor = new CadastroFornecedor();
        cp = new CadastroProduto();
        telaPrincipal.getBotaoCadastarProduto().addActionListener(this);
        cadastroProduto.getBotaoCancelarProduto().addActionListener(this);
        cadastroProduto.getTxtFornecedor().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                PreencherBuscaFornecedor(cadastroProduto);
            }
        });
        cadastroProduto.getBotaonovo().addActionListener(this);
        cadastroProduto.getBotaoSalvarProduto().addActionListener(this);
        cadastroFornecedor.getBotaoSalvarFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoCancelarrFornecedor().addActionListener(this);
        buscarProduto.getBotaoAdicionarProduto().addActionListener(this);
        buscarProduto.getBotaoFecharProduto().addActionListener(this);
        buscarProduto.getTabela().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column =  buscarProduto.getTabela().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() /  buscarProduto.getTabela().getRowHeight();

                if (row < buscarProduto.getTabela().getRowCount() && row >= 0 && column <  buscarProduto.getTabela().getColumnCount() && column >= 0) {
                    Object value =  buscarProduto.getTabela().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                              int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarProduto.getTabela().getSelectedRow();
                            if (editar == 0) {
                                if(cp==null)cp =new CadastroProduto();
                                cp.getBotaonovo().setVisible(false);
                                cp.getLabelproduto().setText("ATUALIZAR PRODUTO");
                                cp.setVisible(true);
                                buscarProduto.setVisible(false);

                                p = produtos.get(ro);
                                preencherCadastro(p, cp);
                                PreencherBuscaFornecedor(cp);
                                PreencherEstoque(cp);
                                try {
                                    cp.getBotaoSalvarProduto().addActionListener(new Acaoupdate());
                                    cp.getBotaoCancelarProduto().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            cp.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            buscarProduto.setVisible(true);
                                            buscarProduto.getTxtPesquisarProduto().setText("");
                                            PreencherTabela();
                                            cp = null;
                                            p = null;

                                        }
                                    });

                                } catch (Exception ui) {
                                }
                            }
                        }
                        if (boton.getName().equals("e")) {
                              int editar = JOptionPane.showConfirmDialog(null, "Deseja eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

                            int ro = buscarProduto.getTabela().getSelectedRow();
                            if (editar == 0) {
                                p = produtos.get(ro);

                                fachada1.ativarDesativarProduto(p.getId());
                                PreencherTabela();
                            }

                        
                        }
                    }
                    if (value instanceof JCheckBox) {
                        //((JCheckBox)value).doClick();
                        JCheckBox ch = (JCheckBox) value;
                        if (ch.isSelected() == true) {
                            ch.setSelected(false);
                        }
                        if (ch.isSelected() == false) {
                            ch.setSelected(true);
                        }
                    }
                }

            }
            
        });
        
        
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
        cadastroProduto.getListestoque().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cadastroProduto.getListestoque().getMinSelectionIndex();
                try {

                estoque = estoques.get(indice);
                } catch (Exception eu) {
                }
            }
        });
        cp.getListafornecedor().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cp.getListafornecedor().getMinSelectionIndex();
                try {

                    fornecedor = fornecedores.get(indice);
                    cp.getTxtcnpj().setText(fornecedor.getCnpj());
                    cp.getTxtFornecedor().setText(fornecedor.getNome_fantasia());
                } catch (Exception eu) {
                }
            }
        });
        cp.getListestoque().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cp.getListestoque().getMinSelectionIndex();
                try {

                estoque = estoques.get(indice);
                } catch (Exception eu) {
                }
            }
        });
        buscarProduto.getTxtPesquisarProduto().addKeyListener(new KeyAdapter() {

            @Override
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
            PreencherBuscaFornecedor(cadastroProduto);
            PreencherEstoque(cadastroProduto);
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
            PreencherBuscaFornecedor(cadastroProduto);

        }

        if (e.getSource() == cadastroProduto.getBotaoCancelarProduto()) {
buscarProduto.getTxtPesquisarProduto().setText("");
                                            PreencherTabela();
            buscarProduto.setVisible(true);
            cadastroProduto.setVisible(false);
        }
        
        if (e.getSource() == cadastroProduto.getBotaoSalvarProduto()) {

            Produto produto = new Produto();
            System.out.println(estoque.getId());
            produto.setEstoque(estoque);
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
            

            if (fornecedor != null) {
                fachada1.salvarProduto(produto);
                System.out.println("br.com.fundamento.controle.ControleProduto.actionPerformed()");
            }

        buscarProduto.getTxtPesquisarProduto().setText("");
                                            PreencherTabela();
            buscarProduto.setVisible(true);
            cadastroProduto.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }

    public void PreencherTabela() {
         produtos = fachada1.getPorBuscaProduto(buscarProduto.getTxtPesquisarProduto().getText());
       
        buscarProduto.getTabela().setDefaultRenderer(Object.class, new Render());
        btn1 = new JButton("modificar"); 
        btn1.setName("m");
        btn2 = new JButton("Eliminar");
        btn2.setName("e");
        
        try {
            String[] colunas = new String[]{"Nome", "Fabricante", "Quantidade Estoque", "Preco Compra","E", "M"};
            Object[][] dados = new Object[produtos.size()][6];
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                dados[i][0] = produto.getNome();
                dados[i][1] = produto.getFabricante();
                dados[i][2] = produto.getQuantidade_estoque();
                dados[i][3] = produto.getPreco_compra();
                dados[i][4] = btn1;
                dados[i][5] = btn2;
            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarProduto.getTabela().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

    public void PreencherBuscaFornecedor(CadastroProduto cp) {

        fornecedores = fachada1.getPorBuscaFornecedor(cadastroProduto.getTxtFornecedor().getText());

        DefaultListModel model = new DefaultListModel();
        for (Fornecedor f : fornecedores) {

            model.addElement(f.getNome_fantasia());
        }

        cp.getListafornecedor().setModel(model);

    }
        public void PreencherEstoque(CadastroProduto cp) {

        estoques = fachada1.getAllEstoque();

        DefaultListModel model = new DefaultListModel();
        for (Estoque f : estoques) {

            model.addElement(f.getDescricao());
           
        }

        cp.getListestoque().setModel(model);
    }
      public void preencherCadastro(Produto p, CadastroProduto cp) {



        cp.getTxtnomeproduto().setText(p.getNome());
        cp.getTxtquantidade().setText(p.getQuantidade_estoque() + "");
        cp.getTxtFabricante().setText(p.getFabricante());
        cp.getTxtvalorunitario().setText(p.getPreco_compra()+"");
        cp.getTxtFornecedor().setText(p.getFornecedor().getNome_fantasia());
        cp.getTxtcnpj().setText(p.getFornecedor().getCnpj());
        
     

    }

    public class Acaoupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cp.getBotaoSalvarProduto()) {

                Produto produto = p;
                p=null;
                produto.setFabricante(cp.getTxtFabricante().getText());
                produto.setNome(cp.getTxtnomeproduto().getText());
               
                String precos = cp.getTxtvalorunitario().getText();
                String quantidade = cp.getTxtquantidade().getText();
                try {
                    Double s = Double.parseDouble(precos);
                    int t = Integer.parseInt(quantidade);
                   produto.setPreco_compra(s);
                   produto.setQuantidade_estoque(t);
                } catch (Exception fre) {
                }
               produto.getFornecedor().setCnpj(cp.getTxtcnpj().getText());
               produto.getFornecedor().setNome_fantasia(cp.getTxtFornecedor().getText());
               
               produto.setEstoque(estoque);
               produto.setFornecedor(fornecedor);
               
                    fachada1.editarProduto(produto);
                    buscarProduto.getTxtPesquisarProduto().setText("");
                    PreencherTabela();
                    buscarProduto.setVisible(true);
                    cp.setVisible(false);
                    telaPrincipal.setEnabled(true);
                    cp = null;
                    p = null;
                    produto = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha diferentes");
                }

            }
        }
    }


