package com.ipartek.formacion.mf0223_3.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.mf0223_3.entidades.Categoria;

/**
 * Interfaz donde se declaran los m�todos para CategoriaNegocio
 * 
 * @author Arturo Monta�ez
 * @version 1.0
 */

public interface CategoriaNegocio {
	
	Iterable<Categoria> listadoCategorias();

}
