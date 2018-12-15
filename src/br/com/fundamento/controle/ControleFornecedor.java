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
import br.com.fundamento.sql.SQLUtil;
import br.com.fundamento.view.BuscarFornecedor;
import br.com.fundamento.view.CadastroFornecedor;
import br.com.fundamento.view.CadastroFuncionario;
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
    private CadastroFornecedor cadastroFornecedor, cf;
    private BuscarFornecedor buscarFornecedor;
    private JButton btn1, btn2;
    private Fornecedor f;
    private List<Fornecedor> fornecedores;
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
                int column = buscarFornecedor.getTabelaCoFornecedor().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarFornecedor.getTabelaCoFornecedor().getRowHeight();

                if (row < buscarFornecedor.getTabelaCoFornecedor().getRowCount() && row >= 0 && column < buscarFornecedor.getTabelaCoFornecedor().getColumnCount() && column >= 0) {
                    Object value = buscarFornecedor.getTabelaCoFornecedor().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarFornecedor.getTabelaCoFornecedor().getSelectedRow();
                            if (editar == 0) {
                                cf = new CadastroFornecedor();
                                cf.getLabelFornecedor().setText("ATUALIZAR FORNECEDOR");
                                cf.setVisible(true);
                                buscarFornecedor.setVisible(false);

                                f = fornecedores.get(ro);
                                preencherCadastro(f, cf);
                                try {
                                    cf.getBotaoSalvarFornecedor().addActionListener(new Acaoupdate());
                                    cf.getBotaoCancelarrFornecedor().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            cf.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            buscarFornecedor.setVisible(true);
                                            buscarFornecedor.getTxtPesquisarFornecedor().setText("");
                                            preenchertabela();
                                            cf = null;
                                            f = null;

                                        }
                                    });

                                } catch (Exception ui) {
                                }
                            }
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
            buscarFornecedor.getTxtPesquisarFornecedor().setText("");
            preenchertabela();
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
            buscarFornecedor.getTxtPesquisarFornecedor().setText("");
            preenchertabela();
            buscarFornecedor.setVisible(true);
            cadastroFornecedor.setVisible(false);
            telaPrincipal.setEnabled(true);
        }
        
    }
    
    public void preenchertabela() {
        
        fornecedores = fachada1.getPorBuscaFornecedor(buscarFornecedor.getTxtPesquisarFornecedor().getText());
        
        buscarFornecedor.getTabelaCoFornecedor().setDefaultRenderer(Object.class, new Render());
        btn1 = new JButton("modificar");
        
        btn1.setName("m");
        btn2 = new JButton("Eliminar");
        btn2.setName("e");
        try {
            String[] colunas = new String[]{"Nome Fantasia", "Razao Social", "cnpj", "E", "M"};
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
    
    public void preencherCadastro(Fornecedor f, CadastroFornecedor cf) {
        
        cf.getTxtcep().setText(f.getEndereco().getCep());
        cf.getTxtbairro().setText(f.getEndereco().getBairro());
        cf.getTxtnumero().setText(f.getEndereco().getNumero());
        cf.getTxtcidade().setText(f.getEndereco().getMunicipio());
        cf.getTxtrua().setText(f.getEndereco().getRua());
        for (int u = 0; u < cf.getTxtUf().getItemCount(); u++) {
            
            if (cf.getTxtUf().getItemAt(u).equals(f.getEndereco().getEstado())) {
                cf.getTxtUf().setSelectedItem(cf.getTxtUf().getItemAt(u));
            }
        }
        cf.getTxtcelular().setText(f.getContato().getCelular());
        cf.getTxttelefone().setText(f.getContato().getTelefone());
        cf.getTxtemail().setText(f.getContato().getEmail());
        cf.getTxtrazao().setText(f.getRazao_social());
        cf.getTxtrazao1().setText(f.getNome_fantasia());
        cf.getTxtcnpj().setText(f.getCnpj());
    }
    
    public class Acaoupdate implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == cf.getBotaoSalvarFornecedor()) {
                
                Fornecedor fornecedor = f;
                f = null;
                fornecedor.getEndereco().setBairro(cf.getTxtbairro().getText());
                fornecedor.getEndereco().setRua(cf.getTxtrua().getText());
                fornecedor.getEndereco().setCep(cf.getTxtcep().getText());
                fornecedor.getEndereco().setNumero(cf.getTxtnumero().getText());
                fornecedor.getEndereco().setMunicipio(cf.getTxtcidade().getText());
                fornecedor.getEndereco().setEstado(cf.getTxtUf().getSelectedItem().toString());
                fornecedor.getContato().setEmail(cf.getTxtemail().getText());
                fornecedor.getContato().setCelular(cf.getTxtcelular().getText());
                fornecedor.getContato().setTelefone(cf.getTxttelefone().getText());

                
                fornecedor.setCnpj(cf.getTxtcnpj().getText());
                fornecedor.setRazao_social(cf.getTxtrazao().getText());
                fornecedor.setNome_fantasia(cf.getTxtrazao1().getText());
              
                    
                    fachada1.editarfornecedor(fornecedor);
                    buscarFornecedor.getTxtPesquisarFornecedor().setText("");
                    preenchertabela();
                    buscarFornecedor.setVisible(true);
                    cf.setVisible(false);
                    telaPrincipal.setEnabled(true);
                    cf = null;
                    f = null;
                    fornecedor= null;
                
                
            }
        }
    }
}
