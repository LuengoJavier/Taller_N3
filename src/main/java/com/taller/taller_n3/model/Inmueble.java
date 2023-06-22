package com.taller.taller_n3.model;

public class Inmueble {
	private int id;
	private String tipoConstruccion;
	private String ubicacion;
	private String ciudad;
	private int precio;

	public Inmueble(int id, String tipoConstruccion, String ciudad, String ubicacion, int precio) {
		this.id = id;
		this.tipoConstruccion = tipoConstruccion;
		this.ciudad = ciudad;
		this.ubicacion = ubicacion;
		this.precio = precio;
	}

	public String getTipoConstruccion() {
		return this.tipoConstruccion;
	}

	public void setTipoConstruccion(String tipoConstruccion) {
		this.tipoConstruccion = tipoConstruccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}