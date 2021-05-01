package com.ucentral.edu.entities;

import java.util.List;

public class opcHorarioXEstudiante {
	
	private int id;
	private List<opcionXMateria> opc;
	
	public opcHorarioXEstudiante() {
		super();
	}

	public opcHorarioXEstudiante(int id, List<opcionXMateria> opc) {
		super();
		this.id = id;
		this.opc = opc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<opcionXMateria> getOpc() {
		return opc;
	}

	public void setOpc(List<opcionXMateria> opc) {
		this.opc = opc;
	}
	

	
}
