package com.ucentral.edu.entities;

import java.util.List;

public class GrupoHorario {

private Integer id;
	private String codigo;
	private String descripcion;
	private Integer capacidad;
	private Integer id_Asignatura;
	private List<Horario> horarios;
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
	public List<Horario> getHorarios() {
		return horarios;
	}
	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	
	
}
