package es.teknei.concesionario.entidades;


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
@Table(name="coches")
@Data @NoArgsConstructor @AllArgsConstructor
public class Coche{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private String matricula;
	
	@ManyToOne 
	private Marca marca;
	
}
