package com.ucentral.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucentral.edu.dao.HorarioXEstudianteDAO;
import com.ucentral.edu.entities.HorarioXEstudiante;


@Service
public class HorarioXEstudianteImplem implements HorarioXEstudianteServicio{

	@Autowired
	public HorarioXEstudianteDAO horarioXEstu ;
	
	@Override
	public void horarioXEstudiante(HorarioXEstudiante horarioPorEstud) {

		 horarioXEstu.horarioByEstudiante(horarioPorEstud);
		
	}

}
