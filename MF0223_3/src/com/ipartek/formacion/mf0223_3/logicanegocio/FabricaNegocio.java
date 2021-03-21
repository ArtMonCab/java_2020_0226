package com.ipartek.formacion.mf0223_3.logicanegocio;


/**
 * Clase donde se llama a las implementaciones de la lógica de negocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class FabricaNegocio {
	
	private static PlatoNegocio platoNegocio = new PlatoNegocioImpl();
	private static CategoriaNegocio categoriaNegocio = new CategoriaNegocioImpl();
	private static OrigenNegocio origenNegocio = new OrigenNegocioImpl();
	
	/**
	 * Método para obtener platoNegocio
	 * 
	 * @return platoNegocio
	 */
	public static PlatoNegocio getPlatoNegocio() {
		return platoNegocio;
	}

	/**
	 * Método para obtener categoriaNegocio
	 * 
	 * @return platoNegocio
	 */
	public static CategoriaNegocio getCategoriaNegocio() {
		return categoriaNegocio;
	}
	
	/**
	 * Método para obtener origenNegocio
	 * 
	 * @return platoNegocio
	 */
	public static OrigenNegocio getOrigenNegocio() {
		return origenNegocio;
	}
}
