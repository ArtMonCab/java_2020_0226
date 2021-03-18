package com.ipartek.formacion.mf0223_3.accesodatos;

/**
 * Captura las excepciones y lanza el mensaje
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class AccesoDatosException extends RuntimeException{

	/**
	 * Necesario para los elementos serializables
	 */
	private static final long serialVersionUID = -5040675178585431785L;

	/**
	 * Constructor AccesoDatosException
	 */
	public AccesoDatosException() {
		super();
	}
	
	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param message Mensaje que se va a enviar
	 * @param cause Causa de la excepción
	 * @param enableSuppression Habilitar borrado
	 * @param writableStackTrace Permiso de escritura
	 */
	public AccesoDatosException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param message MEnsaje que se va a enviar
	 * @param cause Causa de la excepción
	 */
	public AccesoDatosException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor AccedoDatosException con parametros
	 * 
	 * @param message mensaje que se va a enviar
	 */
	public AccesoDatosException(String message) {
		super(message);
	}
	
	/**
	 * Constructor AccesoDatosException con parametros
	 * 
	 * @param cause Causa de la excepción
	 */
	public AccesoDatosException(Throwable cause) {
		super(cause);
	}
	
	

}
