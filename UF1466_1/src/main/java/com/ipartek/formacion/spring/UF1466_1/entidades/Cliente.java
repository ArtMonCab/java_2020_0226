package com.ipartek.formacion.spring.UF1466_1.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
	
	private Integer codigo;
	private String nombre;
	private String email;
	private Integer telefono;
	private String direccion;
	private String poblacion;
	private Integer codigopostal;
	private String identificador;
	private Integer activo;
	
}
