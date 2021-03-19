package com.ipartek.formacion.mf0223_3.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.mf0223_3.entidades.Plato;

/**
 * Interfaz donde se declaran los métodos de PlatoNegocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public interface PlatoNegocio {

	Iterable<Plato> listadoPlatos();
	
	Plato agregarPlato(Plato plato);
}
