package com.ucentral.edu.dao;

import java.util.List;

import com.ucentral.edu.entities.Horario;



public interface HorarioDAO {

	public List<Horario> horarioByGrupo(Integer id_Grupo);
}
