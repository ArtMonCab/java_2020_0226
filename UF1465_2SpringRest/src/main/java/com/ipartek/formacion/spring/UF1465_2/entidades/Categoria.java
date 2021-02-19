package com.ipartek.formacion.spring.UF1465_2.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="categorias")
@Data @AllArgsConstructor @NoArgsConstructor
public class Categoria {
	
	private int id;
	private String nombreCategoria;
	
	@ToString.Exclude 
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "categorias") 
	private final Set<Producto> productos = new HashSet<>();
	

}
