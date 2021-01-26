package com.ipartek.formacion.spring.uf2177_1.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Medicamento {
	private long id;
	private String referencia;
	private String nombre;
	private double precio;
}
