package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;
import java.util.TreeMap;

public class Carrito implements Serializable{

	private static final long serialVersionUID = -370385928841361725L;
	
	private TreeMap<Long, DetalleCarrito> lineas = new TreeMap<>();
	
	public void addProducto(Producto producto, Integer cantidad) {
		//Si se trata del mismo producto, en vez de añadir otro producto incrementa la cantidad.
		Long id = producto.getId();
		
		//Si el producto ya existe, modifico la cantidad,
		if(lineas.containsKey(id)) {
			DetalleCarrito linea = lineas.get(id);
			
			linea.setCantidad(linea.getCantidad() + producto.getCantidad());
		
			//Si el producto no existe, se añade el producto al treemap
		}else {
			DetalleCarrito linea = new DetalleCarrito(producto, cantidad);
			
			lineas.put(id,  linea);
		}
		
		DetalleCarrito linea = new DetalleCarrito(producto, cantidad);
		
		lineas.put(producto.getId(), linea);
	}
	
	public Iterable<DetalleCarrito> obtenerLineas(){
		return lineas.values();
	}
}
