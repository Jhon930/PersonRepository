package com.project.client.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="personas")
public class Persona {
	
	@Id
	private String id;
	private String nombre;
	private String apellido;
	private String dni;
	
	public String getId() {
		return id;
	}
	public void setId(String objectId) {
		this.id = objectId;
	}
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
