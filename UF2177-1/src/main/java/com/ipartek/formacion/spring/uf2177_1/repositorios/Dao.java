package com.ipartek.formacion.spring.uf2177_1.repositorios;

public interface Dao <T>{
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	T obtenerPorRef(String ref);
	
	T agregar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
	void borrarPorRef(String ref);


}
