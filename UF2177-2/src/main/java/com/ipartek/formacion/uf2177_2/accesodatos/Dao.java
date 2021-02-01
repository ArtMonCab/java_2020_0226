package com.ipartek.formacion.uf2177_2.accesodatos;

public interface Dao<T> {

	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T agregar(T objeto);
	T modificar(T objeto);

	T borrar(Long id);
	


}
