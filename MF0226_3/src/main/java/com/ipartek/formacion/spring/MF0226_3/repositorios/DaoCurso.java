package com.ipartek.formacion.spring.MF0226_3.repositorios;

public interface DaoCurso<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T t);
	T modificar(T t);
	void borrar(Long id);

}
