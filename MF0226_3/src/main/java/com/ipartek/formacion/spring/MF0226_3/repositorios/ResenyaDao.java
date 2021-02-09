package com.ipartek.formacion.spring.MF0226_3.repositorios;

import com.ipartek.formacion.spring.MF0226_3.entidades.Resenya;

public interface ResenyaDao extends Dao<Resenya> {
	
	Resenya insertar(Resenya resenya);
	Resenya modificar(Resenya resenya);
	void borrar(int id);
}
