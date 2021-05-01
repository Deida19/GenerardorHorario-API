package com.ucentral.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucentral.edu.dao.GrupoDAO;
import com.ucentral.edu.entities.Grupo;

@Service
public class GrupoServiceImplem implements GrupoServicio{

	@Autowired
	public GrupoDAO grupoDAO;
	
	@Override
	public List<Grupo> findbyAsignatura(Integer idAsignatura) {

		List<Grupo> lstGrupos = grupoDAO.gruposXAsignatura(idAsignatura);
		return lstGrupos;
		
	}

}
