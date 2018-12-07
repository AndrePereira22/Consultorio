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
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.view.AtualizarConsultorio;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControlePrincipal implements ActionListener {

    private TelaPrincipal telaPrincipal;
    AtualizarConsultorio consultorio;
       private TelaLogin telaLogin;
    IFachada fachada1 = Fachada.getInstance();

    public ControlePrincipal(TelaPrincipal telaPrincipal, AtualizarConsultorio consultorio,TelaLogin telaLogin) {
        this.telaPrincipal = telaPrincipal;
        this.consultorio = consultorio;
        this.telaLogin = telaLogin;
        telaPrincipal.getBotaoAtualizardados().addActionListener(this);
        consultorio.getBotaoCancelarrConsultorio().addActionListener(this);
        consultorio.getBotaoSalvarConsultorio().addActionListener(this);
         telaLogin.setVisible(true);
        telaLogin.getEntrar().addActionListener(this);
        telaPrincipal.getBotaoSair().addActionListener(this);
        telaLogin.getCancelarLogin().addActionListener(this);
        telaPrincipal.getBotaoLogoff().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAtualizardados()) {
            telaPrincipal.setEnabled(false);
            try {

                Consultorio c = fachada1.bucarConsultorio();
               
                consultorio.getTxtnomefantasia().setText(c.getNome_fantasia());
                consultorio.getTxtcnpj().setText(c.getCnpj());
                consultorio.getTxtrazao().setText(c.getRazao_social());

                consultorio.getTxtrua().setText(c.getEndereco().getRua());
                consultorio.getTxtbairro().setText(c.getEndereco().getBairro());
                consultorio.getTxtcep().setText(c.getEndereco().getCep());
                consultorio.getTxtnumero().setText(c.getEndereco().getNumero());
                consultorio.getTxtcidade().setText(c.getEndereco().getMunicipio());

                for (int u = 0; u < consultorio.getTxtUf().getItemCount(); u++) {

                    if (consultorio.getTxtUf().getItemAt(u).equals(c.getEndereco().getEstado())) {
                        consultorio.getTxtUf().setSelectedItem(consultorio.getTxtUf().getItemAt(u));
                    }
                }

                consultorio.getTxtemail().setText(c.getContato().getEmail());
                consultorio.getTxtcelular().setText(c.getContato().getCelular());
                consultorio.getTxttelefone().setText(c.getContato().getTelefone());
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
        if (e.getSource() == telaLogin.getEntrar()) {
            Login loginF=null,loginM=null ;
            
            String senha = new String(telaLogin.getTextsenha().getPassword());
            try {
                loginF = fachada1.buscarLogin(telaLogin.getTextlogin().getText());
                  loginM = fachada1.buscarLoginMedico("l.usuario",telaLogin.getTextlogin().getText());
                if (loginF.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginF.getSenha().equals(senha)) {
                    telaPrincipal.setVisible(true);
                    telaLogin.setVisible(false);
                }
            } catch (Exception a) {}
            
            try {
                if (loginM.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginM.getSenha().equals(senha)) {

                telaPrincipal.setVisible(true);
                telaLogin.setVisible(false);
            }
            } catch (Exception o) {}
            if(telaLogin.isVisible()) JOptionPane.showMessageDialog(null, "Usuario não existe");

        }
        if (e.getSource() == telaPrincipal.getBotaoLogoff()) {
            telaPrincipal.setVisible(false);
            telaLogin.getTextlogin().setText("");
            telaLogin.getTextsenha().setText("");
            telaLogin.setVisible(true);
            telaLogin.getTextlogin().grabFocus();

        }

        if (e.getSource() == telaPrincipal.getBotaoSair()) {
            System.exit(0);
        }
        if (e.getSource() == telaLogin.getCancelarLogin()) {
            System.exit(0);
        }

    }

    }


