package com.ucentral.edu.service;

import java.util.List;

import com.ucentral.edu.entities.HorarioEstudiante;
import com.ucentral.edu.entities.HorarioXEstudiante;
import com.ucentral.edu.entities.opcHorarioXEstudiante;
import com.ucentral.edu.entities.opcionHorario;
import com.ucentral.edu.entities.opcionesHorario2;

public interface HorarioEstudianteServicio {

	public List<HorarioEstudiante> getMateriasEstudiante(Integer idEstudiante);
	public List<HorarioEstudiante> getMateriasJornada(Integer idEstudiante, Integer jornada);
	public List<opcHorarioXEstudiante>  horarioEstudiante(Integer idEstudiante, Integer jornada);
	public List<List<HorarioEstudiante>>  horarioEstudiantes(Integer idEstudiante, Integer jornada);
}
