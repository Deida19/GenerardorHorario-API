package com.ucentral.edu.dao;
import java.util.List;

import com.ucentral.edu.entities.Estudiante;

public interface Estudiante2DAO {
	
	public List<Estudiante> findbydocumento(String documento);

}
