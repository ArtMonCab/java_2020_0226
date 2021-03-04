package com.ipartek.formacion.uf1466_2.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="libro")
@Data @AllArgsConstructor @NoArgsConstructor
public class Libro {
	
	private Long id;
	private String titulo;
	private String autor;
	private String isbn;
	

}
