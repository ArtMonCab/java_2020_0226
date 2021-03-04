package com.ipartek.formacion.ejemplofinal.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class DetalleCarrito implements Serializable{

	private static final long serialVersionUID = 3152847338563825274L;
	
	private Producto producto;
	private Integer cantidad;
	
}
