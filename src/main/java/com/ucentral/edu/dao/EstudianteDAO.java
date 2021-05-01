package com.ucentral.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ucentral.edu.entities.Estudiante;


@Repository
public interface EstudianteDAO  extends JpaRepository<Estudiante, Integer>{
	
	@Query
	(
			value="SELECT * FROM dbo.Estudiante where usuario = :filtro1",
			nativeQuery = true
	)
	Estudiante searchNativo(@Param("filtro1") String filtro1);
	
}
