package com.taller.taller_n3.model;

public class Vendedor {
	private String nombre;
	private String rut;
	private String direccion;
	private String titulo;
	private String estadoCvil;

	public Vendedor(String nombre, String rut, String direccion, String titulo, String estadoCvil) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.titulo = titulo;
		this.estadoCvil = estadoCvil;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstadoCvil() {
		return this.estadoCvil;
	}

	public void setEstadoCvil(String estadoCvil) {
		this.estadoCvil = estadoCvil;
	}
}