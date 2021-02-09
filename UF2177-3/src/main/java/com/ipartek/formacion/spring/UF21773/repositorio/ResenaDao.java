package com.ipartek.formacion.spring.UF21773.repositorio;

import com.ipartek.formacion.spring.UF21773.entidades.Resena;

public interface ResenaDao<T> extends Dao{
	
	Iterable<T> obtenerResenaPorLibro(int id);
	
	Resena insertar(T t);

}
