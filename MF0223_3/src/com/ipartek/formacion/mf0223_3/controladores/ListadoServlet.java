package com.ipartek.formacion.mf0223_3.controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223_3.accesodatos.PlatoDaoMySql;
import com.ipartek.formacion.mf0223_3.entidades.Plato;

/**
 * Controlador que muestra el listado de los platos
 * 
 * @author Arturo Montañez
 * @version 1.0
 *
 */

@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(ListadoServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PlatoDaoMySql dao = new PlatoDaoMySql();
		
		//Iterable<Plato> platos = dao.obtenerTodos();
		
		Iterable<Plato> platos = Config.platoNegocio.listadoPlatos();
		
		LOG.log(Level.INFO, "Platos: {0}", platos);
		
		request.setAttribute("platos",platos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/agregar");
	}

}
