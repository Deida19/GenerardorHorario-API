package com.ucentral.edu.dao;

import java.util.List;

import com.ucentral.edu.entities.Grupo;

public interface GrupoDAO {

	public List<Grupo> gruposXAsignatura(Integer id_Asignatura);
}
