package com.ucentral.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ucentral.edu.entities.Asignatura;
import com.ucentral.edu.entities.Requisito;

@Repository
public class AsigPendDaoImplen implements AsigPendienteDAO{

	@Autowired
	private EntityManager entitymng;
	
	@Override
	public Asignatura asignaturaXId(Integer id) {
		Session currentSession = entitymng.unwrap(Session.class);
		Query<Asignatura> theQuery = currentSession.createQuery("FROM Asignatura WHERE id =:idAsignatura", Asignatura.class);
		theQuery.setParameter("idAsignatura", id);
		
		Asignatura asignatura = theQuery.getSingleResult();
		
		return asignatura;
	}

	@Override
	public List<Asignatura> asignaturaXPlanEstudio(Integer planEstudio) {
		// TODO Auto-generated method stub
		Session currentSession = entitymng.unwrap(Session.class);
		Query<Asignatura> theQuery = currentSession.createQuery("FROM Asignatura WHERE id_Plan_Estudio =:id", Asignatura.class);
		theQuery.setParameter("id", planEstudio);
		
		List<Asignatura> asignaturasPorPlanEstudio= theQuery.getResultList();
		return asignaturasPorPlanEstudio;
	}

	@Override
	public List<Asignatura> asignaturaPendEstudiante(Integer idEstudiante) {

		List<Asignatura> asignaturasPorEstudiante = new ArrayList<Asignatura>();
	
				
		Session currentSession = entitymng.unwrap(Session.class);
		
		String strQuery2 = " FROM Asignatura A " +
				"WHERE NOT EXISTS (SELECT 'X' FROM Historia_Academica B WHERE B.id_Asignatura = A.id AND B.id_Estudiante =:idEstudiante) ";
		Query<Asignatura> theQuery = currentSession.createQuery(strQuery2, Asignatura.class);
		theQuery.setParameter("idEstudiante", idEstudiante);

		Integer resp = null;
		String strQueryRequisito = "from Requisito where id_Asignatura =:idAsignatura and exists (select 'x' from Historia_Academica where id_Asignatura = id_requisito and id_Estudiante =:idEstudiante)";
				
		for (Asignatura asig: theQuery.getResultList()) {
			Query<Requisito> theQuery2 = currentSession.createQuery(strQueryRequisito, Requisito.class);
			theQuery2.setParameter("idAsignatura", asig.getId().intValue());
			theQuery2.setParameter("idEstudiante", idEstudiante);
			
		
				resp = theQuery2.getResultList().size(); 
				if (resp != 0) {
					asignaturasPorEstudiante.add(asig);
				}
			
				
			
		}
		return asignaturasPorEstudiante;
	}

	

}
