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
@Table(name="Resenya")
@Data 
public class Resenya {
	private int codigo;
	private String descripcion;
	private Date fecha;
	private int alumnoCodigo;
	private int cursoCodigo;
	

}
