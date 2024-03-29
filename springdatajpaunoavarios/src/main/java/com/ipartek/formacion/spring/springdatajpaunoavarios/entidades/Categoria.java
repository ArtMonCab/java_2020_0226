package com.ipartek.formacion.spring.springdatajpaunoavarios.entidades;

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
@Table(name="categorias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String descripcion;
	
	
	@ToString.Exclude //Excluye el elemento del toString
	@EqualsAndHashCode.Exclude //Excluye el elemento del hashCode
	@OneToMany(mappedBy = "categoria") //, fetch = FetchType.LAZY) Es el valor por defecto. Con el Get no trae todos los productos de la categoria. El otro valor posible es EAGER
	private final Set<Producto> productos = new HashSet<>();
	
}
