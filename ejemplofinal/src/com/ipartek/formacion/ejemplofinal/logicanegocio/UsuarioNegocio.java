package com.ipartek.formacion.ejemplofinal.logicanegocio;

import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * Interfaz donde se declaran métodos de UsuarioNegocio
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
public interface UsuarioNegocio {
	
	boolean validarUsuario(Usuario usuario);
}
