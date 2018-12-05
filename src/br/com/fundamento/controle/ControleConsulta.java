/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.CommumDao;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Consultorio;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Login;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Prontuario;
import br.com.fundamento.view.CadastroConsultas;
import br.com.fundamento.view.TelaPagamento;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleConsulta implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroConsultas cadastroConsultas;
    private agendamento agendamento;
    private TelaPagamento telaPagamento;
    private Medico medico;
    private Especializacao especializacao;
    private Paciente paciente;
    private List<Paciente> pacientes;
    
    IFachada fachada1 = Fachada.getInstance();

    public ControleConsulta(TelaPrincipal telaPrincipal, CadastroConsultas cadastroConsultas, agendamento agendamento,TelaPagamento pagamento) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroConsultas = cadastroConsultas;
        this.agendamento = agendamento;
        this.telaPagamento= pagamento;

        telaPrincipal.getBotaoAgendamento().addActionListener(this);
        cadastroConsultas.getBotaoConsultaCancelar().addActionListener(this);
        cadastroConsultas.getBotaoConsultaSalvar().addActionListener(this);
        cadastroConsultas.getBotaoPesquisarmedico().addActionListener(this);
        cadastroConsultas.getBotaoPesquisarPaciente().addActionListener(this);
        agendamento.getBotaoAdicionarAgendamento().addActionListener(this);
        agendamento.getBotaoEditarAgendamento().addActionListener(this);
        agendamento.getBotaoExcluirAgendamento().addActionListener(this);
        agendamento.getBotaoFecharAgendamento().addActionListener(this);
        telaPagamento.getBotaoOk().addActionListener(this);
        telaPagamento.getComboStatus().addActionListener(this);
        telaPagamento.getBotaocancelarpacela().addActionListener(this);
        

        agendamento.getCalendario().getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                preenchertabela();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAgendamento()) {
            preenchertabela();
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
            preenchertabela();
            telaPrincipal.setEnabled(false);
            agendamento.setVisible(true);
            cadastroConsultas.setVisible(false);
        }
        if(e.getSource()== telaPagamento.getBotaocancelarpacela()){
            telaPagamento.setVisible(false);
            
        }
        if(e.getSource() == telaPagamento.getComboStatus()){
            
          if(telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Vista")){
            telaPagamento.getPanelParcela().setVisible(false);
          }
          if(telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Prazo")){
            telaPagamento.getPanelParcela().setVisible(true);
          }
        }
        if(e.getSource() == cadastroConsultas.getBotaoPesquisarmedico()){
            medico= fachada1.BuscarMedico(cadastroConsultas.getTxtmedico().getText());
            especializacao = fachada1.buscarEspecializaco(medico.getNome());
            if(medico!= null){
                cadastroConsultas.getTxtespecializacao().setText(especializacao.getDescricao());
                cadastroConsultas.getTxtmedico().setText(medico.getNome());
            }
        }
        if(e.getSource() == cadastroConsultas.getBotaoPesquisarPaciente()){
        paciente= fachada1.buscarPaciente(cadastroConsultas.getTxtPaciente().getText());
        
        if(paciente!= null){
                cadastroConsultas.getTxtconvenio().setText(paciente.getConvenio());
        }else{
          
            pacientes = fachada1.getAllPaciente();
           for(Paciente p: pacientes) {
               if(p.getNome().contains(cadastroConsultas.getTxtPaciente().getText())){
                   paciente = p;
                   cadastroConsultas.getTxtconvenio().setText(paciente.getConvenio());
                   cadastroConsultas.getTxtPaciente().setText(paciente.getNome());
               }
                   
           }
   
        }
    }
        if(e.getSource() == telaPagamento.getBotaoOk()){
              
            Endereco end = new Endereco();
            end.setBairro("");


           

            Consultorio c = fachada1.bucarConsultorio();
            Endereco endConsultorio = CommumDao.bucarEndereco("consultorio", "nome_fantasia", c.getNome_fantasia());
            Contato t = CommumDao.bucarContato("consultorio", "nome_fantasia", c.getNome_fantasia());

            c.setEndereco(endConsultorio);
            c.setContato(t);
            c.setMedicos(new ArrayList<Medico>());
            
            Login l = fachada1.buscarLoginMedico("m.nome",medico.getNome());
            if(l==null) System.out.println("br.com.fundamento.controle.ControleConsulta.actionPerformed()");
            List<Especializacao> especializacoes= new ArrayList<Especializacao>();
            
           especializacoes.add(especializacao);
            medico.setConsultas(new ArrayList<Consulta>());
             Endereco endeMedico = CommumDao.bucarEndereco("medico", "nome", medico.getNome());
            Contato cMedico = CommumDao.bucarContato("medico", "nome", medico.getNome());
           
            
            medico.setEspecializacoes(especializacoes);
            medico.setContato(cMedico);
            medico.setEndereco(endeMedico);
            medico.setConsultorio(c);
            medico.setLogin(l);
            
              Prontuario p = new Prontuario();
            Endereco endePaciente = CommumDao.bucarEndereco("paciente", "nome", paciente.getNome());
            Contato cPaciente = CommumDao.bucarContato("paciente", "nome", paciente.getNome());
        
            paciente.setProntuario(p);
            paciente.setEndereco(endePaciente);
            paciente.setContato(cPaciente);
            paciente.setConsultas(new ArrayList<Consulta>());
            
            ArrayList<Parcela> parcelas= new ArrayList<Parcela>();
  
            Pagamento pagamento = new Pagamento();
            pagamento.setForma_pagamento(telaPagamento.getComboPagamento().getSelectedItem().toString());
            
            if(telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Vista"))   pagamento.setStatus(true);
            else                            pagamento.setStatus(false); 
            
            Double valorpacela=null;
            int qparcela=0;
            try {
         
            String n = telaPagamento.getTxtvalortotal().getText();
            Double valor  = Double.parseDouble(n);
            
            pagamento.setValor_total(valor);
            
            String tt = telaPagamento.getTxtQParcela().getText();
            qparcela = Integer.parseInt(tt);
            pagamento.setQuantidade_parcelas(qparcela);
            
            valorpacela = valor/qparcela;
            } catch (Exception o) {
            }
            if(qparcela>0){
                
                for(int j=1; j<=qparcela; j++){
                   Parcela parcela = new Parcela();
                
                   
                   parcela.setNumero(j);
                   if(qparcela == 1 )   parcela.setParcela_unica(true);
                   else                            parcela.setParcela_unica(false); 
                parcela.setStatus(false);
                parcela.setPagamento(pagamento);
                parcela.setData_vencimento(telaPagamento.getTxtdata_ven_parcela().getText());
                parcela.setValor(valorpacela);
                   parcelas.add(parcela);

                }
              
            }
        
            pagamento.setParcelas(parcelas);
            
            
            Caixa cai = new Caixa();
            cai.setPagamentos(new ArrayList<Pagamento>());
            cai.setFuncionarios(new ArrayList<Funcionario>());
            
            pagamento.setCaixa(cai);

                    
            Consulta consulta = new Consulta();
            consulta.setData(cadastroConsultas.getTxtdata().getText());
            consulta.setHora(cadastroConsultas.getTxtHora().getText());
            consulta.setTipo(cadastroConsultas.getTipoExameOuConsulta().getText());
            consulta.setMedico(medico);
            consulta.setPaciente(paciente);
            consulta.setPagamento(pagamento);
            
            pagamento.setConsulta(consulta);

            fachada1.salvarConsulta(consulta);
            preenchertabela();
            agendamento.setVisible(true);
            cadastroConsultas.setVisible(false);
            telaPagamento.setVisible(false);
            telaPrincipal.setEnabled(true);
        }
        if (e.getSource() == cadastroConsultas.getBotaoConsultaSalvar()) {
          telaPagamento.setVisible(true);
        }

    }

    public void preenchertabela() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String busca = formato.format(agendamento.getCalendario().getDate());

        List<Consulta> consultas = fachada1.getPorBuscaConsulta(busca);

        try {
            String[] colunas = new String[]{"Tipo", "Hora", "Paciente", "Medico"};
            Object[][] dados = new Object[consultas.size()][4];
            for (int i = 0; i < consultas.size(); i++) {
                Consulta consulta = consultas.get(i);
                dados[i][0] = consulta.getTipo();
                dados[i][1] = consulta.getHora();
                dados[i][2] = paciente.getNome();
                dados[i][3] = medico.getNome();

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            agendamento.getTabelaAgendamento().setModel(dataModel);
        } catch (Exception ex) {

        }
    }

}
