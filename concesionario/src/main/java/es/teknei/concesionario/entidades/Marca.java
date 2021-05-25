package es.teknei.concesionario.entidades;

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
@Table(name="marcas")
@Data @NoArgsConstructor @AllArgsConstructor
public class Marca{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	
	@ToString.Exclude 
	@EqualsAndHashCode.Exclude 
	@OneToMany(mappedBy = "marca")
	private final Set<Coche> coches = new HashSet<>();


}
