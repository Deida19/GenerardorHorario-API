package com.ucentral.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucentral.edu.entities.Estudiante;

@Repository
public class EstudianteDaoImplem implements Estudiante2DAO{

	@Autowired
	private EntityManager entitymng;
	
	@Override
	public List<Estudiante> findbydocumento(String documento) {
		// TODO Auto-generated method stub
		Session currentSession = entitymng.unwrap(Session.class);
		Query<Estudiante> theQuery = currentSession.createQuery("FROM Estudiante WHERE USUARIO =:idUser", Estudiante.class);
		theQuery.setParameter("idUser", documento);
		
		List<Estudiante> estud = theQuery.getResultList();
		
		return estud;
	}

}
