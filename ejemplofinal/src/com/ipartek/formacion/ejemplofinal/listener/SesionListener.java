package com.ipartek.formacion.ejemplofinal.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.ejemplofinal.entidades.Carrito;



@WebListener
public class SesionListener implements HttpSessionListener {

	@Override
    public void sessionCreated(HttpSessionEvent se)  { 
    	//Cuando se inicia la sesion al usuario se le asigna un carrito
    	Carrito carrito = new Carrito();
    	se.getSession().setAttribute("carrito", carrito);

    }


	@Override
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	//No necesario
    }
	
}
