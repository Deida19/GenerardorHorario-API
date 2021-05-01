package com.ucentral.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ucentral.edu.entities.Horario;

@Repository
public class HorarioDaoImplem implements HorarioDAO{

	@Autowired
	private EntityManager entitymng;
	
	@Override
	public List<Horario> horarioByGrupo(Integer id_Grupo) {
		Session currentSession = entitymng.unwrap(Session.class);
		Query<Horario> theQuery = currentSession.createQuery("FROM Horario WHERE id_Grupo =:idGrupo", Horario.class);
		theQuery.setParameter("idGrupo", id_Grupo);
		
		List<Horario> lstHorario = theQuery.getResultList();
		
		return lstHorario;
	}

}
