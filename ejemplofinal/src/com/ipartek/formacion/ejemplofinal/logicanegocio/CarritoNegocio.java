package com.ipartek.formacion.ejemplofinal.logicanegocio;

import java.util.Set;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

/**
 * Interfaz donde se declaran los métodos de CarritoNegocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public interface CarritoNegocio {
	Set<Producto> listadoProductos();

	Producto productoPorId(Long id);

	Factura guardarFactura(Factura factura);
}
