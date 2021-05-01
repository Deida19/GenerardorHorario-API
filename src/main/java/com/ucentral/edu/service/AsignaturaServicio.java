package com.ucentral.edu.service;

import java.util.List;

import com.ucentral.edu.entities.Asignatura;

public interface AsignaturaServicio {

	public Asignatura asignaturaXId(Integer id);
	public List<Asignatura> asignaturaXPlanEstudio(Integer planEstudio);
	public List<Asignatura> asignaturaPendEstudiante(Integer idEstudiante);
	
}
