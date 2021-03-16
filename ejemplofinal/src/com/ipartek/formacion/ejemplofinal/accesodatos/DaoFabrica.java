package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;
import com.ipartek.formacion.ejemplofinal.entidades.Producto;

/**
 * Selecciona que acceso a datos vamos a usar
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class DaoFabrica {
	
	private DaoFabrica() {}

	private static final Dao<Producto> daoProducto = new ProductoDaoMySql();
	private static final DaoFactura daoFactura = new FacturaDaoMySql();
	private static final Dao<Cliente> daoCliente = new ClienteDaoMySql();
	private static final DaoUsuario daoUsuario = new UsuarioDaoMySql();
	
	/**
	 * Método que nos devuelve el Dao del producto
	 * @return daoProducto
	 */
	public static Dao<Producto> getDaoProducto() {
		return daoProducto;
	}

	
	/**
	 * Método que nos devuelve el Dao de la factura
	 * @return daoFactura
	 */
	public static DaoFactura getDaoFactura() {
		return daoFactura;
	}

	
	/**
	 * Método que nos devuelve el Dao del cliente
	 * @return daoCliente
	 */
	public static Dao<Cliente> getDaoCliente() {
		return daoCliente;
	}

	
	/**
	 * Método que nos devuelve el Dao del usuario
	 * @return daoUsuario
	 */
	public static DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
	
}
