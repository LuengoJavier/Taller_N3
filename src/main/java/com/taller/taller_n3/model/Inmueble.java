package com.taller.taller_n3.model;

public class Inmueble {
	private int id;
	private String tipoConstruccion;
	private String ubicacion;
	private int precio;

	public Inmueble(int id, String tipoConstruccion, String ubicacion, int precio) {
		this.id = id;
		this.tipoConstruccion = tipoConstruccion;
		this.ubicacion = ubicacion;
		this.precio = precio;
	}

	public String getTipoConstruccion() {
		return this.tipoConstruccion;
	}

	public void setTipoConstruccion(String tipoConstruccion) {
		this.tipoConstruccion = tipoConstruccion;
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