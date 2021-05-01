package com.ucentral.edu.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ucentral.edu.entities.Estudiante;

@Repository
public class EstudianteCustomImpl implements EstudianteRepositorioCustom{

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public Integer autent(String user, String pass) {
		
		Query query = entityManager.createNativeQuery("SELECT ID FROM dbo.Estudiante WHERE ususario = ? AND password = ?", Estudiante.class);
		query.setParameter(1, user);
		query.setParameter(2, pass);
		
		return query.getFirstResult();

	}

}
