package com.ipartek.formacion.mf0223_3.controladores;

import com.ipartek.formacion.mf0223_3.logicanegocio.FabricaNegocio;
import com.ipartek.formacion.mf0223_3.logicanegocio.PlatoNegocio;

/**
 * Configuración gestión de la fabrica
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class Config {
	
	static final String PATH_VISTAS = "/WEB-INF/vistas/";
	static final PlatoNegocio platoNegocio = FabricaNegocio.getPlatoNegocio();

}
