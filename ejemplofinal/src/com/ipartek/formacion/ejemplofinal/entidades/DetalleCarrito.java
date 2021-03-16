package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa el detalle de los productos que hay en el carrito
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

@Data @AllArgsConstructor @NoArgsConstructor
public class DetalleCarrito implements Serializable{

	/**
	 * Necesario para los elementos serializables
	 */
	private static final long serialVersionUID = 3152847338563825274L;
	
	private Producto producto;
	private Integer cantidad;
	
}
