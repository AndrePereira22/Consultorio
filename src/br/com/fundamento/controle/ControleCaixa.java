/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoPagamento;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.BuscarContaApagar;
import br.com.fundamento.view.BuscarContaaReceber;
import br.com.fundamento.view.ContaReceber;
import br.com.fundamento.view.ContaaPagar;
import br.com.fundamento.view.FluxodeCaixa;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleCaixa implements  ActionListener{
    
    private TelaPrincipal telaPrincipal;
    private FluxodeCaixa fluxodeCaixa;
    private BuscarContaApagar buscarContaApagar;
    private BuscarContaaReceber buscarContaaReceber;
    private ContaReceber contaReceber;
    private ContaaPagar contaaPagar;
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
        buscarContaaReceber.getBotaoadicionar().addActionListener(this);
        buscarContaaReceber.getBotaofechar().addActionListener(this);
        contaReceber.getBotaocancelar().addActionListener(this);
        contaReceber.getBotaosalvar().addActionListener(this);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource() == telaPrincipal.getBotaofluxodeCaixa()){
          fluxodeCaixa.setVisible(true);
     }
     if(e.getSource() == fluxodeCaixa.getBotaoVoltar()){
        fluxodeCaixa.setVisible(false); 
     }
      if(e.getSource() == telaPrincipal.getBotaocontareceber()){
         buscarContaaReceber.setVisible(true);
         preenchertabela();
     }
     if(e.getSource() == buscarContaaReceber.getBotaoadicionar()){
         contaReceber.setVisible(true);
          buscarContaaReceber.setVisible(false);
          preenchertabela();
     }
     if(e.getSource() == buscarContaaReceber.getBotaofechar()){
            buscarContaaReceber.setVisible(false);
     }
     if(e.getSource() == contaReceber.getBotaocancelar()){
           buscarContaaReceber.setVisible(true);
             contaReceber.setVisible(false);
     }
     
     if(e.getSource() == contaReceber.getBotaosalvar()){
        buscarContaaReceber.setVisible(true);
        contaReceber.setVisible(false);
     }
     
     if(e.getSource() == telaPrincipal.getBotaocontapagar()){
         buscarContaApagar.setVisible(true);
     } 
     if(e.getSource() == buscarContaApagar.getBotaoadicionar()){
         contaaPagar.setVisible(true);
          buscarContaApagar.setVisible(false);
     }
     if(e.getSource() == buscarContaApagar.getBotaofechar()){
         buscarContaApagar.setVisible(false);
     }
     if(e.getSource() == contaaPagar.getBotaocancelar()){
         buscarContaApagar.setVisible(true);
         contaaPagar.setVisible(false);
     }
    
     if(e.getSource() == contaaPagar.getBotaosalvar()){
        buscarContaApagar.setVisible(true);
        contaaPagar.setVisible(false);
     }
     
    }
     public void preenchertabela() {


        List<Pagamento> pagamentos =  new DaoPagamento().buscarpagamento();
        buscarContaaReceber.getTabelacontaReceber().setDefaultRenderer(Object.class, new Render());
        Icon editar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pencil.png"));
        Icon excluir = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/cross.png"));

        JButton btn1 = new JButton(editar);
        btn1.setName("m");
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
            TableColumnModel columnModel =  buscarContaaReceber.getTabelacontaReceber().getColumnModel();
             buscarContaaReceber.getTabelacontaReceber().setModel(dataModel);
           buscarContaaReceber.getTabelacontaReceber().setPreferredScrollableViewportSize( buscarContaaReceber.getTabelacontaReceber().getPreferredSize());

        } catch (Exception ex) {

        }
    }

  
}
