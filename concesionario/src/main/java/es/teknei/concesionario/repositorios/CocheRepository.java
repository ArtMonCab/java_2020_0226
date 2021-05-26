package es.teknei.concesionario.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import es.teknei.concesionario.entidades.Coche;


public interface CocheRepository extends CrudRepository<Coche, Long>{
	static final String SQL_SELECT = "SELECT c.id, c.modelo, c.matricula, c.marca_id, m.id, m.nombre FROM coches c JOIN marcas m ON c.marca_id = m.id";
	
    @Query(nativeQuery = true, value = SQL_SELECT + " where m.id = :id")
    Iterable<Coche> findNamebyId(@Param("id")long id);


}
