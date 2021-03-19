package com.ipartek.formacion.mf0223_3.logicanegocio;


import com.ipartek.formacion.mf0223_3.accesodatos.Dao;
import com.ipartek.formacion.mf0223_3.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223_3.entidades.Plato;

import lombok.extern.java.Log;

public class PlatoNegocioImpl implements PlatoNegocio{
	private Dao<Plato> daoPlato = DaoFabrica.getDaoPlato();

	@Override
	public Plato agregarPlato(Plato plato) {
		return daoPlato.insertar(plato);
	}

}
