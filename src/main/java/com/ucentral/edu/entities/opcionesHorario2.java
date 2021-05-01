package com.ucentral.edu.entities;

public class opcionesHorario2 {

	public Integer id;
	public String codigo;
	public String nombre;
	public String lunes;
	public String martes;
	public String miercoles;
	public String jueves;
	public String viernes;
	public String sabado;
	
	
	
	
	public opcionesHorario2() {
		super();
	}
	
	
	
	public opcionesHorario2(Integer id, String codigo, String nombre, String lunes, String martes, String miercoles,
			String jueves, String viernes, String sabado) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.sabado = sabado;
	}



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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLunes() {
		return lunes;
	}
	public void setLunes(String lunes) {
		this.lunes = lunes;
	}
	public String getMartes() {
		return martes;
	}
	public void setMartes(String martes) {
		this.martes = martes;
	}
	public String getMiercoles() {
		return miercoles;
	}
	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}
	public String getJueves() {
		return jueves;
	}
	public void setJueves(String jueves) {
		this.jueves = jueves;
	}
	public String getViernes() {
		return viernes;
	}
	public void setViernes(String viernes) {
		this.viernes = viernes;
	}
	public String getSabado() {
		return sabado;
	}
	public void setSabado(String sabado) {
		this.sabado = sabado;
	}
	
	
}
