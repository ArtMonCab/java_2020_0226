package com.ipartek.formacion.mf0223_3.entidades;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa los origenes
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Origen implements Serializable{

	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = 7394098699332919489L;
	
	private long id;
	private String nombre_origen;
	
	private Set<Plato> comida;
}
