package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Usuario;

/**
 * Interfaz donde se le añade al interfaz Dao el método obtener un usuario por el mail.
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

public interface DaoUsuario extends Dao<Usuario>{
	
	Usuario obtenerPorEmail(String email);

}
