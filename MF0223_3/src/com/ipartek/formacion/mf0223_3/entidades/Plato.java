package com.ipartek.formacion.mf0223_3.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa los platos
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

@Data @NoArgsConstructor @AllArgsConstructor
public class Plato implements Serializable{
	
	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = 5044856769230830320L;
	
	private long id;
	private String nombre_plato;
	private int calorias;
	private String elaboracion;
	private String dificultad;
	
	private Categoria categoria;
	private Origen origen;

}
