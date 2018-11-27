/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Medico;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessMedico {
    
    public void salvarMedico(Medico medico);
    public Medico buscarMedicoPorId(int id);
    public List<Medico> getAllMedico();
    public void editarMedico(Medico medico);
    public void ativarDesativarMedico(int id);
     public List<Medico> getPorBuscaMedico(String busca);
    
}
