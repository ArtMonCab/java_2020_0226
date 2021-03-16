package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.accesodatos.Dao;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.entidades.Cliente;

import lombok.extern.java.Log;

/**
 * Clase donde se implementan los métodos declaradas en la interfaz ClienteNegocio
 * 
 * @author Arturo Montañez
 * @version
 *
 */
@Log
public class ClienteNegocioImpl implements ClienteNegocio {
	private Dao<Cliente> dao = DaoFabrica.getDaoCliente();
	
	/**
	 * Método donde damos de alta un cliente.
	 * 
	 * @param  cliente
	 * @return Cliente
	 */
	@Override
	public Cliente altaCliente(Cliente cliente) {
		log.info(cliente.toString());
		return dao.insertar(cliente);
	}

}
