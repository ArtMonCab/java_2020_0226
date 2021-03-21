package com.ipartek.formacion.mf0223_3.entidades;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las categorias
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

@Data @NoArgsConstructor @AllArgsConstructor
public class Categoria {
	private long id;
	private String nombre_categoria;
	
	private Set<Plato> comida;
	
}
