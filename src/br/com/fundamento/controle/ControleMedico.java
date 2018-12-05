/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.CommumDao;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Estoque;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.view.BuscarMedico;
import br.com.fundamento.view.CadastroMedico;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleMedico implements ActionListener {

    private TelaPrincipal telaPrincipal;
    CadastroMedico cadastroMedico;
    BuscarMedico buscarMedico;
    IFachada fachada1 = Fachada.getInstance();

    public ControleMedico(TelaPrincipal telaPrincipal, CadastroMedico cadastroMedico, BuscarMedico buscarMedico) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroMedico = cadastroMedico;
        this.buscarMedico = buscarMedico;

        telaPrincipal.getBotaoMedico().addActionListener(this);
        buscarMedico.getBotaoFecharMedico().addActionListener(this);
        buscarMedico.getBotaoAdicionarMedico().addActionListener(this);
        buscarMedico.getBotaoEditarMedico().addActionListener(this);
        buscarMedico.getBotaoExckuirMedico().addActionListener(this);
        buscarMedico.getBotaoPesquisarMedico().addActionListener(this);
        cadastroMedico.getBotaoCancelarMedico().addActionListener(this);
        cadastroMedico.getBotaoSalvarMedico().addActionListener(this);
        cadastroMedico.getBotaoSelecionar().addActionListener(this);
         buscarMedico.getTxtPesquisarMedico().addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) { }
            public void keyReleased(KeyEvent e) { preenchertabela();
            }
       
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoMedico()) {
            preenchertabela();

            telaPrincipal.setEnabled(false);
            buscarMedico.setVisible(true);
        }
        if (e.getSource() == buscarMedico.getBotaoFecharMedico()) {
            telaPrincipal.setEnabled(true);
            buscarMedico.setVisible(false);
        }
        if (e.getSource() == buscarMedico.getBotaoAdicionarMedico()) {

            cadastroMedico.setVisible(true);
            buscarMedico.setVisible(false);
        }
        if (e.getSource() == cadastroMedico.getBotaoCancelarMedico()) {
            telaPrincipal.setEnabled(false);
            buscarMedico.setVisible(true);
            cadastroMedico.setVisible(false);
        }
        if(e.getSource() == buscarMedico.getBotaoPesquisarMedico()){
          
            preenchertabela();
            
        }
        if (e.getSource() == cadastroMedico.getBotaoSalvarMedico()) {

            Endereco end = new Endereco();
            end.setBairro(cadastroMedico.getTxtbairro().getText());
            end.setRua(cadastroMedico.getTxtrua().getText());
            end.setCep(cadastroMedico.getTxtcep().getText());
            end.setNumero(cadastroMedico.getTxtnumero().getText());
            end.setMunicipio(cadastroMedico.getTxtcidade().getText());
            end.setEstado(cadastroMedico.getTxtUf().getSelectedItem().toString());

            Contato con = new Contato();
            con.setEmail(cadastroMedico.getTxtemail().getText());
            con.setCelular(cadastroMedico.getTxtcelular().getText());
            con.setTelefone(cadastroMedico.getTxttelefone().getText());

             Consultorio c = fachada1.bucarConsultorio();
             Endereco endConsultorio =  CommumDao.bucarEndereco("consultorio", "nome_fantasia", c.getNome_fantasia());
               Contato t = CommumDao.bucarContato("consultorio","nome_fantasia", c.getNome_fantasia());
       
            c.setMedicos(new ArrayList<Medico>());
            c.setEndereco(endConsultorio);
            c.setContato(t);

            Login l = new Login();
            String senha = new String(cadastroMedico.getTxtsenha1().getPassword());
            l.setSenha(senha);
            l.setUsuario(cadastroMedico.getTxtlogin1().getText());

            List<Especializacao> especializacoes= new ArrayList<Especializacao>();
            
            Especializacao es= new Especializacao();
            es.setDescricao(cadastroMedico.getTxtEspecializacao().getText());
             String  sa= cadastroMedico.getTxtsalario1().getText();
            sa = sa.replaceAll("[^0-9]", "");
            double salario = 0;
            try {
                salario = Double.parseDouble(sa);
 
            } catch (NumberFormatException erro) {
            }
            es.setSalario(salario);
            es.setHorario_disponivel(cadastroMedico.getTxthorario().getText());
            especializacoes.add(es);
            
            Medico medico = new Medico();
            medico.setConsultas(new ArrayList<Consulta>());
            medico.setEspecializacoes(especializacoes);
            medico.setContato(con);
            medico.setEndereco(end);
            medico.setConsultorio(c);
            medico.setLogin(l);
            medico.setCpf(cadastroMedico.getTxtcpf().getText());
            java.util.Date d = new Date();

            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

            medico.setData_cadastro(dStr);
            medico.setData_nascimento(cadastroMedico.getTxtdata().getText());
            medico.setNome(cadastroMedico.getTxtnome().getText());
            String rg = cadastroMedico.getTxtrg().getText();
            rg = rg.replaceAll("[^0-9]", "");
            int RG = Integer.parseInt(rg);
            medico.setRg(RG);
            medico.setSexo(cadastroMedico.getjComboBox1().getSelectedItem().toString());

            String confirmarSenha = new String( cadastroMedico.getTxtconfirmasenha1().getPassword());
            
            if(senha.equals(confirmarSenha)){
            
            fachada1.salvarMedico(medico);
            preenchertabela();
            buscarMedico.setVisible(true);
            cadastroMedico.setVisible(false);
            telaPrincipal.setEnabled(true);
            }else JOptionPane.showMessageDialog(null, "Senha diferentes");
        }

    }

    public void preenchertabela() {
            List<Medico> medicos = fachada1.getPorBuscaMedico(buscarMedico.getTxtPesquisarMedico().getText());

        try {
            String[] colunas = new String[]{"Nome", "Sexo", "Rg", "CPF", "Data Nascimento", "Data Cadastro"};
            Object[][] dados = new Object[medicos.size()][6];
            for (int i = 0; i < medicos.size(); i++) {
                Medico medico = medicos.get(i);
                dados[i][0] = medico.getNome();
                dados[i][1] = medico.getSexo();
                dados[i][2] = medico.getRg();
                dados[i][3] = medico.getCpf();
                dados[i][4] = medico.getData_nascimento();
                dados[i][5] = medico.getData_cadastro();
            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            buscarMedico.getTabelaMedico().setModel(dataModel);
        } catch (Exception ex) {

        }

    }

}
