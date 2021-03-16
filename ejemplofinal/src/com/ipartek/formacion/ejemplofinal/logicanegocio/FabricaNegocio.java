package com.ipartek.formacion.ejemplofinal.logicanegocio;

/**
 * Clase donde se llama a las implementaciones de la lógica de negocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class FabricaNegocio {
	private FabricaNegocio() {}
	
	private static CarritoNegocio carritoNegocio = new CarritoNegocioImpl();
	private static ClienteNegocio clienteNegocio = new ClienteNegocioImpl();
	private static UsuarioNegocio usuarioNegocio = new UsuarioNegocioImpl();
	
	/**
	 * Método para obtener carritoNegocio
	 * 
	 * @return carritoNegocio
	 */
	public static CarritoNegocio getCarritoNegocio() {
		return carritoNegocio;
	}

	/**
	 * Método para obtener clienteNegocio
	 * 
	 * @return clienteNegocio
	 */
	public static ClienteNegocio getClienteNegocio() {
		return clienteNegocio;
	}

	/**
	 * Método para obtener usuarioNegocio
	 * 
	 * @return usuarioNegocio
	 */
	public static UsuarioNegocio getUsuarioNegocio() {
		return usuarioNegocio;
	}


}
