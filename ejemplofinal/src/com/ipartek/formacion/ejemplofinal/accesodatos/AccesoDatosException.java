package com.ipartek.formacion.ejemplofinal.accesodatos;

/**
 * Captura las excepciones y lanza el mensaje
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class AccesoDatosException extends RuntimeException {
	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = -589652421709906693L;

	/**
	 * Constructor AccesoDatosException
	 */
	public AccesoDatosException() {
		super();
	}
	
	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param message
	 * @param cause
	 */
	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor AccedoDatosException con parametros
	 * 
	 * @param message
	 */
	public AccesoDatosException(String message) {
		super(message);
	}
	
	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param cause
	 */
	public AccesoDatosException(Throwable cause) {
		super(cause);
	}
	
	

}
