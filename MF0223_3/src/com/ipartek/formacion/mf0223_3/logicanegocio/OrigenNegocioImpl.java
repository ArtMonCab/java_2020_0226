package com.ipartek.formacion.mf0223_3.logicanegocio;

import com.ipartek.formacion.mf0223_3.accesodatos.Dao;
import com.ipartek.formacion.mf0223_3.accesodatos.DaoFabrica;
import com.ipartek.formacion.mf0223_3.entidades.Categoria;
import com.ipartek.formacion.mf0223_3.entidades.Origen;

public class OrigenNegocioImpl implements OrigenNegocio{

	private Dao<Origen> daoOrigen = DaoFabrica.getDaoOrigen();

	@Override
	public Iterable<Origen> listadoOrigenes() {
		Iterable<Origen> origenes = daoOrigen.obtenerTodos();
		return origenes;
	}

	@Override
	public Origen origenPorId(Long id) {
		Origen origen = daoOrigen.obtenerPorId(id);
		return origen;
	}

}
