/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consulta;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoConsulta {
     
    public int salvarConsulta(Consulta consulta);
    public Consulta buscarConsultaPorId(int id);
    public List<Consulta> getAllConsulta();
    public void editarConsulta(Consulta consulta);
    public void ativarDesativarConsulta(int id);
      public List<Consulta> getPorBuscaConsulta(String busca);
    
}
