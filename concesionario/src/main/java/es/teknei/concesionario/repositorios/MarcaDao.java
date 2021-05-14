package es.teknei.concesionario.repositorios;

import es.teknei.concesionario.entidades.Marca;

public interface MarcaDao extends Dao<Marca>{
	Marca obtenerPorIdConCoches(Long id);

}
