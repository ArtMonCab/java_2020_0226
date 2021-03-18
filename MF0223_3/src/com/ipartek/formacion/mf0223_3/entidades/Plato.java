package com.ipartek.formacion.mf0223_3.entidades;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa las comidas
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

@Data @NoArgsConstructor @AllArgsConstructor
public class Comida {
	
	private long id;
	private String plato;
	private int calorias;
	private String elaboracion;
	private String dificultad;
	
	private Categoria categoria;
	private Procedencia procedencia;

}
