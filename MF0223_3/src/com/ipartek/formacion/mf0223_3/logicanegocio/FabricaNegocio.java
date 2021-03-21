package com.ipartek.formacion.mf0223_3.logicanegocio;


/**
 * Clase donde se llama a las implementaciones de la l�gica de negocio
 * 
 * @author Arturo Monta�ez
 * @version 1.0
 */
public class FabricaNegocio {
	
	private static PlatoNegocio platoNegocio = new PlatoNegocioImpl();
	private static CategoriaNegocio categoriaNegocio = new CategoriaNegocioImpl();
	private static OrigenNegocio origenNegocio = new OrigenNegocioImpl();
	
	/**
	 * M�todo para obtener platoNegocio
	 * 
	 * @return platoNegocio
	 */
	public static PlatoNegocio getPlatoNegocio() {
		return platoNegocio;
	}

	/**
	 * M�todo para obtener categoriaNegocio
	 * 
	 * @return platoNegocio
	 */
	public static CategoriaNegocio getCategoriaNegocio() {
		return categoriaNegocio;
	}
	
	/**
	 * M�todo para obtener origenNegocio
	 * 
	 * @return platoNegocio
	 */
	public static OrigenNegocio getOrigenNegocio() {
		return origenNegocio;
	}
}
