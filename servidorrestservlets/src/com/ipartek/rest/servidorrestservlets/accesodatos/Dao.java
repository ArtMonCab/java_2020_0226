package com.ipartek.rest.servidorrestservlets.accesodatos;


//Se hace para comparar con REST, realmente no se deberia usar en el programa
public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T t);
	T modificar(T t);
	void borrar(Long id);
	
}
