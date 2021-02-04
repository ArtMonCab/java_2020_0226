package com.ipartek.formacion.spring.springdatajpaunoavarios.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private BigDecimal precio;
	
	@ManyToOne //fecth = FetchType.EAGER) Valor por defecto de ManyToOne. Con el Get trae todos los datos.
	private Categoria categoria;
}
