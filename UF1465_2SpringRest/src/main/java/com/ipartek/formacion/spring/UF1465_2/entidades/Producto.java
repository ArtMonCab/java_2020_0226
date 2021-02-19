package com.ipartek.formacion.spring.UF1465_2.entidades;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="productos")
@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {

	private int id;
	private String nombre;
	private BigInteger precio;
	
	@ManyToOne
	Categoria categoria;
}
