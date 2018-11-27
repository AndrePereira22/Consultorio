/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleLogin implements ActionListener{
    
    private TelaLogin telaLogin;
     private TelaPrincipal telaPrincipal;

    public ControleLogin(TelaLogin telaLogin, TelaPrincipal telaPrincipal) {
        this.telaLogin = telaLogin;
        this.telaPrincipal = telaPrincipal;
        telaLogin.setVisible(true);
        telaLogin.getEntrar().addActionListener(this);
        telaPrincipal.getBotaoSair().addActionListener(this);
        telaLogin.getCancelarLogin().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaLogin.getEntrar()) {
            if (telaLogin.getTextlogin().getText().equalsIgnoreCase("admin")) {
                telaPrincipal.setVisible(true);
                telaLogin.setVisible(false);
            }
        }
        if(e.getSource() == telaPrincipal.getBotaoSair())
            System.exit(0);
        if(e.getSource() == telaLogin.getCancelarLogin())
            System.exit(0);
            
    
    }
     
     
    
    
}
