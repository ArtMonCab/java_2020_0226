package com.ipartek.formacion.ejemplofinal.accesodatos;

import java.util.Set;

import com.ipartek.formacion.ejemplofinal.entidades.Producto;

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
