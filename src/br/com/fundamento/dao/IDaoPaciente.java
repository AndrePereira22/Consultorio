/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;


import br.com.fundamento.modelos.Paciente;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoPaciente {
    
    public int salvarPaciente(Paciente paciente);
    public Paciente buscarPacientePorId(int id);
    public List<Paciente> getAllPaciente();
    public void editarPaciente(Paciente paciente);
    public void ativarDesativarPaciente(int id);
    public List<Paciente> getPorBusca(String busca);
     public Paciente buscarPaciente(String busca) ;
}
