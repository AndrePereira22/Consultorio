/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoCaixa;
import br.com.fundamento.dao.DaoConsulta;
import br.com.fundamento.dao.DaoContaPagar;
import br.com.fundamento.dao.DaoPagamento;
import br.com.fundamento.dao.DaoParcela;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
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
import br.com.fundamento.view.relatori;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private static Caixa c;
    private relatori u;
    double soma = 0.0;
    IFachada fachada1 = Fachada.getInstance();

    public ControleCaixa(TelaPrincipal telaPrincipal, FluxodeCaixa fluxodeCaixa, BuscarContaApagar buscarContaApagar, BuscarContaaReceber buscarContaaReceber, ContaReceber contaReceber, ContaaPagar contaaPagar, relatori u) {
        this.telaPrincipal = telaPrincipal;
        this.fluxodeCaixa = fluxodeCaixa;
        this.buscarContaApagar = buscarContaApagar;
        this.buscarContaaReceber = buscarContaaReceber;
        this.contaReceber = contaReceber;
        this.contaaPagar = contaaPagar;
        this.u = u;

        telaPrincipal.getBotaofluxodeCaixa().addActionListener(this);
        fluxodeCaixa.getBotaoVoltar().addActionListener(this);
        u.getSalvar().addActionListener(this);
        u.getCancelar().addActionListener(this);
        fluxodeCaixa.getBotaoFecharCaixa().addActionListener(this);
        fluxodeCaixa.getBotaorelatorio().addActionListener(this);
        telaPrincipal.getBotaocontapagar().addActionListener(this);
        buscarContaApagar.getBotaoadicionar().addActionListener(this);
        buscarContaApagar.getBotaofechar().addActionListener(this);
        contaaPagar.getBotaocancelar().addActionListener(this);
        contaaPagar.getBotaosalvar().addActionListener(this);
        telaPrincipal.getBotaocontareceber().addActionListener(this);
        buscarContaaReceber.getBotaofechar().addActionListener(this);
        contaReceber.getBotaocancelar().addActionListener(this);

        fluxodeCaixa.getCalendariofluxo().getDateEditor().getUiComponent().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                java.util.Date d = fluxodeCaixa.getCalendariofluxo().getDate();
                if(d!=null){
                String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                preencherfluxo(data);
                preenchertabelaDespesas(data);
                preencherfluxoParcelas(data);
                }

            }
        });

        buscarContaaReceber.getCalendarioReceber().getDateEditor().getUiComponent().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                preenchertabelaReceber();
                calcularValorReceber();

            }
        });

        buscarContaApagar.getCalendarioC().getDateEditor().getUiComponent().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                java.util.Date d = buscarContaApagar.getCalendarioC().getDate();
                String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                preenchertabelaPagar(data);
                despesas();

            }
        });

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
                                if (pagamento.isStatus() == false) {
                                    preenchertabelaPacela(pagamento);
                                    contaReceber.setVisible(true);
                                    buscarContaaReceber.setVisible(false);
                                    calcularValorReceber();
                                    preenchertabelaReceber();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Pagamento ja foi concluido");
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
                                pagarConta();
                                java.util.Date d = new Date();
                                String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                                preenchertabelaPagar(data);
                                despesas();

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

                                java.util.Date d = new Date();
                                String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                                parcela.setData_pagamento(dStr);
                                fachada1.editarParcela(parcela);
                                preenchertabelaPacela(pagamento);
                                adicionarParcelaCaixa();

                                if (concluirPagamento()) {

                                    JOptionPane.showMessageDialog(null, "Pagamento Finalizado");
                                    pagamento.setStatus(true);
                                    pagamento.setParcelas(new ArrayList<Parcela>());
                                    fachada1.editarPagamento(pagamento);
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
            java.util.Date d = new Date();
            String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            preencherfluxo(data);
            preenchertabelaDespesas(data);
            preencherfluxoParcelas(data);
            fluxodeCaixa.setVisible(true);
            fluxodeCaixa.getTxttotal().setEditable(false);

            ControleConsulta.abrirCaixa();
            dinhiroNoCaixa();
            fluxodeCaixa.getTxtlucro().setText(getC().getValor_fechamento() - getC().getValor_abertura() + "");
        }
        if (e.getSource() == fluxodeCaixa.getBotaoVoltar()) {
            fluxodeCaixa.setVisible(false);
        }
        if (e.getSource() == fluxodeCaixa.getBotaorelatorio()) {

            u.setVisible(true);

        }
        if (e.getSource() == u.getSalvar()) {

            java.util.Date inicial = u.getCalendarioInicial().getDate();
            java.util.Date finality = u.getCalendarioFinal().getDate();
            GerarRelatorioFinanceiro pdf = new GerarRelatorioFinanceiro();
            if (inicial != null && finality != null && !u.getTxtrelatorio().getText().isEmpty() ) {

                String dataI = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(inicial);
                String dataF = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(finality);

                pdf.criar(u.getTxtrelatorio().getText(), dataI, dataF);
                u.setVisible(false);
                JOptionPane.showMessageDialog(null, "Relatorio  Salvo!");
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            }
        }
        if (e.getSource() == telaPrincipal.getBotaocontareceber()) {
           calcularValorReceber();
           preenchertabelaReceber();
           buscarContaaReceber.setVisible(true);
            
           

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
            buscarContaApagar.getTxtvalor().setEditable(false);
            buscarContaApagar.setVisible(true);
            java.util.Date d = new Date();
            String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            preenchertabelaPagar(data);
            despesas();
        }
        if (e.getSource() == buscarContaApagar.getBotaoadicionar()) {
            contaaPagar.setVisible(true);
            buscarContaApagar.setVisible(false);
        }
        if (e.getSource() == buscarContaApagar.getBotaofechar()) {
            buscarContaApagar.setVisible(false);
        }
        if (e.getSource() == fluxodeCaixa.getBotaoFecharCaixa()) {
            fecharCaixa();
            fluxodeCaixa.setVisible(false);
        }
        if (e.getSource() == u.getCancelar()) {
            u.setVisible(false);
        }
        if (e.getSource() == contaaPagar.getBotaocancelar()) {
            buscarContaApagar.setVisible(true);
            contaaPagar.setVisible(false);

        }

        if (e.getSource() == contaaPagar.getBotaosalvar()) {
            ContaPagar contaPagar = new ContaPagar();
            Consultorio consultorio = fachada1.buscarConsultorioPorId(1);

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
            contaPagar.setConsultorio(consultorio);
            contaPagar.setData_pagamento("00/00/0000");

            fachada1.salvarContaPagar(contaPagar);
            buscarContaApagar.setVisible(true);
            contaaPagar.setVisible(false);
            buscarContaApagar.setVisible(true);
            contaaPagar.setVisible(false);
            java.util.Date d = new Date();
            String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
            preenchertabelaPagar(data);
            despesas();
        }

    }

    public void preenchertabelaReceber() {
        java.util.Date dj = buscarContaaReceber.getCalendarioReceber().getDate(); 
       String dStr="";
        if(dj==null){
          java.util.Date dd = new Date();  
           dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dd); 
        }else{
          dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dj);  
        }
       

        pagamentos = new DaoPagamento().buscarpagamento(dStr);
        buscarContaaReceber.getTabelacontaReceber().setDefaultRenderer(Object.class, new Render());
        Icon pagar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pagarR.png"));

        JButton btn1 = new JButton(pagar);
        btn1.setName("p");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);
        Consulta ccc;

        try {
            String[] colunas = new String[]{"Paciente", "Valor Total", "Forma Pagamento", "Quantidade Parcelas", "Status", "Pagar"};
            Object[][] dados = new Object[pagamentos.size()][6];
            for (int i = 0; i < pagamentos.size(); i++) {
                String s = "Pendente";
                Pagamento pagamento = pagamentos.get(i);
                ccc = new DaoConsulta().buscarConsultaPorPagamento(pagamento.getId());

                if (pagamento.isStatus()) {
                    s = "Pago";
                }

                dados[i][0] = ccc.getPaciente().getNome();
                dados[i][1] = pagamento.getValor_total();
                dados[i][2] = pagamento.getForma_pagamento();
                dados[i][3] = pagamento.getQuantidade_parcelas();
                dados[i][4] = s;
                dados[i][5] = btn1;

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

    public void preenchertabelaPagar(String data) {

        contaaPagars = new DaoContaPagar().BuscarContaVencimento(data);
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
            Object[][] dados = new Object[parcelas.size()][5];
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
       parcelas = fachada1.getAllParcela();
       buscarContaaReceber.getTxtvalor().setText("");
        double soma = 0;
        for (Parcela p : parcelas) {
            if (!p.isStatus()) {
                soma += p.getValor();
            }
        }
        DecimalFormat df = new DecimalFormat("0.##");
        String dx = df.format(soma);
        buscarContaaReceber.getTxtvalor().setText(dx);
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

    public void dinhiroNoCaixa() {

        java.util.Date d = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        c = new DaoCaixa().buscarCaixaPorData(dStr);

        double valor = getC().getValor_fechamento();
        fluxodeCaixa.getTxttotal().setText(valor + "");
    }

    public void fecharCaixa() {

        double lucro = getC().getValor_fechamento() - getC().getValor_abertura();
        getC().setValor_receita(lucro);
        getC().setStatus(false);

        new DaoCaixa().fecharCaixa(getC());

    }

    public void despesas() {
        for (ContaPagar p : contaaPagars) {
            soma += p.getValor();
        }

        buscarContaApagar.getTxtvalor().setText(soma + "");
        soma = 0;
    }

    public void adicionarParcelaCaixa() {

        java.util.Date d = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        c = new DaoCaixa().buscarCaixaPorData(dStr);

        double soma = getC().getValor_fechamento() + parcela.getValor();
        getC().setValor_fechamento(soma);

        fachada1.editarCaixa(getC());

    }

    public void pagarConta() {

        java.util.Date dj = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dj);
        c = new DaoCaixa().buscarCaixaPorData(dStr);

        if (getC().getValor_fechamento() > contaPagar.getValor()) {
            double soma = getC().getValor_fechamento() - contaPagar.getValor();
            getC().setValor_fechamento(soma);
            contaPagar.setData_pagamento(dStr);
            fachada1.editarContaPagar(contaPagar);
            fachada1.ativarDesativarContaPagar(contaPagar.getId());
            fachada1.editarCaixa(getC());
        } else {
            JOptionPane.showMessageDialog(null, "Dinheiro indisponivel");
        }

    }

    public void preenchertabelaReceberTodos() {
        pagamentos = fachada1.getAllPagamento();
        buscarContaaReceber.getTabelacontaReceber().setDefaultRenderer(Object.class, new Render());
        Icon pagar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pagarR.png"));

        JButton btn1 = new JButton(pagar);
        btn1.setName("p");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Valor Total", "Forma Pagamento", "Quantidade Parcelas", "Status", "Pagar"};
            Object[][] dados = new Object[pagamentos.size()][5];
            for (int i = 0; i < pagamentos.size(); i++) {
                String s = "Pendente";
                Pagamento pagamento = pagamentos.get(i);
                if (pagamento.isStatus()) {
                    s = "Pago";
                }
                dados[i][0] = pagamento.getValor_total();
                dados[i][1] = pagamento.getForma_pagamento();
                dados[i][2] = pagamento.getQuantidade_parcelas();
                dados[i][3] = s;
                dados[i][4] = btn1;

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

    public void preencherfluxo(String data) {

        pagamentos = new DaoPagamento().buscarpagamento(data);
        fluxodeCaixa.getTabelapagamento().setDefaultRenderer(Object.class, new Render());

        Consulta ccc;

        try {
            String[] colunas = new String[]{"Paciente", "Valor Total", "Forma Pagamento", "Quantidade Parcelas"};
            Object[][] dados = new Object[pagamentos.size()][4];
            for (int i = 0; i < pagamentos.size(); i++) {

                Pagamento pagamento = pagamentos.get(i);
                ccc = new DaoConsulta().buscarConsultaPorPagamento(pagamento.getId());

                if (pagamento.isStatus()) {
                    dados[i][0] = ccc.getPaciente().getNome();
                    dados[i][1] = pagamento.getValor_total();
                    dados[i][2] = pagamento.getForma_pagamento();
                    dados[i][3] = pagamento.getQuantidade_parcelas();

                }

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = fluxodeCaixa.getTabelapagamento().getColumnModel();
            fluxodeCaixa.getTabelapagamento().setModel(dataModel);
            fluxodeCaixa.getTabelapagamento().setPreferredScrollableViewportSize(fluxodeCaixa.getTabelapagamento().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    public void preenchertabelaDespesas(String data) {
        contaaPagars = new DaoContaPagar().BuscarContaPagar(data);
        fluxodeCaixa.getTabeladespesas().setDefaultRenderer(Object.class, new Render());

        try {
            String[] colunas = new String[]{"Data Vencimento", "Descrição", "Valor"};
            Object[][] dados = new Object[contaaPagars.size()][3];
            for (int i = 0; i < contaaPagars.size(); i++) {
                ContaPagar contaPagar = contaaPagars.get(i);
                dados[i][0] = contaPagar.getData();
                dados[i][1] = contaPagar.getDescricao();
                dados[i][2] = contaPagar.getValor();
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            TableColumnModel columnModel = fluxodeCaixa.getTabeladespesas().getColumnModel();
            fluxodeCaixa.getTabeladespesas().setModel(dataModel);
            fluxodeCaixa.getTabeladespesas().setPreferredScrollableViewportSize(fluxodeCaixa.getTabeladespesas().getPreferredSize());

        } catch (Exception ex) {

        }

    }

    public void preencherfluxoParcelas(String data) {
        pagamentos = new DaoPagamento().buscarpagamentoNaopago(data);
        fluxodeCaixa.getTabelaparcela().setDefaultRenderer(Object.class, new Render());

        Consulta ccc;
        List<Parcela> list;
        int x = 0;
        Object[][] dados = new Object[100][6];
        try {
            String[] colunas = new String[]{"Paciente", "Valor Total", "Forma Pagamento", "Quantidade Parcelas", "Numero Parcela", "Valor"};

            for (Pagamento p : pagamentos) {
                list = new DaoParcela().buscarParcelaPaga(p.getId(), data);
                ccc = new DaoConsulta().buscarConsultaPorPagamento(p.getId());

                for (int u = 0; u < list.size(); u++) {

                    Parcela par = list.get(u);

                    dados[x][0] = ccc.getPaciente().getNome();
                    dados[x][1] = p.getValor_total();
                    dados[x][2] = p.getForma_pagamento();
                    dados[x][3] = p.getQuantidade_parcelas();
                    dados[x][4] = par.getNumero();
                    dados[x][5] = par.getValor();
                    x++;
                }

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = fluxodeCaixa.getTabelaparcela().getColumnModel();
            fluxodeCaixa.getTabelaparcela().setModel(dataModel);
            fluxodeCaixa.getTabelaparcela().setPreferredScrollableViewportSize(fluxodeCaixa.getTabelaparcela().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    /**
     * @return the c
     */
    public static Caixa getC() {
        return c;
    }

}
