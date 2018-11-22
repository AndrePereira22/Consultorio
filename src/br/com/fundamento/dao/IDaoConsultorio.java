/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.dao;

import br.com.fundamento.modelos.Consultorio;
import java.util.List;

/**
 *
 * @author Glenda Alves de Lima
 */
public interface IDaoConsultorio {
    
    public int salvarConsultorio(Consultorio consultorio);
    public Consultorio buscarConsultorioPorId(int id);
    public List<Consultorio> getAllConsultorio();
    public void editarConsultorio(Consultorio consultorio);
    public void ativarDesativarConsultorio(int id);
    
}
