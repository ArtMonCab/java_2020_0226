package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Representa a las facturas
 * 
 * @author Arturo Montañez
 * @version 1.0
 *
 */

@Data @NoArgsConstructor @AllArgsConstructor
public class Factura implements Serializable{

	/**
	 * El IVa tiene un valor constante
	 */
	private static final BigDecimal IVA = new BigDecimal("0.21");
	
	
	/**
	 * Necesario para los elementos Serializables
	 */
	private static final long serialVersionUID = 2396176411731906644L;

	private Long id;
	private String codigo;
	private LocalDate fecha;
	
	private Cliente cliente;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<DetalleFactura> detallesFactura = new HashSet<>();
	
	
	/**
	 * Método que halla el precio total de todos los productos adquiridos
	 * @return precio total de la factura sin IVA
	 */
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for(DetalleFactura detalle: detallesFactura) {
			total = total.add(detalle.getTotal());
		}
		
		return total;
	}
	
	/**
	 * Método que halla el valor del IVA del precio total
	 * @return valor del IVA
	 */
	public BigDecimal getIva() {
		return getTotal().multiply(IVA);
	}
	
	/**
	 * Método que suma el valor del IVA al precio total
	 * @return precio total con IVA incluido
	 */
	public BigDecimal getTotalConIva() {
		return getTotal().add(getIva());
	}
}