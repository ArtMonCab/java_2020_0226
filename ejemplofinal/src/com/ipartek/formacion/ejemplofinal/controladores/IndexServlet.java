package com.ipartek.formacion.ejemplofinal.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador que muestra la página inicial de la aplicación mediante get.
 * En la vista se muestran los productos disponibles para la compra
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("productos", Config.carritoNegocio.listadoProductos());
		request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request,  response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
