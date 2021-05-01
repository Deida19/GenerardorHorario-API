package com.ucentral.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Horario",schema = "dbo")
public class Horario {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="dia")
	private Integer dia;
	
	@Column(name="hora_Inicio")
	private String hora_Inicio;
	
	@Column(name="hora_Fin")
	private String hora_Fin;
	
	@Column(name="id_Grupo")
	private Integer id_Grupo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getHora_Inicio() {
		return hora_Inicio;
	}

	public void setHora_Inicio(String hora_Inicio) {
		this.hora_Inicio = hora_Inicio;
	}

	public String getHora_Fin() {
		return hora_Fin;
	}

	public void setHora_Fin(String hora_Fin) {
		this.hora_Fin = hora_Fin;
	}

	public Integer getId_Grupo() {
		return id_Grupo;
	}

	public void setId_Grupo(Integer id_Grupo) {
		this.id_Grupo = id_Grupo;
	}
	
	
}
