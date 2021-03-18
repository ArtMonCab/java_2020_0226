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
	 * @param message Mensaje que le vamos a pasar
	 * @param cause Causa de la excepción
	 * @param enableSuppression Habilitar borrado
	 * @param writableStackTrace Escribir traza
	 */
	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param message Mensaje que le vamos a pasar
	 * @param cause Causa de la excepción
	 */
	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor AccedoDatosException con parametros
	 * 
	 * @param message Mensaje 	que le vamso a pasar
	 */
	public AccesoDatosException(String message) {
		super(message);
	}
	
	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param cause Causa de la Excepción
	 */
	public AccesoDatosException(Throwable cause) {
		super(cause);
	}
	
	

}
