package com.ipartek.formacion.ejemplofinal.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.ejemplofinal.entidades.Carrito;


/**
 * Clase listener que usamos para asignar un carrito a un usuario al iniciar la sesión
 * 
 * @author Arturo Montañez
 * @version 1.0
 */

@WebListener
public class SesionListener implements HttpSessionListener {

	/**
	 * Método que al iniciar una sesión, asigna un carrito al usuario.
	 * 
	 * @param se
	 */

	@Override
    public void sessionCreated(HttpSessionEvent se)  { 
    	Carrito carrito = new Carrito();
    	se.getSession().setAttribute("carrito", carrito);

    }

	/**
	 * Método que cierra la sesión
	 * @param se
	 */

	@Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//No necesario
    }
	
}
