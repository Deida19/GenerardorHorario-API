package com.ucentral.edu.entities;

import java.util.List;

public class infOpcHorario {

	private int id;
	private List<infMateria> lstInfMateria;
	
	public infOpcHorario() {
		super();
	}

	public infOpcHorario(int id, List<infMateria> lstInfMateria) {
		super();
		this.id = id;
		this.lstInfMateria = lstInfMateria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<infMateria> getLstInfMateria() {
		return lstInfMateria;
	}

	public void setLstInfMateria(List<infMateria> lstInfMateria) {
		this.lstInfMateria = lstInfMateria;
	}
	
	
	
	
}
