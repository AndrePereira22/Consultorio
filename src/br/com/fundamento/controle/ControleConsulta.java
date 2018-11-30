/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

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
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
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
        if (e.getSource() == cadastroConsultas.getBotaoConsultaSalvar()) {
            
            Endereco end = new Endereco();
            end.setBairro("");


            Contato con = new Contato();
            con.setEmail("");
            

            Consultorio c = new Consultorio();
            c.setMedicos(new ArrayList<Medico>());
            c.setEndereco(end);
            c.setContato(con);

            Login l = new Login();
            l.setSenha("123");
            l.setUsuario("admin");

            List<Especializacao> especializacoes= new ArrayList<Especializacao>();
            
            Especializacao es= new Especializacao();
            especializacoes.add(es);
            
            Medico medico = new Medico();
            medico.setConsultas(new ArrayList<Consulta>());
            medico.setEspecializacoes(especializacoes);
            medico.setContato(con);
            medico.setEndereco(end);
            medico.setConsultorio(c);
            medico.setLogin(l);
            
              Prontuario p = new Prontuario();
            Paciente paciente = new Paciente();
        
            paciente.setProntuario(p);
            paciente.setEndereco(end);
            paciente.setContato(con);
            paciente.setConsultas(new ArrayList<Consulta>());
            
            Pagamento pagamento = new Pagamento();
            pagamento.setParcelas(new ArrayList<Parcela>());
            
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
            telaPrincipal.setEnabled(true);
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
                dados[i][2] = "Maria";
                dados[i][3] = "Andre";

            }
            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
            agendamento.getTabelaAgendamento().setModel(dataModel);
        } catch (Exception ex) {

        }
    }

}
