/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.view.BuscarCaixa;
import br.com.fundamento.view.CadastroCaixa;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleCaixa implements ActionListener {

    private TelaPrincipal telaPrincipal;
    CadastroCaixa caixa;
    BuscarCaixa buscarCaixa;
    IFachada fachada1 = Fachada.getInstance();

    public ControleCaixa(TelaPrincipal telaPrincipal, CadastroCaixa caixa, BuscarCaixa buscarCaixa) {
        this.telaPrincipal = telaPrincipal;
        this.caixa = caixa;
        this.buscarCaixa = buscarCaixa;

        telaPrincipal.getBotaoCadastroCaixa().addActionListener(this);
        caixa.getBotaoCancelarCaixa().addActionListener(this);
        caixa.getBotaoSalvarCaixa().addActionListener(this);
        buscarCaixa.getBotaoAdicionarCaixa().addActionListener(this);
        buscarCaixa.getBotaoEditarCaixa().addActionListener(this);
        buscarCaixa.getBotaoExcluirCaixa().addActionListener(this);
        buscarCaixa.getBotaoFecharCaixa().addActionListener(this);
        buscarCaixa.getBotaoPesquisarCaixa().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoCadastroCaixa()) {
            
            
            telaPrincipal.setEnabled(false);
            buscarCaixa.setVisible(true);
        }
        if (e.getSource() == buscarCaixa.getBotaoFecharCaixa()) {
            telaPrincipal.setEnabled(true);
            buscarCaixa.setVisible(false);
        }
        if (e.getSource() == buscarCaixa.getBotaoAdicionarCaixa()) {

            caixa.setVisible(true);
            buscarCaixa.setVisible(false);
        }
        if (e.getSource() == caixa.getBotaoCancelarCaixa()) {
            telaPrincipal.setEnabled(false);
            buscarCaixa.setVisible(true);
            caixa.setVisible(false);
        }
        if (e.getSource() == caixa.getBotaoSalvarCaixa()) {

            buscarCaixa.setVisible(true);
            caixa.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }

}
