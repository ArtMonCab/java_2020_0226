package es.teknei.concesionario.repositorios;

import java.util.Set;

import es.teknei.concesionario.entidades.Coche;

public interface DaoCoche extends Dao<Coche> {

	Iterable<Coche> obtenerCochePorMarca(long id);
}
