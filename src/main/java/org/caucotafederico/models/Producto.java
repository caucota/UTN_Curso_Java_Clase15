package org.caucotafederico.models;

public class Producto {
	private String nombre;
	private Peso peso;
	private Double precio;
	
	public Producto() {
		this.nombre = "";
		this.peso = new Peso((double) 0, "");
		this.precio = 0.0;		
	}

	public final String getNombre() {
		return nombre;
	}

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public final Peso getPeso() {
		return peso;
	}

	public final void setPeso(Peso peso) {
		this.peso = peso;
	}

	public final Double getPrecio() {
		return precio;
	}

	public final void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	

	

}
