/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.CommumDao;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Medico;
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
            try {

                Consultorio c = fachada1.bucarConsultorio();
                Endereco endConsultorio = CommumDao.bucarEndereco("consultorio", "nome_fantasia", c.getNome_fantasia());
                Contato t = CommumDao.bucarContato("consultorio", "nome_fantasia", c.getNome_fantasia());

                consultorio.getTxtnomefantasia().setText(c.getNome_fantasia());
                consultorio.getTxtcnpj().setText(c.getCnpj());
                consultorio.getTxtrazao().setText(c.getRazao_social());

                consultorio.getTxtrua().setText(endConsultorio.getRua());
                consultorio.getTxtbairro().setText(endConsultorio.getBairro());
                consultorio.getTxtcep().setText(endConsultorio.getCep());
                consultorio.getTxtnumero().setText(endConsultorio.getNumero());
                consultorio.getTxtcidade().setText(endConsultorio.getMunicipio());

                for (int u = 0; u < consultorio.getTxtUf().getItemCount(); u++) {

                    if (consultorio.getTxtUf().getItemAt(u).equals(endConsultorio.getEstado())) {
                        consultorio.getTxtUf().setSelectedItem(consultorio.getTxtUf().getItemAt(u));
                    }
                }

                consultorio.getTxtemail().setText(t.getEmail());
                consultorio.getTxtcelular().setText(t.getCelular());
                consultorio.getTxttelefone().setText(t.getTelefone());
            } catch (Exception p) {
            }
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

            Consultorio consultori = new Consultorio();
            consultori.setEndereco(end);
            consultori.setContato(con);
            consultori.setCnpj(consultorio.getTxtcnpj().getText());
            consultori.setNome_fantasia(consultorio.getTxtnomefantasia().getText());
            consultori.setRazao_social(consultorio.getTxtrazao().getText());
            consultori.setMedicos(new ArrayList<Medico>());

            fachada1.salvarConsultorio(consultori);
            telaPrincipal.setEnabled(true);
            consultorio.setVisible(false);
        }

    }

}
