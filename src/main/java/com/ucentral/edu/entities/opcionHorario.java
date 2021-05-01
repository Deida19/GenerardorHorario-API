package com.ucentral.edu.entities;

import java.util.List;

public class opcionHorario {

	public Integer idMateria;
	public List<Horarios> horarios;
	
	public Integer getId() {
		return idMateria;
	}
	public void setId(Integer idMateria) {
		this.idMateria = idMateria;
	}
	public List<Horarios> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horarios> horarios) {
		this.horarios = horarios;
	}
	
	
}
