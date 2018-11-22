/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.business;

import br.com.fundamento.modelos.Consulta;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IBusinessConsulta {
    
    public void salvarConsulta(Consulta consulta);
    public Consulta buscarConsultaPorId(int id);
    public List<Consulta> getAllConsulta();
    public void editarConsulta(Consulta consulta);
    public void ativarDesativarConsulta(int id);
    
}
