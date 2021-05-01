package com.ucentral.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucentral.edu.dao.AsigPendienteDAO;
import com.ucentral.edu.entities.Asignatura;

@Service
public class AsignaturaServiceImplem implements AsignaturaServicio{

	@Autowired
	public AsigPendienteDAO asignaturaDAO;
	
	@Override
	public Asignatura asignaturaXId(Integer id) {

		Asignatura asignatura = asignaturaDAO.asignaturaXId(id);
		return asignatura;
	}

	@Override
	public List<Asignatura> asignaturaXPlanEstudio(Integer planEstudio) {
		List<Asignatura> lstAsignaturaPlanEstudio = asignaturaDAO.asignaturaXPlanEstudio(planEstudio);
		return lstAsignaturaPlanEstudio;
	}

	@Override
	public List<Asignatura> asignaturaPendEstudiante(Integer idEstudiante) {
		List<Asignatura> lstAsignaturasEstudiante = asignaturaDAO.asignaturaPendEstudiante(idEstudiante);
		

		return lstAsignaturasEstudiante;
	}

}
