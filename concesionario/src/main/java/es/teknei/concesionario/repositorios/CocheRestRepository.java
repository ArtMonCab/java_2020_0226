package es.teknei.concesionario.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.teknei.concesionario.entidades.Coche;

@RepositoryRestResource(collectionResourceRel = "coches", path = "coches")
//public interface CocheRestRepository extends PagingAndSortingRepository<Coche, Long>{
public interface CocheRestRepository extends CrudRepository<Coche, Long>{
	static final String SQL_SELECT = "SELECT c.id, c.modelo, c.matricula, c.marca_id, m.id, m.nombre FROM coches c JOIN marcas m ON c.marca_id = m.id";
	
    @Query(nativeQuery = true, value = SQL_SELECT + " where m.id = :id")
    Iterable<Coche> findNamebyId(@Param("id")long id);
}
