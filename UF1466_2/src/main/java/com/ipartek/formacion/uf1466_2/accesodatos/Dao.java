package com.ipartek.formacion.uf1466_2.accesodatos;

import java.util.Set;

public interface Dao<T> {
	default Set<T> obtenerTodos(){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T obtenerPorId(long id){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T insertar(T objeto){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default T modificar (T objeto){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	default void borrar(Long id){
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
