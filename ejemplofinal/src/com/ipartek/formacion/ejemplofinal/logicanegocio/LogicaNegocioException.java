package com.ipartek.formacion.ejemplofinal.logicanegocio;

/**
 * Clase donde se gestionan las excepciones de la lógica de negocio.
 * 
 * @author Arturo Montañez
 * @version 1.o
 */
public class LogicaNegocioException extends RuntimeException{

	
	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = -6177389577332893172L;


	/**
	 * Constructor LogicaNegocioException sin parametros
	 */
	public LogicaNegocioException() {
		super();
	}

	/**
	 * Constructor LogicaNegocioException con parametros
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LogicaNegocioException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor LogicaNegocioException con parametros
	 * 
	 * @param message
	 * @param cause
	 */
	public LogicaNegocioException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor LogicaNegocioException con parametros
	 * 
	 * @param message
	 */
	public LogicaNegocioException(String message) {
		super(message);
	}

	/**
	 * Constructor LogicaNegocioException con parametros
	 * 
	 * @param cause
	 */
	public LogicaNegocioException(Throwable cause) {
		super(cause);
	}
	
	

}
