package com.ipartek.formacion.ejemplofinal.accesodatos;


public interface Dao<T> {
	default Iterable<T> obtenerTodos(){
		throw new AccesoDatosException("No IMPLEMENTADO");
	}
	default T obtenerPorId(Long id){
		throw new AccesoDatosException("No IMPLEMENtADO");
	}
	default T insertar(T objeto){
		throw new AccesoDatosException("No IMPLEMENtADO");
	}
	default T modificar (T objeto){
		throw new AccesoDatosException("No IMPLEMENtADO");
	}
	default void borrar(Long id){
		throw new AccesoDatosException("No IMPLEMENtADO");
	}
		

}
