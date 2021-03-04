package com.ipartek.formacion.ejemplofinal.logicanegocio;

public class FabricaNegocio {
	private FabricaNegocio() {}
	
	private static CarritoNegocio carritoNegocio = new CarritoNegocioImpl();
	
	public CarritoNegocio getCarritoNegocio() {
		return carritoNegocio;
	}

}
