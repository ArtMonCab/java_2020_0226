package es.teknei.concesionario.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.teknei.concesionario.entidades.Coche;

@Repository
public class CocheDaoJpa implements DaoCoche{
	@Autowired
	private CocheRestRepository repo;

	@Override
	public Iterable<Coche> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Coche obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Coche insertar(Coche coche) {
		return repo.save(coche);
	}

	@Override
	public Coche modificar(Coche coche) {
		repo.save(coche);
		return coche;
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Iterable<Coche> obtenerCochePorMarca(long id) {
		return repo.findNamebyId(id);
		
	}
}
