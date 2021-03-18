package com.ipartek.formacion.mf0223_3.entidades;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las procedencias
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class Procedencia {

	private long id;
	private String nombre_procedencia;
	
	private Set<Plato> comida;
}
