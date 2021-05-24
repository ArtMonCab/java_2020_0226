package es.teknei.concesionario.repositorios;

import es.teknei.concesionario.entidades.Coche;

public interface DaoCoche extends Dao<Coche> {

	Iterable<Coche> obtenerCochePorMarca(long id);
}
