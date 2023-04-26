package org.caucotafederico.models;

public class Peso {
	private Double valor;
	private String unidadMedida;
	public Peso(Double valorPeso, String unidadMedida) {
		this.valor = valorPeso;
		this.unidadMedida = unidadMedida;
	}
	public final Double getValor() {
		return valor;
	}
	public final void setValor(Double valor) {
		this.valor = valor;
	}
	public final String getUnidadMedida() {
		return unidadMedida;
	}
	public final void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
