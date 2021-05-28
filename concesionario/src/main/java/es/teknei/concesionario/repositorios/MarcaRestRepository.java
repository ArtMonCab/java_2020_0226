package es.teknei.concesionario.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.teknei.concesionario.entidades.Marca;

@RepositoryRestResource(collectionResourceRel = "marcas", path = "marcas")
public interface MarcaRestRepository extends PagingAndSortingRepository<Marca, Long>{

}
