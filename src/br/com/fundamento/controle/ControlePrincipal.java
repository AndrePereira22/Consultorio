/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoFuncionario;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
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
    private TelaLogin telaLogin;
   private static Funcionario f;
    IFachada fachada1 = Fachada.getInstance();

    public ControlePrincipal(TelaPrincipal telaPrincipal,TelaLogin telaLogin) {
        this.telaPrincipal = telaPrincipal;

        this.telaLogin = telaLogin;

        
        telaPrincipal.getBotaoAtualizardados().addActionListener(this);
        telaPrincipal.getBotaoCancelarrConsultorio().addActionListener(this);
        telaPrincipal.getBotaoSalvarConsultorio().addActionListener(this);
         telaLogin.setVisible(true);
        telaLogin.getEntrar().addActionListener(this);
        telaPrincipal.getBotaoSair().addActionListener(this);
        telaLogin.getCancelarLogin().addActionListener(this);
        telaPrincipal.getBotaoLogoff().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAtualizardados()) {
                             telaPrincipal.getPanelConsultorio().setVisible(true);
           
            try {

                Consultorio c = fachada1.bucarConsultorio();
               
                telaPrincipal.getTxtnomefantasia().setText(c.getNome_fantasia());
                telaPrincipal.getTxtcnpj().setText(c.getCnpj());
                telaPrincipal.getTxtrazao().setText(c.getRazao_social());

                telaPrincipal.getTxtrua().setText(c.getEndereco().getRua());
                telaPrincipal.getTxtbairro().setText(c.getEndereco().getBairro());
               telaPrincipal.getTxtcep().setText(c.getEndereco().getCep());
                telaPrincipal.getTxtnumero().setText(c.getEndereco().getNumero());
                telaPrincipal.getTxtcidade().setText(c.getEndereco().getMunicipio());

                for (int u = 0; u < telaPrincipal.getTxtUf().getItemCount(); u++) {

                    if (telaPrincipal.getTxtUf().getItemAt(u).equals(c.getEndereco().getEstado())) {
                        telaPrincipal.getTxtUf().setSelectedItem(telaPrincipal.getTxtUf().getItemAt(u));
                    }
                }

                telaPrincipal.getTxtemail().setText(c.getContato().getEmail());
                telaPrincipal.getTxtcelular().setText(c.getContato().getCelular());
                telaPrincipal.getTxttelefone().setText(c.getContato().getTelefone());
            } catch (Exception p) {
            }
          

        }

        if (e.getSource() == telaPrincipal.getBotaoCancelarrConsultorio()) {
 
      telaPrincipal.getPanelConsultorio().setVisible(false);

        }
        if (e.getSource() == telaPrincipal.getBotaoSalvarConsultorio()) {
            
            Consultorio consultori = fachada1.buscarConsultorioPorId(1);
            if(consultori==null){
                criarConsultorio();
            }else{
            Endereco end = consultori.getEndereco();
            
            end.setBairro(telaPrincipal.getTxtbairro().getText());
            end.setRua(telaPrincipal.getTxtrua().getText());
            end.setCep(telaPrincipal.getTxtcep().getText());
            end.setNumero(telaPrincipal.getTxtnumero().getText());
            end.setEstado(telaPrincipal.getTxtUf().getSelectedItem().toString());
            end.setMunicipio(telaPrincipal.getTxtcidade().getText());
            Contato con = consultori.getContato();
             
            con.setEmail(telaPrincipal.getTxtemail().getText());
            con.setCelular(telaPrincipal.getTxtcelular().getText());
            con.setTelefone(telaPrincipal.getTxttelefone().getText());
            consultori.setEndereco(end);
            consultori.setContato(con);
            consultori.setCnpj(telaPrincipal.getTxtcnpj().getText());
            consultori.setNome_fantasia(telaPrincipal.getTxtnomefantasia().getText());
            consultori.setRazao_social(telaPrincipal.getTxtrazao().getText());
            consultori.setMedicos(new ArrayList<Medico>());

            fachada1.editarConsultorio(consultori);
           telaPrincipal.getPanelConsultorio().setVisible(false);
        }
        }
        if (e.getSource() == telaLogin.getEntrar()) {
            Login loginF=null,loginM=null ;
            
            String senha = new String(telaLogin.getTextsenha().getPassword());
            try {
                loginF = fachada1.buscarLogin(telaLogin.getTextlogin().getText());
                  loginM = fachada1.buscarLoginMedico("l.usuario",telaLogin.getTextlogin().getText());
                if (loginF.getUsuario().equals(telaLogin.getTextlogin().getText()) && loginF.getSenha().equals(senha)) {
                    f=(new DaoFuncionario().buscarFuncionario(telaLogin.getTextlogin().getText()));
                    
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

    /**
     * @return the f
     */
    public static Funcionario getF() {
        return f;
    }

    /**
     * @param aF the f to set
     */
    public static void setF(Funcionario aF) {
        f = aF;
    }

    public void criarConsultorio(){
          
            Consultorio consultori = new Consultorio();
            Endereco end = new Endereco();
            
            end.setBairro(telaPrincipal.getTxtbairro().getText());
            end.setRua(telaPrincipal.getTxtrua().getText());
            end.setCep(telaPrincipal.getTxtcep().getText());
            end.setNumero(telaPrincipal.getTxtnumero().getText());
            end.setEstado(telaPrincipal.getTxtUf().getSelectedItem().toString());
            end.setMunicipio(telaPrincipal.getTxtcidade().getText());
            Contato con = new Contato();
             
            con.setEmail(telaPrincipal.getTxtemail().getText());
            con.setCelular(telaPrincipal.getTxtcelular().getText());
            con.setTelefone(telaPrincipal.getTxttelefone().getText());
            consultori.setEndereco(end);
            consultori.setContato(con);
            consultori.setCnpj(telaPrincipal.getTxtcnpj().getText());
            consultori.setNome_fantasia(telaPrincipal.getTxtnomefantasia().getText());
            consultori.setRazao_social(telaPrincipal.getTxtrazao().getText());
            consultori.setMedicos(new ArrayList<Medico>());

            fachada1.salvarConsultorio(consultori);
           telaPrincipal.getPanelConsultorio().setVisible(false);
            
    }
    
    }


