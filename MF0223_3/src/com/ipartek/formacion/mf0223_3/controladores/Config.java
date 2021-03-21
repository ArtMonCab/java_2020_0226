package com.ipartek.formacion.mf0223_3.controladores;

import com.ipartek.formacion.mf0223_3.logicanegocio.CategoriaNegocio;
import com.ipartek.formacion.mf0223_3.logicanegocio.FabricaNegocio;
import com.ipartek.formacion.mf0223_3.logicanegocio.OrigenNegocio;
import com.ipartek.formacion.mf0223_3.logicanegocio.PlatoNegocio;

/**
 * Configuraci�n gesti�n de la f�brica
 * 
 * @author Arturo Monta�ez
 * @version 1.0
 */
public class Config {
	
	static final String PATH_VISTAS = "/WEB-INF/vistas/";
	static final PlatoNegocio platoNegocio = FabricaNegocio.getPlatoNegocio();
	static final CategoriaNegocio categoriaNegocio = FabricaNegocio.getCategoriaNegocio();
	static final OrigenNegocio origenNegocio = FabricaNegocio.getOrigenNegocio();

}
