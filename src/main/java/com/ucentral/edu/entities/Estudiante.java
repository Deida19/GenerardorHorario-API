package com.ucentral.edu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estudiante",schema = "dbo")
public class Estudiante {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="identificacion")
	private String identificacion;
	
	@Column(name="sexo")
	private char sexo;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="usuario")
	private String user;
	
	@Column(name="password")
	private String Pass;
	
	@Column(name="id_Plan_Estudio")
	private Integer id_Plan_Estudio;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Integer getId_Plan_Estudio() {
		return id_Plan_Estudio;
	}
	public void setId_Plan_Estudio(Integer id_Plan_Estudio) {
		this.id_Plan_Estudio = id_Plan_Estudio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
	

}
