package es.teknei.concesionario.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.teknei.concesionario.entidades.Marca;

@Repository
public class MarcaDaoJpa implements Dao<Marca>{
	
	@Autowired
	private MarcaRepository repo;

	@Override
	public Iterable<Marca> obtenerTodos() {
		return repo.findAll();
	}

	@Override
	public Marca obtenerPorId(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Marca insertar(Marca marca) {
		return repo.save(marca);
	}

	@Override
	public Marca modificar(Marca marca) {
		repo.save(marca);
		return marca;
	}

	@Override
	public void borrar(Long id) {
		repo.deleteById(id);
	}
}
