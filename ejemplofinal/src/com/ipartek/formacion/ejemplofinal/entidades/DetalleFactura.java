package com.ipartek.formacion.ejemplofinal.entidades;


import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa los detalles de la factura
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@Data @NoArgsConstructor @AllArgsConstructor
public class DetalleFactura implements Serializable{
	
	/**
	 * Necesario para los elementos Serializables
	 */

	private static final long serialVersionUID = 3924664355341140287L;
	
	private Factura factura;
	private Producto producto;
	private Integer cantidad;
	
	/**
	 * Método que multiplica el valor unitario de cada producto por la cantidad comprada
	 * @return Precio unitario multiplicado por cantidad
	 */
	public BigDecimal getTotal() {
		return producto.getPrecio().multiply(new BigDecimal(cantidad));
	}
}
