package com.ucentral.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucentral.edu.dao.Estudiante2DAO;
import com.ucentral.edu.entities.Estudiante;

@Service
public class EstudianteServiceImplem implements EstudianteServicio{

	@Autowired
	public Estudiante2DAO estuDAO;
	
	@Override
	public List<Estudiante> findbydocumento(String documento) {
		// TODO Auto-generated method stub
		List<Estudiante> listEstu = estuDAO.findbydocumento(documento);
		return listEstu;
	}

}
