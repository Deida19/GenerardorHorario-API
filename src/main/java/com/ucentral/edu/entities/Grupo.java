package com.ucentral.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Grupo",schema = "dbo")

public class Grupo {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="capacidad")
	private Integer capacidad;

	@Column(name="id_Asignatura")
	private Integer id_Asignatura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getId_Asignatura() {
		return id_Asignatura;
	}

	public void setId_Asignatura(Integer id_Asignatura) {
		this.id_Asignatura = id_Asignatura;
	}
	
	
}
