package org.caucotafederico.models;

import java.time.LocalDate;


public class Oferta {
	private int codigo;
	private Producto producto;
	private Descuento descuento;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	
	public Oferta(int codigoOferta, LocalDate fDesde, LocalDate fHasta) {
		this.codigo = codigoOferta;
		this.fechaDesde = fDesde;
		this.fechaHasta = fHasta;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public final Producto getProducto() {
		return producto;
	}

	public final void setProducto(Producto producto) {
		this.producto = producto;
	}

	public final Descuento getDescuento() {
		return descuento;
	}

	public final void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public final LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public final void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public final LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public final void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
}
