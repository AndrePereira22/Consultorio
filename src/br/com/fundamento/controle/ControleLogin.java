
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleLogin implements ActionListener {

    private TelaLogin telaLogin;
    private TelaPrincipal telaPrincipal;
    IFachada fachada1 = Fachada.getInstance();

    public ControleLogin(TelaLogin telaLogin, TelaPrincipal telaPrincipal) {
        this.telaLogin = telaLogin;
        this.telaPrincipal = telaPrincipal;
        telaLogin.setVisible(true);
        telaLogin.getEntrar().addActionListener(this);
        telaPrincipal.getBotaoSair().addActionListener(this);
        telaLogin.getCancelarLogin().addActionListener(this);
        telaPrincipal.getBotaoLogoff().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
