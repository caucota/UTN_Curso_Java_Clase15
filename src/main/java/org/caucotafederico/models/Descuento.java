package org.caucotafederico.models;

public class Descuento {
	private String tipo;
	private Double cantidad;
	private Double tope;
	
	public Descuento() {
		this.tipo = "";
		this.cantidad = 0.0;
		this.tope = 0.0;
	}

	public final String getTipo() {
		return tipo;
	}

	public final void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public final Double getCantidad() {
		return cantidad;
	}

	public final void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public final Double getTope() {
		return tope;
	}

	public final void setTope(Double tope) {
		this.tope = tope;
	}
}
