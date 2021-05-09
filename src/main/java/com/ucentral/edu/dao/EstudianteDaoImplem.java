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

	@Override
	public Estudiante autenticacion(String usuario, String password) {
		
		Estudiante est = new Estudiante();
		Session currentSession = entitymng.unwrap(Session.class);
		Query<Estudiante> theQuery = currentSession.createQuery("FROM Estudiante WHERE USUARIO =:user and password =:password", Estudiante.class);
		theQuery.setParameter("user", usuario);
		theQuery.setParameter("password", password);
		
		est.setApellido(theQuery.getSingleResult().getApellido());
		est.setCorreo(theQuery.getSingleResult().getCorreo());
		est.setId(theQuery.getSingleResult().getId());
		est.setId_Plan_Estudio(theQuery.getSingleResult().getId_Plan_Estudio());
		est.setIdentificacion(theQuery.getSingleResult().getIdentificacion());
		est.setNombre(theQuery.getSingleResult().getNombre());
		est.setPass("");
		est.setSexo(theQuery.getSingleResult().getSexo());
		est.setUser(theQuery.getSingleResult().getUser());
		return est;
	}

}
