
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.controle;

import br.com.fundamento.dao.DaoCaixa;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.Consulta;
import br.com.fundamento.modelos.Contato;
import br.com.fundamento.modelos.Endereco;
import br.com.fundamento.modelos.Especializacao;
import br.com.fundamento.modelos.Funcionario;
import br.com.fundamento.modelos.Medico;
import br.com.fundamento.modelos.Paciente;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.modelos.Parcela;
import br.com.fundamento.modelos.Render;
import br.com.fundamento.view.CadastroConsultas;
import br.com.fundamento.view.CadastroPaciente;
import br.com.fundamento.view.TelaPagamento;
import br.com.fundamento.view.TelaPrincipal;
import br.com.fundamento.view.agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Glenda Alves de Lima
 */
public class ControleConsulta implements ActionListener {

    private TelaPrincipal telaPrincipal;
    private CadastroConsultas cadastroConsultas, cc;
    private agendamento agendamento;
    private TelaPagamento telaPagamento;
    private Medico medico;
    private Especializacao especializacao;
    private Paciente paciente;
    private CadastroPaciente cadastroPaciente = new CadastroPaciente();
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private JButton btn1, btn2, btn3;
    private List<Consulta> consultas;
    private Consulta c;
    private static Caixa caixa;
    private static Funcionario funcionario;
    private Date data2 = new Date();
    private static double valor;
    private static int id;
    private Calendar ca = new GregorianCalendar();
    private List<String> horasMarcados, horas;
    private static IFachada fachada1 = Fachada.getInstance();

    public ControleConsulta(TelaPrincipal telaPrincipal, CadastroConsultas cadastroConsultas, agendamento agendamento, TelaPagamento pagamento) {
        this.telaPrincipal = telaPrincipal;
        this.cadastroConsultas = cadastroConsultas;
        this.agendamento = agendamento;
        this.telaPagamento = pagamento;
        this.consultas = new ArrayList<Consulta>();
        cc = new CadastroConsultas();
        funcionario = new Funcionario();
        horas = new ArrayList<String>();
        horasMarcados = new ArrayList<String>();

        telaPrincipal.getBotaoAgendamento().addActionListener(this);
        cadastroConsultas.getBotaoConsultaCancelar().addActionListener(this);
        cadastroConsultas.getBotaoConsultaSalvar().addActionListener(this);
        cadastroConsultas.getBotaoadd().addActionListener(this);
        cadastroPaciente.getBotaoCancelarrPaciente().addActionListener(this);
        cadastroPaciente.getBotaoSalvarPaciente().addActionListener(this);
        agendamento.getBotaoAdicionarAgendamento().addActionListener(this);

        agendamento.getBotaoFecharAgendamento().addActionListener(this);
        telaPagamento.getBotaoOk().addActionListener(this);
        telaPagamento.getComboStatus().addActionListener(this);
        telaPagamento.getBotaocancelarpacela().addActionListener(this);
        agendamento.getTabelaAgendamento().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = agendamento.getTabelaAgendamento().getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / agendamento.getTabelaAgendamento().getRowHeight();

                if (row < agendamento.getTabelaAgendamento().getRowCount() && row >= 0 && column < agendamento.getTabelaAgendamento().getColumnCount() && column >= 0) {
                    Object value = agendamento.getTabelaAgendamento().getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getName().equals("m")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja Modificar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int ro = agendamento.getTabelaAgendamento().getSelectedRow();

                            if (editar == 0) {
                                cc.getLabelConsulta().setText("ATUALIZAR CONSULTA");
                                cc.setVisible(true);
                                preencherHorarioDisponivel(cc);
                                agendamento.setVisible(false);

                                c = consultas.get(ro);

                                preencherCadastro(c, cc);
                                PreencherBuscaMedico(cc);
                                try {
                                    cc.getBotaoConsultaSalvar().addActionListener(new Acaoupdate());
                                    cc.getBotaoConsultaCancelar().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            cc.setVisible(false);

                                            telaPrincipal.setVisible(true);

                                            agendamento.setVisible(true);
                                            preenchertabela();

                                            c = null;

                                        }
                                    });

                                } catch (Exception ui) {
                                }
                            }
                        }
                        if (boton.getName().equals("e")) {
                            int editar = JOptionPane.showConfirmDialog(null, "Deseja eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

                            int roo = agendamento.getTabelaAgendamento().getSelectedRow();
                            if (editar == 0) {
                                c = consultas.get(roo);

                                fachada1.ativarDesativarConsulta(c.getId());
                                preenchertabela();
                                preencherHorarioDisponivel(cadastroConsultas);
                            }
                        }
                        if (boton.getName().equals("p")) {
                            int pagar = JOptionPane.showConfirmDialog(null, "Ir para o Pagamento", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                            int roo = agendamento.getTabelaAgendamento().getSelectedRow();
                            if (pagar == 0) {
                                c = consultas.get(roo);
                                Pagamento pagamento = fachada1.buscarPagamentoPorId(c.getPagamento().getId());
                                if (pagamento.getValor_total() == 0) {
                                    telaPagamento.setVisible(true);
                                    telaPagamento.getTxtQParcela().setEnabled(false);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Forma de pagamento ja escolhido ");
                                }

                            }
                        }
                    }
                    if (value instanceof JCheckBox) {
                        //((JCheckBox)value).doClick();
                        JCheckBox ch = (JCheckBox) value;
                        if (ch.isSelected() == true) {
                            ch.setSelected(false);
                        }
                        if (ch.isSelected() == false) {
                            ch.setSelected(true);
                        }

                    }
                }

            }

        });

        cadastroConsultas.getTxtPaciente().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                PreencherBuscaPaciente();
            }
        });
        cadastroConsultas.getTxtmedico().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                PreencherBuscaMedico(cadastroConsultas);
            }
        });
        cc.getTxtmedico().addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                PreencherBuscaMedico(cc);
            }
        });

        cadastroConsultas.getListPaciente().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cadastroConsultas.getListPaciente().getMinSelectionIndex();
                try {

                    paciente = pacientes.get(indice);
                    cadastroConsultas.getTxtPaciente().setText(paciente.getNome());
                    cadastroConsultas.getTxtconvenio().setText(paciente.getConvenio());
                } catch (Exception eu) {
                }
            }
        });
        cadastroConsultas.getListaMedico().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cadastroConsultas.getListaMedico().getMinSelectionIndex();
                try {

                    medico = medicos.get(indice);
                    especializacao = fachada1.buscarEspecializacaoPorId(medico.getId_esp());
                    cadastroConsultas.getTxtmedico().setText(medico.getNome());
                    cadastroConsultas.getTxtespecializacao().setText(especializacao.getDescricao());

                } catch (Exception eu) {
                }
            }
        });
        cc.getListaMedico().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indice = cc.getListaMedico().getMinSelectionIndex();
                try {

                    medico = medicos.get(indice);
                    especializacao = fachada1.buscarEspecializacaoPorId(medico.getId_esp());
                    cc.getTxtmedico().setText(medico.getNome());
                    cc.getTxtespecializacao().setText(especializacao.getDescricao());

                } catch (Exception eu) {
                }
            }
        });

        agendamento.getCalendario().getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                horasMarcados.clear();
                preenchertabela();

            }
        });
        telaPagamento.getTxtQParcela().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                Double vaalorTotal = 0.0;
                int qparcela = 0;
                Double valorParcela = 0.0;
                try {

                    String valor = telaPagamento.getTxtvalortotal().getText();
                    vaalorTotal = Double.parseDouble(valor);

                    String q = telaPagamento.getTxtQParcela().getText();
                    qparcela = Integer.parseInt(q);

                    valorParcela = vaalorTotal / qparcela;

                } catch (Exception p) {
                }

                telaPagamento.getTxtValorparcela().setText(valorParcela + "");

                Date data2 = new Date();
                Calendar c = new GregorianCalendar();
                c.setTime(data2);
                c.set(Calendar.MONTH, c.get(Calendar.MONTH) + qparcela);
                c.set(Calendar.YEAR, c.get(Calendar.YEAR));

                String f = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
                telaPagamento.getTxtdata_ven_parcela().setText(f);

            }
        });

//        agendamento.getCalendario().getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
//            @Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                preenchertabela();
//            }
//        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaPrincipal.getBotaoAgendamento()) {
            agendamento.setVisible(true);
            preenchertabela();

            abrirCaixa();
        }

        if (e.getSource() == agendamento.getBotaoFecharAgendamento()) {
            telaPrincipal.setEnabled(true);
            agendamento.setVisible(false);
        }
        if (e.getSource() == agendamento.getBotaoAdicionarAgendamento()) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String busca = formato.format(agendamento.getCalendario().getDate().getTime());

            preencherHorarioDisponivel(cadastroConsultas);
            cadastroConsultas.setVisible(true);
            cadastroConsultas.getTxtdata().setText(busca);
            agendamento.setVisible(false);
        }
        if (e.getSource() == cadastroConsultas.getBotaoConsultaCancelar()) {
            preenchertabela();
            cadastroConsultas.getListPaciente().clearSelection();
            cadastroConsultas.getListaMedico().clearSelection();
            cadastroConsultas.getListaMedico().setVisible(false);

            cadastroConsultas.getListPaciente().setVisible(false);
            telaPrincipal.setEnabled(false);
            agendamento.setVisible(true);
            cadastroConsultas.setVisible(false);
        }
        if (e.getSource() == telaPagamento.getBotaocancelarpacela()) {
            telaPagamento.setVisible(false);

        }
        if (e.getSource() == cadastroConsultas.getBotaoadd()) {

            cadastroPaciente.setVisible(true);
        }
        if (e.getSource() == telaPagamento.getComboStatus()) {

            if (telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Vista")) {
                telaPagamento.getPanelParcela().setVisible(false);
                telaPagamento.getTxtQParcela().setEnabled(false);
            }
            if (telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Prazo")) {
                telaPagamento.getPanelParcela().setVisible(true);
                telaPagamento.getTxtQParcela().setEnabled(true);
            }
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

            Paciente pa = new Paciente();
            pa.setNome(cadastroPaciente.getTxtNome().getText());

            pa.setRg(cadastroPaciente.getTxtrg().getText());
            pa.setCpf(cadastroPaciente.getTxtCpf().getText());
            pa.setSexo(cadastroPaciente.getCombosexo().getSelectedItem().toString());
            pa.setConvenio(cadastroPaciente.getTxtConvenio().getText());
            pa.setEndereco(end);
            pa.setContato(con);
            pa.setData_nascimento(cadastroPaciente.getTxtdata().getText());
            paciente = pa;

            fachada1.salvarPaciente(pa);

            cadastroConsultas.getTxtPaciente().setText(paciente.getNome());
            cadastroConsultas.getTxtconvenio().setText(paciente.getConvenio());
            cadastroPaciente.setVisible(false);

        }
        if (e.getSource() == cadastroPaciente.getBotaoCancelarrPaciente()) {
            cadastroPaciente.setVisible(false);

        }
        if (e.getSource() == telaPagamento.getBotaoOk()) {

            ArrayList<Parcela> parcelas = new ArrayList<Parcela>();
            Pagamento pagamento = fachada1.buscarPagamentoPorId(c.getPagamento().getId());

            pagamento.setForma_pagamento(telaPagamento.getComboPagamento().getSelectedItem().toString());

            if (telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Vista")) {

                pagamento.setStatus(true);
            } else {
                pagamento.setStatus(false);

            }

            Double valorpacela = null;
            int qparcela = 0;
            try {

                String n = telaPagamento.getTxtvalortotal().getText();
                Double valor = Double.parseDouble(n);

                pagamento.setValor_total(valor);

                String tt = telaPagamento.getTxtQParcela().getText();
                qparcela = Integer.parseInt(tt);
                pagamento.setQuantidade_parcelas(qparcela);

                valorpacela = valor / qparcela;
            } catch (Exception o) {
            }
            if (qparcela > 0) {

                for (int j = 1; j <= qparcela; j++) {
                    Parcela parcela = new Parcela();

                    parcela.setNumero(j);

                    parcela.setStatus(false);
                    parcela.setPagamento(pagamento);

                    ca.setTime(data2);
                    ca.set(Calendar.MONTH, ca.get(Calendar.MONTH) + j);
                    ca.set(Calendar.YEAR, ca.get(Calendar.YEAR));

                    String f = new SimpleDateFormat("dd/MM/yyyy").format(ca.getTime());
                    parcela.setData_vencimento(f);
                    parcela.setValor(valorpacela);
                    parcelas.add(parcela);

                }

            }

            pagamento.setParcelas(parcelas);
            fachada1.editarPagamento(pagamento);

            if (telaPagamento.getComboStatus().getSelectedItem().toString().equals("A Vista")) {

                valor = getCaixa().getValor_fechamento() + pagamento.getValor_total();
                getCaixa().setValor_fechamento(valor);
                fachada1.editarCaixa(getCaixa());

            }

            preenchertabela();
            agendamento.setVisible(true);
            telaPagamento.setVisible(false);

        }
        if (e.getSource() == cadastroConsultas.getBotaoConsultaSalvar()) {

            Pagamento pagamento = new Pagamento();

            pagamento.setCaixa(getCaixa());

            pagamento.setParcelas(new ArrayList<Parcela>());
            Consulta consulta = new Consulta();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String busca = formato.format(agendamento.getCalendario().getDate().getTime());
            consulta.setData(busca);
            consulta.setHora(cadastroConsultas.getCombohora().getSelectedItem().toString());

            consulta.setTipo(cadastroConsultas.getCombotipo().getSelectedItem().toString());
            consulta.setMedico(medico);
            consulta.setPaciente(paciente);
            consulta.setPagamento(pagamento);

            pagamento.setConsulta(consulta);

            if (medico != null && paciente != null) {
                fachada1.salvarConsulta(consulta);

            } else {
                JOptionPane.showMessageDialog(null, "Precisa-se escolher o Medico e o Paciente !!!");
            }

            preenchertabela();
            agendamento.setVisible(true);
            cadastroConsultas.setVisible(false);
            cadastroConsultas.getTxtPaciente().setText("");
            cadastroConsultas.getTxtconvenio().setText("");
            cadastroConsultas.getTxtmedico().setText("");
            cadastroConsultas.getTxtespecializacao().setText("");
        }

    }

    public void preenchertabela() {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String busca = formato.format(agendamento.getCalendario().getDate());
        consultas = fachada1.getPorBuscaConsulta(busca);
        agendamento.getTabelaAgendamento().setDefaultRenderer(Object.class, new Render());
        Icon editar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/editar.png"));
        Icon excluir = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/excluir.png"));
        Icon pagar = new ImageIcon(getClass().getResource("/br/com/fundamento/resource/pagar.png"));

        horas = new ArrayList<String>();

        btn1 = new JButton(editar);
        btn1.setName("m");
        btn1.setBorder(null);
        btn1.setContentAreaFilled(false);

        btn2 = new JButton(excluir);
        btn2.setName("e");
        btn2.setBorder(null);
        btn2.setContentAreaFilled(false);

        btn3 = new JButton(pagar);
        btn3.setName("p");
        btn3.setBorder(null);
        btn3.setContentAreaFilled(false);

        try {
            String[] colunas = new String[]{"Hora", "Tipo", "Paciente", "Medico", "Editar", "Excluir", "Pagar"};
            Object[][] dados = new Object[consultas.size()][7];
            for (int i = 0; i < consultas.size(); i++) {
                Consulta consulta = consultas.get(i);

                dados[i][0] = consulta.getHora();
                dados[i][1] = consulta.getTipo();
                dados[i][2] = consulta.getPaciente().getNome();
                dados[i][3] = consulta.getMedico().getNome();
                dados[i][4] = btn1;
                dados[i][5] = btn2;
                dados[i][6] = btn3;

                horasMarcados.add(consulta.getHora());

            }

            DefaultTableModel dataModel = new DefaultTableModel(dados, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            TableColumnModel columnModel = agendamento.getTabelaAgendamento().getColumnModel();
            agendamento.getTabelaAgendamento().setModel(dataModel);
            agendamento.getTabelaAgendamento().setPreferredScrollableViewportSize(agendamento.getTabelaAgendamento().getPreferredSize());

        } catch (Exception ex) {

        }
    }

    public void PreencherBuscaPaciente() {

        pacientes = fachada1.getPorBusca(cadastroConsultas.getTxtPaciente().getText());

        DefaultListModel model = new DefaultListModel();
        for (Paciente p : pacientes) {

            model.addElement(p.getNome());
        }

        cadastroConsultas.getListPaciente().setModel(model);
        cadastroConsultas.getListPaciente().setVisible(true);

    }

    public void PreencherBuscaMedico(CadastroConsultas cadastroConsultas) {

        medicos = fachada1.getPorBuscaMedico(cadastroConsultas.getTxtmedico().getText());

        DefaultListModel model = new DefaultListModel();
        for (Medico m : medicos) {
            model.addElement(m.getNome());
        }

        cadastroConsultas.getListaMedico().setModel(model);
        cadastroConsultas.getListaMedico().setVisible(true);
    }

    public void preencherCadastro(Consulta c, CadastroConsultas cc) {

        Paciente pa = fachada1.buscarPacientePorId(c.getPaciente().getId());
        Medico me = fachada1.buscarMedicoPorId(c.getMedico().getId());

        cc.getTxtdata().setText(c.getData());

        for (int u = 0; u < cc.getCombotipo().getItemCount(); u++) {

            if (cc.getCombotipo().getItemAt(u).equals(c.getTipo())) {
                cc.getCombotipo().setSelectedItem(cc.getCombotipo().getItemAt(u));
            }
        }

        for (int u = 0; u < cc.getCombohora().getItemCount(); u++) {

            if (cc.getCombohora().getItemAt(u).equals(c.getTipo())) {
                cc.getCombohora().setSelectedItem(cc.getCombohora().getItemAt(u));
            }
        }

        cc.getBotaoadd().setVisible(false);
        cc.getListPaciente().setVisible(false);

        cc.getTxtconvenio().setText(pa.getConvenio());
        cc.getTxtPaciente().setText(pa.getNome());
        cc.getTxtconvenio().setEditable(false);
        cc.getTxtPaciente().setEditable(false);
        cc.getTxtmedico().setText(me.getNome());
        cc.getTxtespecializacao().setText(me.getEspecializacao().getDescricao());

    }

    public class Acaoupdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == cc.getBotaoConsultaSalvar()) {

                Consulta consulta = c;

                consulta.setHora(cc.getCombohora().getSelectedItem().toString());
                consulta.setTipo(cc.getCombotipo().getSelectedItem().toString());
                consulta.setMedico(medico);

                if (medico != null) {
                    fachada1.editarConsulta(consulta);
                    agendamento.setVisible(true);

                    cc.setVisible(false);

                    c = null;
                } else {
                    JOptionPane.showMessageDialog(null, " Escolha um medico");
                }
                preenchertabela();
                preencherHorarioDisponivel(cadastroConsultas); 
                
            }
        }

    }

    public static void abrirCaixa() {

        java.util.Date d = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        caixa = new DaoCaixa().buscarCaixaPorData(dStr);
        Caixa c = new DaoCaixa().buscarUltimoCaixa();
        if (caixa != null) {
            caixa.setFuncionario(funcionario);
            caixa.setStatus(true);
            valor = getCaixa().getValor_abertura();

        }

        if (getCaixa() == null) {

            caixa = new Caixa();

            getCaixa().setPagamentos(new ArrayList<Pagamento>());
            getCaixa().setData(dStr);
            getCaixa().setFuncionario(funcionario);
            getCaixa().setStatus(true);
            if (c != null) {
                caixa.setValor_abertura(c.getValor_fechamento());
                caixa.setValor_fechamento(c.getValor_fechamento());
            }

            id = fachada1.salvarCaixa(getCaixa());

            getCaixa().setId(id);
            valor = getCaixa().getValor_abertura();

        }

    }

    public void preencherHorarioDisponivel(CadastroConsultas cadastroConsultas) {

        if (horas.isEmpty()) {
            horas.add("07:00");
            horas.add("08:00");
            horas.add("09:00");
            horas.add("10:00");
            horas.add("11:00");
            horas.add("12:00");
            horas.add("13:00");
            horas.add("14:00");
            horas.add("15:00");
            horas.add("16:00");
            horas.add("17:00");
            horas.add("18:00");
        }

        cadastroConsultas.getCombohora().removeAllItems();

        List<String> hDisponivel = new ArrayList<String>();

        for (int i = 0; i < horas.size(); i++) {
            boolean disponivel = true;
            for (int j = 0; j < horasMarcados.size(); j++) {
                if ((horas.get(i).equals(horasMarcados.get(j)))) {
                    disponivel = false;
                }
            }

            if (disponivel) {
                hDisponivel.add(horas.get(i));
            }

        }

        for (int u = 0; u < hDisponivel.size(); u++) {
            cadastroConsultas.getCombohora().addItem(hDisponivel.get(u));

        }

    }

    /**
     * @return the funcionario
     */
    public static Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param aFuncionario the funcionario to set
     */
    public static void setFuncionario(Funcionario aFuncionario) {
        funcionario = aFuncionario;
    }

    /**
     * @return the caixa
     */
    public static Caixa getCaixa() {
        return caixa;
    }

}
