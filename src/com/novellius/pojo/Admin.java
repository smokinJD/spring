package com.novellius.pojo;

import java.sql.Timestamp;

public class Admin {
	private int id;
	private String nombre;
	private String cargo;
	private Timestamp fechaCreacion;
	
	//String to String
	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}

	//Getter and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
}