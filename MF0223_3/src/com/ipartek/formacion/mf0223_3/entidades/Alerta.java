package com.ipartek.formacion.mf0223_3.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las alertas de la aplicación cuando cargamos la base de datos
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Alerta implements Serializable{

	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = -2301041689109295005L;

	private String nivel;
	private String mensaje;	
}
