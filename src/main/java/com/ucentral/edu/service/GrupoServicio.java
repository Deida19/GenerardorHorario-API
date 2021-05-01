package com.ucentral.edu.service;

import java.util.List;

import com.ucentral.edu.entities.Grupo;



public interface GrupoServicio {
	
	public List<Grupo> findbyAsignatura(Integer idAsignatura);

}
