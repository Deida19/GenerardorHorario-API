package com.ucentral.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Requisito",schema = "dbo")
public class Requisito {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="id_Asignatura")
	private Integer id_Asignatura;
	
	@Column(name="id_requisito")
	private Integer id_requisito;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_Asignatura() {
		return id_Asignatura;
	}

	public void setId_Asignatura(Integer id_Asignatura) {
		this.id_Asignatura = id_Asignatura;
	}

	public Integer getId_requisito() {
		return id_requisito;
	}

	public void setId_requisito(Integer id_requisito) {
		this.id_requisito = id_requisito;
	}

	
}
