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
import br.com.fundamento.modelos.Fornecedor;
import br.com.fundamento.modelos.Produto;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.BuscarFornecedor;
import br.com.fundamento.view.CadastroFornecedor;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleFornecedor implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroFornecedor cadastroFornecedor;
    private BuscarFornecedor buscarFornecedor;
    private JButton btn1, btn2;
    IFachada fachada1 = Fachada.getInstance();

    public ControleFornecedor(TelaPrincipal telaPrincipal, CadastroFornecedor cadastroFornecedor, BuscarFornecedor buscarFornecedor) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroFornecedor = cadastroFornecedor;
        this.buscarFornecedor = buscarFornecedor;

        telaPrincipal.getBotaoCadastroFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoCancelarrFornecedor().addActionListener(this);
        cadastroFornecedor.getBotaoSalvarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoAdicionarFornecedor().addActionListener(this);
        buscarFornecedor.getBotaoFecharFornecedor().addActionListener(this);
        buscarFornecedor.getTabelaCoFornecedor().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column =  buscarFornecedor.getTabelaCoFornecedor().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() /  buscarFornecedor.getTabelaCoFornecedor().getRowHeight();

                if (row <  buscarFornecedor.getTabelaCoFornecedor().getRowCount() && row >= 0 && column <  buscarFornecedor.getTabelaCoFornecedor().getColumnCount() && column >= 0) {
                    Object value =  buscarFornecedor.getTabelaCoFornecedor().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

                        }
                        if (boton.getName().equals("e")) {
                            JOptionPane.showConfirmDialog(null, "Deseja eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

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
        buscarFornecedor.getTxtPesquisarFornecedor().addKeyListener(new KeyAdapter() {

            @Override
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

         buscarFornecedor.getTabelaCoFornecedor().setDefaultRenderer(Object.class, new Render());
        btn1 = new JButton("modificar");
        
        btn1.setName("m");
        btn2 = new JButton("Eliminar");
        btn2.setName("e");
        try {
            String[] colunas = new String[]{"Nome Fantasia", "Razao Social", "cnpj","E", "M"};
            Object[][] dados = new Object[fornecedores.size()][5];
            for (int i = 0; i < fornecedores.size(); i++) {
                Fornecedor fornecedor = fornecedores.get(i);
                dados[i][0] = fornecedor.getNome_fantasia();
                dados[i][1] = fornecedor.getRazao_social();
                dados[i][2] = fornecedor.getCnpj();
                 dados[i][3] = btn1;
                dados[i][4] = btn2;

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            buscarFornecedor.getTabelaCoFornecedor().setModel(dataModel);
        } catch (Exception ex) {

        }
    }
}
