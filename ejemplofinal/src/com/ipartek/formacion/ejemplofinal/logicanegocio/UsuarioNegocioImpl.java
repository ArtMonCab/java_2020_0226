package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplofinal.accesodatos.DaoUsuario;
import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * Clase donde se implementan los métodos declarados en UsuarioNegocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public class UsuarioNegocioImpl implements UsuarioNegocio{

	private DaoUsuario dao = DaoFabrica.getDaoUsuario();
	
	/**
	 * Método que usamos para validar al usuario, Devuelve true o false.
	 * 
	 * @param usuario lo pasamos como parametro
	 * @return boolean
	 */
	@Override
	public boolean validarUsuario(Usuario usuario) {
		Usuario usuarioBdd = dao.obtenerPorEmail(usuario.getEmail());
		
		if(usuarioBdd != null && usuario.getPassword().equals(usuarioBdd.getPassword())) {
			usuario.setId(usuarioBdd.getId());
			usuario.setCliente(usuarioBdd.getCliente());
			
			return true;
		} else {
			return false;
		}
	}

}
