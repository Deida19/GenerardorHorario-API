package com.ucentral.edu.dao;


import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepositorioCustom {
	
	Integer autent(String user, String pass);

}
