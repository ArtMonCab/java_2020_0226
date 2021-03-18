package com.ipartek.formacion.mf0223_3.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las alertas de la aplicaci�n cuando introducimos un usuario
 * 
 * @author Arturo Monta�ez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Alerta implements Serializable{
	 
	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = 4718434984524239877L;
	
	private String nivel;
	private String mensaje;	
	
}
