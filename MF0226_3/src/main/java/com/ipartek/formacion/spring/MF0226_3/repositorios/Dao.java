package com.ipartek.formacion.spring.MF0226_3.repositorios;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(int id);
	


}
