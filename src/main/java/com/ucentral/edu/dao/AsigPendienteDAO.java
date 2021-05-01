package com.ucentral.edu.dao;

import java.util.List;

import com.ucentral.edu.entities.Asignatura;

public interface AsigPendienteDAO {
	
	public Asignatura asignaturaXId(Integer id);
	public List<Asignatura> asignaturaXPlanEstudio(Integer planEstudio);
	public List<Asignatura> asignaturaPendEstudiante(Integer idEstudiante);

}
