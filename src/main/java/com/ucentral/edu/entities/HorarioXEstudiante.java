package com.ucentral.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HorariosXEstudiante",schema = "dbo")
public class HorarioXEstudiante {

	@Id
	@Column(name="idHorarioxEstudiante")
	public Integer idHorarioEstudiante;
	
	@Column(name="idEstudiante")
	public Integer idEstudiante;
	
	@Column(name="idOpcionHorario")
	public Integer idOpcionHorario;
	
	@Column(name="idMateria")
	public Integer idMateria;
	
	@Column(name="idGrupo")
	public Integer idGrupo;
	
	@Column(name="idHorario")
	public Integer idHorario;
	
	
	
	public HorarioXEstudiante() {
		super();
	}


	public HorarioXEstudiante(Integer idHorarioEstudiante, Integer idEstudiante, Integer idOpcionHorario,
			Integer idMateria, Integer idGrupo, Integer idHorario) {
		super();
		this.idHorarioEstudiante = idHorarioEstudiante;
		this.idEstudiante = idEstudiante;
		this.idOpcionHorario = idOpcionHorario;
		this.idMateria = idMateria;
		this.idGrupo = idGrupo;
		this.idHorario = idHorario;
	}


	public Integer getIdHorarioEstudiante() {
		return idHorarioEstudiante;
	}


	public void setIdHorarioEstudiante(Integer idHorarioEstudiante) {
		this.idHorarioEstudiante = idHorarioEstudiante;
	}


	public Integer getIdEstudiante() {
		return idEstudiante;
	}


	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}


	public Integer getIdOpcionHorario() {
		return idOpcionHorario;
	}


	public void setIdOpcionHorario(Integer idOpcionHorario) {
		this.idOpcionHorario = idOpcionHorario;
	}


	public Integer getIdMateria() {
		return idMateria;
	}


	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}


	public Integer getIdGrupo() {
		return idGrupo;
	}


	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}


	public Integer getIdHorario() {
		return idHorario;
	}


	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}
	
	
}
