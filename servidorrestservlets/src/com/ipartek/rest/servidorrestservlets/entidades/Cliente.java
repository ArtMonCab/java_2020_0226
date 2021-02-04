package com.ipartek.rest.servidorrestservlets.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
	private Long id;
	private String nombre;
	private LocalDate fechaNacimiento;
}
