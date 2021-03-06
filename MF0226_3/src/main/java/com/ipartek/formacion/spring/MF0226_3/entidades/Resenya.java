package com.ipartek.formacion.spring.MF0226_3.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resenya")
@Data @AllArgsConstructor @NoArgsConstructor
public class Resenya {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String descripcion;
	private int alumnoCodigo;
	private int cursoCodigo;
	
;
}
