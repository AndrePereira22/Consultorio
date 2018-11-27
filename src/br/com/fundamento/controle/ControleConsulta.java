/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.view.CadastroConsultas;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleConsulta implements ActionListener{
    
    private  TelaPrincipal telaPrincipal;
    private CadastroConsultas cadastroConsultas;
    private agendamento agendamento; 
     IFachada fachada1 = Fachada.getInstance();

    public ControleConsulta(TelaPrincipal telaPrincipal, CadastroConsultas cadastroConsultas, agendamento agendamento) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroConsultas = cadastroConsultas;
        this.agendamento = agendamento;
        
        
        
        telaPrincipal.getBotaoAgendamento().addActionListener(this);
        cadastroConsultas.getBotaoConsultaCancelar().addActionListener(this);
        cadastroConsultas.getBotaoConsultaSalvar().addActionListener(this);
        agendamento.getBotaoAdicionarAgendamento().addActionListener(this);
        agendamento.getBotaoEditarAgendamento().addActionListener(this);
        agendamento.getBotaoExcluirAgendamento().addActionListener(this);
        agendamento.getBotaoFecharAgendamento().addActionListener(this);
       
    }
     
     

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == telaPrincipal.getBotaoAgendamento()) {
            telaPrincipal.setEnabled(false);
            agendamento.setVisible(true);
        }
        if (e.getSource() == agendamento.getBotaoFecharAgendamento()) {
            telaPrincipal.setEnabled(true);
            agendamento.setVisible(false);
        }
        if (e.getSource() == agendamento.getBotaoAdicionarAgendamento()) {
           
            cadastroConsultas.setVisible(true); 
            agendamento.setVisible(false);
        }
        if (e.getSource() == cadastroConsultas.getBotaoConsultaCancelar()) {
            telaPrincipal.setEnabled(false);
            agendamento.setVisible(true);
            cadastroConsultas.setVisible(false);
        }
        if (e.getSource() == cadastroConsultas.getBotaoConsultaSalvar()) {

            
            agendamento.setVisible(true);
            cadastroConsultas.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    } 
    
}
