package com.novellius;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {
	private int id;
	private String nombre;
	
	@Autowired
	private Direccion direccion;
	
	//El principio de la practica sin clases de dependencia solo para sacar esta funcion
//	public void imprimirDireccion(){
//		System.out.println("Encino 201");
//	}
	
	//String to String
	@Override
	public String toString() {
		return "Administrador [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	//Constructor
	public Administrador() {
		super();
	}

	public Administrador(int id, String nombre, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
