package es.teknei.concesionario.repositorios;


import java.util.Set;

import es.teknei.concesionario.entidades.Coche;

public interface DaoCoche extends Dao<Coche> {
	
	default Set<Coche> obtenerPorMarca(long marcaId){		
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
