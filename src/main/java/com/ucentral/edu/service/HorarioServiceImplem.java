package com.ucentral.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucentral.edu.dao.HorarioDAO;
import com.ucentral.edu.entities.Horario;

@Service
public class HorarioServiceImplem implements HorarioServicio{

	@Autowired
	public HorarioDAO horarioDAO;
	
	@Override
	public List<Horario> findbyGrupo(Integer idGrupo) {
		List<Horario> lstHorario = horarioDAO.horarioByGrupo(idGrupo);
		return lstHorario;
	}

}
