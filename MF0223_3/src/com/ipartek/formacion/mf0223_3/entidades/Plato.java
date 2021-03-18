package com.ipartek.formacion.mf0223_3.entidades;

import java.util.Set;

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
public class Plato {
	
	private long id;
	private String nombre_plato;
	private int calorias;
	private String elaboracion;
	private String dificultad;
	
	private Categoria categoria;
	private Origen procedencia;

}
