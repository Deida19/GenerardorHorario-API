package com.ucentral.edu.dao;


import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ucentral.edu.entities.Requisito;

@Repository
public class RequisitoDaoImplem implements RequisitoDAO {

	@Autowired
	private EntityManager entitymng;
	
	@Override
	public Requisito requisitoXAsignatura(Integer id) {

		Session currentSession = entitymng.unwrap(Session.class);
		Query<Requisito> theQuery = currentSession.createQuery("FROM Requisito WHERE id_Asignatura =:id", Requisito.class);
		theQuery.setParameter("id", id);
		
		Requisito requisito = theQuery.getSingleResult();
		
		return requisito;
	}

}
