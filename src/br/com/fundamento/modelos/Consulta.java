/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.modelos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Glenda Alves de Lima
 */
public class Consulta {

    private Calendar data_hora;
    private String tipo;
    private boolean agendamento;

    private Medico medico;
    private Paciente paciente;
    private Pagamento pagamento;
    private Consultorio consultorio;
    
    

    public Consulta() {
         data_hora = Calendar.getInstance();

    }
    
    public String getDate_horsString(){
        String d =  this.data_hora.get(Calendar.DAY_OF_MONTH) +"/"+ this.data_hora.get(Calendar.MONTH)+"/"+this.data_hora.get(Calendar.YEAR)+ "    "+ this.data_hora.get(Calendar.HOUR) + ":" + this.data_hora.get(Calendar.MINUTE);
        return d;
    }
    
     public void setDate_horaInt(int dia,int mes, int ano,int hora, int minute) {
         this.data_hora.set(ano, mes, dia,hora, minute);

    }
 public void setDate_horaString(String date) {
     
     String dia = date.substring(0, 2); 
     int d = Integer.parseInt(dia);
     String mes = date.substring(3, 5); 
     int m = Integer.parseInt(mes);
     String ano = date.substring(6, 10); 
     int a = Integer.parseInt(ano);
     
         this.data_hora.set(a, m, d,0, 0);

    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the agendamento
     */
    public boolean isAgendamento() {
        return agendamento;
    }

    /**
     * @param agendamento the agendamento to set
     */
    public void setAgendamento(boolean agendamento) {
        this.agendamento = agendamento;
    }

  
    /**
     * @return the medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    /**
     * @return the pagamento
     */
    public Pagamento getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the consultorio
     */
    public Consultorio getConsultorio() {
        return consultorio;
    }

    /**
     * @param consultorio the consultorio to set
     */
    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
}
