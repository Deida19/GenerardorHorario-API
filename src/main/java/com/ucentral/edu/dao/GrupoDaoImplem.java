package com.ucentral.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucentral.edu.entities.Grupo;

@Repository
public class GrupoDaoImplem implements GrupoDAO{

	@Autowired
	private EntityManager entitymng;
	
	
	@Override
	public List<Grupo> gruposXAsignatura(Integer id_Asignatura) {
		Session currentSession = entitymng.unwrap(Session.class);
		Query<Grupo> theQuery = currentSession.createQuery("FROM Grupo WHERE id_Asignatura =:idAsignatura", Grupo.class);
		theQuery.setParameter("idAsignatura", id_Asignatura);
		
		List<Grupo> lstGrupo = theQuery.getResultList();
		
		return lstGrupo;
	}

}
