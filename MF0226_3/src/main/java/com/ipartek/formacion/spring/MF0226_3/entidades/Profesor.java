package com.ipartek.formacion.spring.MF0226_3.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="profesor")
@Data @AllArgsConstructor @NoArgsConstructor
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nombre;
	private String apellidos;
	
	@ToString.Exclude 
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "profesor") 
	private final Set<Curso> cursos = new HashSet<>();
}
