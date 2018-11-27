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
import br.com.fundamento.view.AtualizarConsultorio;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleConsultorio implements ActionListener {

    private TelaPrincipal telaPrincipal;
    AtualizarConsultorio consultorio;
    IFachada fachada1 = Fachada.getInstance();

    public ControleConsultorio(TelaPrincipal telaPrincipal, AtualizarConsultorio consultorio) {
        this.telaPrincipal = telaPrincipal;
        this.consultorio = consultorio;

        telaPrincipal.getBotaoAtualizardados().addActionListener(this);
        consultorio.getBotaoCancelarrConsultorio().addActionListener(this);
        consultorio.getBotaoSalvarConsultorio().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAtualizardados()) {
            telaPrincipal.setEnabled(false);
            consultorio.setVisible(true);
        }

        if (e.getSource() == consultorio.getBotaoCancelarrConsultorio()) {
            telaPrincipal.setEnabled(true);
            consultorio.setVisible(false);

        }
        if (e.getSource() == consultorio.getBotaoSalvarConsultorio()) {

            Endereco end = new Endereco();
            end.setBairro(consultorio.getTxtbairro().getText());
            end.setRua(consultorio.getTxtrua().getText());
            end.setCep(consultorio.getTxtcep().getText());
            end.setNumero(consultorio.getTxtnumero().getText());
            end.setEstado(consultorio.getTxtUf().getSelectedItem().toString());
            end.setMunicipio(consultorio.getTxtcidade().getText());

            Contato con = new Contato();
            con.setEmail(consultorio.getTxtemail().getText());
            con.setCelular(consultorio.getTxtcelular().getText());
            con.setTelefone(consultorio.getTxttelefone().getText());

            telaPrincipal.setEnabled(true);
            consultorio.setVisible(false);
        }

    }

}
