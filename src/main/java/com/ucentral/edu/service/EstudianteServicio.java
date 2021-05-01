package com.ucentral.edu.service;

import java.util.List;

import com.ucentral.edu.entities.Estudiante;

public interface EstudianteServicio {

	public List<Estudiante> findbydocumento(String documento);
}
