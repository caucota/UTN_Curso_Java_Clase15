package org.caucotafederico.exceptions;

@SuppressWarnings("serial")
public class NroColumnasInvalidoException extends Exception {
	private final String mensaje;

	public NroColumnasInvalidoException(int nroColumnasLeidas, int nroRenglonError) {
		this.mensaje = "Error: El archivo sólo puede tener 10 columnas. Cantidad actual de columnas "
				+ nroColumnasLeidas + " en el renglón " + nroRenglonError;
	}

	public String getMensaje() {
		return mensaje;
	}

}