package com.ucentral.edu.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucentral.edu.entities.HorarioXEstudiante;

@Repository
public class HorarioXEstudianteDAOImplem implements HorarioXEstudianteDAO{

	@Autowired
	private EntityManager entitymng;



	@Override
	public void horarioByEstudiante(HorarioXEstudiante horEstudiante) {
		Session currentSession = entitymng.unwrap(Session.class);
		currentSession.merge(horEstudiante);
		
	}

}
