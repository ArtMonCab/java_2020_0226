package com.ipartek.formacion.ejemplofinal.logicanegocio;


public class FabricaNegocio {
	private FabricaNegocio() {}
	
	private static CarritoNegocio carritoNegocio = new CarritoNegocioImpl();
	private static ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
	
	public static CarritoNegocio getCarritoNegocio() {
		return carritoNegocio;
	}

	public static ClienteNegocio getClienteNegocio() {
		return clienteNegocio;
	}


}
