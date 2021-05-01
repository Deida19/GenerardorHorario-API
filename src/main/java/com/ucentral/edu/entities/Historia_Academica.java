package com.ucentral.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Historia_Academica",schema = "dbo")
public class Historia_Academica {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="anio")
	private Integer anio;
	
	@Column(name="periodo")
	private Integer periodo;
	
	@Column(name="nota")
	private float nota;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="id_Estudiante")
	private Integer id_Estudiante;
	
	@Column(name="id_Asignatura")
	private Integer id_Asignatura;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId_Estudiante() {
		return id_Estudiante;
	}

	public void setId_Estudiante(Integer id_Estudiante) {
		this.id_Estudiante = id_Estudiante;
	}

	public Integer getId_Asignatura() {
		return id_Asignatura;
	}

	public void setId_Asignatura(Integer id_Asignatura) {
		this.id_Asignatura = id_Asignatura;
	}
	
	
}
