package com.taller.taller_n3.model;

import java.util.ArrayList;

public class Inmobiliaria {
	private String nombre;
	private ArrayList<Inmueble> inmuebles;
	private ArrayList<Vendedor> vendedores;

	public Inmobiliaria(String nombre, ArrayList<Inmueble> inmuebles, ArrayList<Vendedor> vendedores) {
		this.nombre = nombre;
		this.inmuebles = new ArrayList<>();
		this.vendedores = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(ArrayList<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}
}