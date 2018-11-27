/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Tarefa;
import br.com.fundamento.view.BuscarTarefa;
import br.com.fundamento.view.CadastroTarefas;
import br.com.fundamento.view.TelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleTarefa implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroTarefas cadastroTarefas;
    private BuscarTarefa buscarTarefa;
    IFachada fachada1 = Fachada.getInstance();

    public ControleTarefa(TelaPrincipal telaPrincipal, CadastroTarefas cadastroTarefas, BuscarTarefa buscarTarefa) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroTarefas = cadastroTarefas;
        this.buscarTarefa = buscarTarefa;

        telaPrincipal.getBotaoCadastrarTarefa().addActionListener(this);
        cadastroTarefas.getBotaoCancelarTarefa().addActionListener(this);
        cadastroTarefas.getBotaoSalvarTarefa().addActionListener(this);
        buscarTarefa.getBotaoAdicionarTarefa().addActionListener(this);
        buscarTarefa.getBotaoEditarTarefa().addActionListener(this);
        buscarTarefa.getBotaoExcluirTarefa().addActionListener(this);
        buscarTarefa.getBotaoFecharTarefa().addActionListener(this);
        buscarTarefa.getBotaoPesquisarTarefa().addActionListener(this);
  
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == telaPrincipal.getBotaoCadastrarTarefa()) {
             
              List<Tarefa> tarefas = fachada1.getAllTarefa();

            try {
                String[] colunas = new String[]{"Descricao", "Prioridade", "Status", "Data Inicio","Data Termino"};
                Object[][] dados = new Object[tarefas.size()][5];
                for (int i = 0; i < tarefas.size(); i++) {
                    Tarefa tarefa = tarefas.get(i);
                    dados[i][0] = tarefa.getDescricao();
                    dados[i][1] = tarefa.getPrioridade();
                    dados[i][2] = tarefa.isStatus();
                    dados[i][3] = tarefa.getData_inicio();
                    dados[i][4] = tarefa.getData_termino();

                }
                DefaultTableModel dataModel = new DefaultTableModel(dados, colunas);
                buscarTarefa.getTabelaTarefa().setModel(dataModel);
            } catch (Exception ex) {

            }
            telaPrincipal.setEnabled(false);
            buscarTarefa.setVisible(true);
        }
        if (e.getSource() == buscarTarefa.getBotaoFecharTarefa()) {
            telaPrincipal.setEnabled(true);
            buscarTarefa.setVisible(false);
        }
        if (e.getSource() == buscarTarefa.getBotaoAdicionarTarefa()) {

            cadastroTarefas.setVisible(true);
            buscarTarefa.setVisible(false);
        }
        if (e.getSource() == cadastroTarefas.getBotaoCancelarTarefa()) {
            telaPrincipal.setEnabled(false);
            buscarTarefa.setVisible(true);
            cadastroTarefas.setVisible(false);
        }
        if (e.getSource() == cadastroTarefas.getBotaoSalvarTarefa()) {

            buscarTarefa.setVisible(true);
            cadastroTarefas.setVisible(false);
            telaPrincipal.setEnabled(true);
        }

    }
}
