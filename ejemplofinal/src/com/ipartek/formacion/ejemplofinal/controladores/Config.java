package com.ipartek.formacion.ejemplofinal.controladores;

import com.ipartek.formacion.ejemplofinal.logicanegocio.CarritoNegocio;
import com.ipartek.formacion.ejemplofinal.logicanegocio.FabricaNegocio;

public class Config {

	public static Object clienteNegocio;
	private Config() {}
	
	static final String PATH_VISTAS = "/WEB-INF/vistas/";
	static final CarritoNegocio carritoNegocio = FabricaNegocio.getCarritoNegocio();
	static final ClienteNegocio clienteNegocio = FabricaNegocio.getClienteNegocio();
	
	
}
