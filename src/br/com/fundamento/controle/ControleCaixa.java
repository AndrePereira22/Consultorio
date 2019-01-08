/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoPagamento;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.ContaPagar;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.BuscarContaApagar;
import br.com.fundamento.view.BuscarContaaReceber;
import br.com.fundamento.view.ContaReceber;
import br.com.fundamento.view.ContaaPagar;
import br.com.fundamento.view.FluxodeCaixa;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleCaixa implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private FluxodeCaixa fluxodeCaixa;
    private BuscarContaApagar buscarContaApagar;
    private BuscarContaaReceber buscarContaaReceber;
    private ContaReceber contaReceber;
    private ContaaPagar contaaPagar;
    private ContaPagar contaPagar;
    private List<ContaPagar> contaaPagars;
    private List<Parcela> parcelas;
    private List<Pagamento> pagamentos;
    private Pagamento pagamento;
    private Parcela parcela;
    double soma = 0.0;
    IFachada fachada1 = Fachada.getInstance();

    public ControleCaixa(TelaPrincipal telaPrincipal, FluxodeCaixa fluxodeCaixa, BuscarContaApagar buscarContaApagar, BuscarContaaReceber buscarContaaReceber, ContaReceber contaReceber, ContaaPagar contaaPagar) {
        this.telaPrincipal = telaPrincipal;
        this.fluxodeCaixa = fluxodeCaixa;
        this.buscarContaApagar = buscarContaApagar;
        this.buscarContaaReceber = buscarContaaReceber;
        this.contaReceber = contaReceber;
        this.contaaPagar = contaaPagar;

        telaPrincipal.getBotaofluxodeCaixa().addActionListener(this);
        fluxodeCaixa.getBotaoVoltar().addActionListener(this);
        telaPrincipal.getBotaocontapagar().addActionListener(this);
        buscarContaApagar.getBotaoadicionar().addActionListener(this);
        buscarContaApagar.getBotaofechar().addActionListener(this);
        contaaPagar.getBotaocancelar().addActionListener(this);
        contaaPagar.getBotaosalvar().addActionListener(this);
        telaPrincipal.getBotaocontareceber().addActionListener(this);
        buscarContaaReceber.getBotaofechar().addActionListener(this);
        contaReceber.getBotaocancelar().addActionListener(this);
        buscarContaaReceber.getTabelacontaReceber().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = buscarContaaReceber.getTabelacontaReceber().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarContaaReceber.getTabelacontaReceber().getRowHeight();

                if (row < buscarContaaReceber.getTabelacontaReceber().getRowCount() && row >= 0 && column < buscarContaaReceber.getTabelacontaReceber().getColumnCount() && column >= 0) {
                    Object value = buscarContaaReceber.getTabelacontaReceber().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("p")) {
                            int pagar = JOptionPane.showConfirmDialog(null, "Deseja Realizar o Pagamento", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarContaaReceber.getTabelacontaReceber().getSelectedRow();

                            if (pagar == 0) {
                                pagamento = pagamentos.get(ro);
                                preenchertabelaPacela(pagamento);
                                contaReceber.setVisible(true);
                                buscarContaaReceber.setVisible(false);
                                calcularValorReceber();
                                preenchertabelaReceber();

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
        buscarContaApagar.getTabelacontapagar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = buscarContaApagar.getTabelacontapagar().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / buscarContaApagar.getTabelacontapagar().getRowHeight();

                if (row < buscarContaApagar.getTabelacontapagar().getRowCount() && row >= 0 && column < buscarContaApagar.getTabelacontapagar().getColumnCount() && column >= 0) {
                    Object value = buscarContaApagar.getTabelacontapagar().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("p")) {
                            int Pago = JOptionPane.showConfirmDialog(null, " Pagamento Realizado", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = buscarContaApagar.getTabelacontapagar().getSelectedRow();

                            if (Pago == 0) {
                                contaPagar = contaaPagars.get(ro);
                                fachada1.ativarDesativarContaPagar(contaPagar.getId());
                                preenchertabelaPagar();

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

        contaReceber.getTabelaContaReceber().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = contaReceber.getTabelaContaReceber().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / contaReceber.getTabelaContaReceber().getRowHeight();

                if (row < contaReceber.getTabelaContaReceber().getRowCount() && row >= 0 && column < contaReceber.getTabelaContaReceber().getColumnCount() && column >= 0) {
                    Object value = contaReceber.getTabelaContaReceber().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("p")) {
                            int pagar = JOptionPane.showConfirmDialog(null, "Comfirmar Pagamento", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = contaReceber.getTabelaContaReceber().getSelectedRow();

                            if (pagar == 0) {
                                parcela = parcelas.get(ro);
                                fachada1.editarParcela(parcela);
                                preenchertabelaPacela(pagamento);
                                if (concluirPagamento()) {
                                    JOptionPane.showConfirmDialog(null, "Pagamento Finalizado");
                                    fachada1.ativarDesativarPagamento(pagamento.getId());
                                    calcularValorReceber();
                                    preenchertabelaReceber();

                                }

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaofluxodeCaixa()) {
            fluxodeCaixa.setVisible(true);
        }
        if (e.getSource() == fluxodeCaixa.getBotaoVoltar()) {
            fluxodeCaixa.setVisible(false);
        }
        if (e.getSource() == telaPrincipal.getBotaocontareceber()) {
            buscarContaaReceber.setVisible(true);
            preenchertabelaReceber();
            calcularValorReceber();
        }

        if (e.getSource() == buscarContaaReceber.getBotaofechar()) {
            buscarContaaReceber.setVisible(false);
        }
        if (e.getSource() == contaReceber.getBotaocancelar()) {
            buscarContaaReceber.setVisible(true);
            contaReceber.setVisible(false);
            calcularValorReceber();
        }

        if (e.getSource() == telaPrincipal.getBotaocontapagar()) {
            buscarContaApagar.setVisible(true);
            buscarContaApagar.getTxtvalor().setEditable(false);
            buscarContaApagar.getTxtvalor().setText(soma + "");
            preenchertabelaPagar();
        }
        if (e.getSource() == buscarContaApagar.getBotaoadicionar()) {
            contaaPagar.setVisible(true);
            buscarContaApagar.setVisible(false);
        }
        if (e.getSource() == buscarContaApagar.getBotaofechar()) {
            buscarContaApagar.setVisible(false);
        }
        if (e.getSource() == contaaPagar.getBotaocancelar()) {
            buscarContaApagar.setVisible(true);
            contaaPagar.setVisible(false);
        }

        if (e.getSource() == contaaPagar.getBotaosalvar()) {
            ContaPagar contaPagar = new ContaPagar();

            String q = contaaPagar.getTxtvalor().getText();
            q = q.replaceAll("[^0-9]", "");
            double quantidade = 0;

            try {

                quantidade = Double.parseDouble(q);

            } catch (NumberFormatException erro) {
            }

            contaPagar.setValor(quantidade);
            contaPagar.setData(contaaPagar.getTxtvencimento().getText());
            contaPagar.setDescricao(contaaPagar.getTxtdescricao().getText());

            fachada1.salvarContaPagar(contaPagar);
            buscarContaApagar.setVisible(true);
            contaaPagar.setVisible(false);
            buscarContaApagar.setVisible(true);
            contaaPagar.setVisible(false);
            preenchertabelaPagar();
        }

    }

    public void preenchertabelaReceber() {

        pagamentos = new DaoPagamento().buscarpagamento();
        buscarContaaReceber.getTabelacontaReceber().setDefaultRenderer(Object.class, new Render());
        Icon pagar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pagarR.png"));

        JButton btn1 = new JButton(pagar);
        btn1.setName("p");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Valor Total", "Forma Pagamento", "Quantidade Parcelas", "Pagar"};
            Object[][] dados = new Object[pagamentos.size()][4];
            for (int i = 0; i < pagamentos.size(); i++) {
                Pagamento pagamento = pagamentos.get(i);
                dados[i][0] = pagamento.getValor_total();
                dados[i][1] = pagamento.getForma_pagamento();
                dados[i][2] = pagamento.getQuantidade_parcelas();
                dados[i][3] = btn1;

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = buscarContaaReceber.getTabelacontaReceber().getColumnModel();
            buscarContaaReceber.getTabelacontaReceber().setModel(dataModel);
            buscarContaaReceber.getTabelacontaReceber().setPreferredScrollableViewportSize(buscarContaaReceber.getTabelacontaReceber().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    public void preenchertabelaPagar() {

        contaaPagars = fachada1.getAllContaPagar();
        buscarContaApagar.getTabelacontapagar().setDefaultRenderer(Object.class, new Render());
        Icon pagar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pagar.png"));

        JButton btn1 = new JButton(pagar);
        btn1.setName("p");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Data Vencimento", "Descrição", "Valor", "Pago"};
            Object[][] dados = new Object[contaaPagars.size()][4];
            for (int i = 0; i < contaaPagars.size(); i++) {
                ContaPagar contaPagar = contaaPagars.get(i);
                dados[i][0] = contaPagar.getData();
                dados[i][1] = contaPagar.getDescricao();
                dados[i][2] = contaPagar.getValor();
                dados[i][3] = btn1;
               
                for(ContaPagar p: contaaPagars){
                    soma += p.getValor();
                }
              
                buscarContaApagar.getTxtvalor().setText(soma + "");
                soma=0;
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            TableColumnModel columnModel = buscarContaApagar.getTabelacontapagar().getColumnModel();
            buscarContaApagar.getTabelacontapagar().setModel(dataModel);
            buscarContaApagar.getTabelacontapagar().setPreferredScrollableViewportSize(buscarContaApagar.getTabelacontapagar().getPreferredSize());

        } catch (Exception ex) {

        }

    }

    public void preenchertabelaPacela(Pagamento pagamento) {
        System.out.println(pagamento.getId());
        parcelas = fachada1.buscarParcela(pagamento.getId());
        contaReceber.getTabelaContaReceber().setDefaultRenderer(Object.class, new Render());
        Icon pagar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pagarP.png"));

        JButton btn1 = new JButton(pagar);
        btn1.setName("p");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        String status = "";
        try {
            String[] colunas = new String[]{"Numero", "Data Vencimento", "Valor", "Status", "Pagar"};
            Object[][] dados = new Object[parcelas.size()][6];
            for (int i = 0; i < parcelas.size(); i++) {
                Parcela parcela = parcelas.get(i);
                if (parcela.isStatus()) {
                    status = "Pago";
                } else {
                    status = "Não Pago ";
                }
                dados[i][0] = parcela.getNumero();
                dados[i][1] = parcela.getData_vencimento();
                dados[i][2] = parcela.getValor();
                dados[i][3] = status;
                dados[i][4] = btn1;

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            TableColumnModel columnModel = contaReceber.getTabelaContaReceber().getColumnModel();
            contaReceber.getTabelaContaReceber().setModel(dataModel);
            contaReceber.getTabelaContaReceber().setPreferredScrollableViewportSize(contaReceber.getTabelaContaReceber().getPreferredSize());

        } catch (Exception ex) {

        }

    }

    public void calcularValorReceber() {
        List<Parcela> parcelas = fachada1.getAllParcela();
        double soma = 0;
        for (Parcela p : parcelas) {
            if (!p.isStatus()) {
                soma += p.getValor();
            }
        }
        buscarContaaReceber.getTxtvalor().setText(soma + "");
        buscarContaaReceber.getTxtvalor().setEditable(false);
    }

    public boolean concluirPagamento() {

        int numero = parcelas.size(), pagas = 0;

        for (Parcela p : parcelas) {
            if (p.isStatus()) {
                pagas += 1;
            }

        }
        if (numero == pagas) {
            return true;
        }

        return false;
    }

    
}
