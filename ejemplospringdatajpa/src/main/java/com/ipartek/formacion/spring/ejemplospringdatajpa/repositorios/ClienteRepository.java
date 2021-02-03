package com.ipartek.formacion.spring.ejemplospringdatajpa.repositorios;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ipartek.formacion.spring.ejemplospringdatajpa.entidades.Cliente;
//CrudRepository se comporta como un Dao
//public interface ClienteRepository extends CrudRepository<Cliente, Long>{
//PagingAndSortingRepository es una extensión CrudRepository añadiendo paginación y ordenacion
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

	List<Cliente> findByApellidos(String apellidos);
	
	//Optional<Cliente> findById(Long id);
	Page<Cliente> findByApellidos(String apellidos, Pageable pageable);
	
	//findByNombreCompleto("Montañez, Arturo");
	// substring(:nombreCOmpleto, locate(',', :nombreCompleto) + 1);
	@Query("select c.id from Cliente c where c.nombre = substring(:nombreCompleto, locate(',', :nombreCompleto) + 1) and c.apellidos = substring(:nombreCompleto, 1, locate(',', :nombreCompleto) - 1)")
	Long findByNombreCompleto(String nombreCompleto);
}
