package com.ipartek.formacion.mf0223_3.accesodatos;

import com.ipartek.formacion.mf0223_3.entidades.Categoria;
import com.ipartek.formacion.mf0223_3.entidades.Origen;
import com.ipartek.formacion.mf0223_3.entidades.Plato;

public class DaoFabrica {
	private DaoFabrica() {}

	private static final Dao<Plato> daoPlato = new PlatoDaoMySql();
	private static final Dao<Categoria> daoCategoria = new CategoriaDaoMySql();
	private static final Dao<Origen> daoOrigen = new OrigenDaoMySql();

}
