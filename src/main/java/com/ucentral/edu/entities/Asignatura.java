package com.ucentral.edu.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Asignatura",schema = "dbo")

public class Asignatura{

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="creditos")
	private Integer creditos;
	
	@Column(name="cant_Hora_Semana")
	private Integer cant_Hora_Semana;
	
	@Column(name="tipologia")
	private String tipologia;
	
	@Column(name="nombre_Profesor")
	private String nombre_Profesor;
	
	@Column(name="id_Plan_Estudio")
	private Integer id_Plan_Estudio;

	
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

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getCant_Hora_Semana() {
		return cant_Hora_Semana;
	}

	public void setCant_Hora_Semana(Integer cant_Hora_Semana) {
		this.cant_Hora_Semana = cant_Hora_Semana;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getNombre_Profesor() {
		return nombre_Profesor;
	}

	public void setNombre_Profesor(String nombre_Profesor) {
		this.nombre_Profesor = nombre_Profesor;
	}

	public Integer getId_Plan_Estudio() {
		return id_Plan_Estudio;
	}

	public void setId_Plan_Estudio(Integer id_Plan_Estudio) {
		this.id_Plan_Estudio = id_Plan_Estudio;
	}

	

	
}

