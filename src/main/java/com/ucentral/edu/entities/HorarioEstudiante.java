package com.ucentral.edu.entities;

import java.util.List;

public class HorarioEstudiante {
	
	public Integer id;
	public String codigo;
	public String nombre;
	public Integer creditos;
	public Integer horas;
	public String topologia;
	public Integer planEstudio;
	public List<GrupoHorario> lstGrupo;
	
	
	
	public HorarioEstudiante() {
		super();
	}

	public HorarioEstudiante(Integer id, String codigo, String nombre, Integer creditos, Integer horas,
			String topologia, Integer planEstudio, List<GrupoHorario> lstGrupo) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.horas = horas;
		this.topologia = topologia;
		this.planEstudio = planEstudio;
		this.lstGrupo = lstGrupo;
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
	public Integer getCreditos() {
		return creditos;
	}
	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public String getTopologia() {
		return topologia;
	}
	public void setTopologia(String topologia) {
		this.topologia = topologia;
	}
	public Integer getPlanEstudio() {
		return planEstudio;
	}
	public void setPlanEstudio(Integer planEstudio) {
		this.planEstudio = planEstudio;
	}
	public List<GrupoHorario> getLstGrupo() {
		return lstGrupo;
	}
	public void setLstGrupo(List<GrupoHorario> lstGrupo) {
		this.lstGrupo = lstGrupo;
	}
	
	
	

}
