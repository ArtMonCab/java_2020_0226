package com.ipartek.formacion.mf0223_3.logicanegocio;


/**
 * Clase donde se llama a las implementaciones de la lógica de negocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class FabricaNegocio {
	
	private static PlatoNegocio platoNegocio = new PlatoNegocioImpl();
	
	/**
	 * Método para obtener platoNegocio
	 * 
	 * @return platoNegocio
	 */
	public static PlatoNegocio getPlatoNegocio() {
		return platoNegocio;
	}

}
