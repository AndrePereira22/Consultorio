package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.view.BuscarPaciente;
import br.com.fundamento.view.CadastroFornecedor;
import br.com.fundamento.view.CadastroPaciente;
import br.com.fundamento.view.TelaLogin;
import br.com.fundamento.view.TelaPrincipal;
import com.sun.javafx.font.Disposer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Glenda Alves de Lima
 */
public class ControlePaciente implements ActionListener {

    private TelaPrincipal telaPrincipal;
    CadastroPaciente cadastroPaciente;
    BuscarPaciente buscarPaciente;
    IFachada fachada1 = Fachada.getInstance();

    public ControlePaciente(TelaPrincipal telaPrincipal, CadastroPaciente cadastroPaciente, BuscarPaciente buscarPaciente) {

        this.telaPrincipal = telaPrincipal;
        this.cadastroPaciente = cadastroPaciente;
        this.buscarPaciente = buscarPaciente;

        telaPrincipal.getBotaoCadastroPaciente().addActionListener(this);
        cadastroPaciente.getBotaoCancelarrPaciente().addActionListener(this);
        cadastroPaciente.getBotaoSalvarPaciente().addActionListener(this);
        cadastroPaciente.getBotaoSelecionarFotoPaciente().addActionListener(this);
        buscarPaciente.getBotaoAdicionarPaciente().addActionListener(this);
        buscarPaciente.getBotaoFecharPaciente().addActionListener(this);
        buscarPaciente.getBotaoEditarPaciente().addActionListener(this);
        buscarPaciente.getBotaoExcluirPaciente().addActionListener(this);
        buscarPaciente.getBotaoPesquisarPaciente().addActionListener(this);
        buscarPaciente.getTxtpesquisarPaciente().addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) { }
            public void keyPressed(KeyEvent e) { }
            public void keyReleased(KeyEvent e) { preencherbuscas();
            }
        });
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaPrincipal.getBotaoCadastroPaciente()) {
            preencherbuscas();
            telaPrincipal.setEnabled(false);
            buscarPaciente.setVisible(true);

        }
        if (e.getSource() == cadastroPaciente.getBotaoCancelarrPaciente()) {
            telaPrincipal.setEnabled(true);
            cadastroPaciente.setVisible(false);
            buscarPaciente.setVisible(true);

        }
        if (e.getSource() == buscarPaciente.getBotaoFecharPaciente()) {
            telaPrincipal.setEnabled(true);
            buscarPaciente.setVisible(false);

        }
        if (e.getSource() == buscarPaciente.getBotaoAdicionarPaciente()) {
            cadastroPaciente.setVisible(true);
            buscarPaciente.setVisible(false);

        }

        if (e.getSource() == buscarPaciente.getBotaoPesquisarPaciente()) {

           preencherbuscas();

        }
        if (e.getSource() == cadastroPaciente.getBotaoSalvarPaciente()) {

            Endereco end = new Endereco();
            end.setBairro(cadastroPaciente.getTxtbairro().getText());
            end.setRua(cadastroPaciente.getTxtrua().getText());
            end.setCep(cadastroPaciente.getTxtCep().getText());
            end.setNumero(cadastroPaciente.getTxtnumero().getText());
            end.setMunicipio(cadastroPaciente.getTxtcidade().getText());
            end.setEstado(cadastroPaciente.getTxtUf().getSelectedItem().toString());

            Contato con = new Contato();
            con.setEmail(cadastroPaciente.getTxtemail2().getText());
            con.setCelular(cadastroPaciente.getTxtcelular2().getText());
            con.setTelefone(cadastroPaciente.getTxttelefone().getText());

            Prontuario p = new Prontuario();
            // p.setExames(exames);

            Paciente paciente = new Paciente();
            paciente.setNome(cadastroPaciente.getTxtNome().getText());
            String rg = cadastroPaciente.getTxtrg().getText();
            rg = rg.replaceAll("[^0-9]", "");
            int RG = 0;
            try {
                RG = Integer.parseInt(rg);
                paciente.setRg(RG);

            } catch (NumberFormatException erro) {
            }

             java.util.Date d = new Date();

            String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);

            paciente.setData_cadastro(dStr);
            paciente.setCpf(cadastroPaciente.getTxtCpf().getText());
             paciente.setSexo(cadastroPaciente.getCombosexo().getSelectedItem().toString());
            paciente.setConvenio(cadastroPaciente.getTxtConvenio().getText());
            paciente.setProntuario(p);
            paciente.setEndereco(end);
            paciente.setContato(con);
            paciente.setConsultas(new ArrayList<Consulta>());
            paciente.setData_nascimento(cadastroPaciente.getTxtdata().getText());

            fachada1.salvarPaciente(paciente);
            preencherbuscas();
            telaPrincipal.setEnabled(true);
            cadastroPaciente.setVisible(false);
            buscarPaciente.setVisible(true);

        }
    }

    public void preencherbuscas(){
          List<Paciente> pacientes = fachada1.getPorBusca(buscarPaciente.getTxtpesquisarPaciente().getText());

            try {
                String[] colunas = new String[]{"Nome", "CPF", "Sexo", "Data Nascimento", "Data Cadastro", "Rg", "Convenio"};
                Object[][] dados = new Object[pacientes.size()][7];
                for (int i = 0; i < pacientes.size(); i++) {
                    Paciente paciente = pacientes.get(i);
                    dados[i][0] = paciente.getNome();
                    dados[i][1] = paciente.getCpf();
                    dados[i][2] = paciente.getSexo();
                    dados[i][3] = paciente.getData_nascimento();
                    dados[i][4] = paciente.getData_cadastro();
                    dados[i][5] = paciente.getRg();
                    dados[i][6] = paciente.getConvenio();

                }
                DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
                buscarPaciente.getTabelaPaciente().setModel(dataModel);
            } catch (Exception ex) {

            }
        
    }

}
