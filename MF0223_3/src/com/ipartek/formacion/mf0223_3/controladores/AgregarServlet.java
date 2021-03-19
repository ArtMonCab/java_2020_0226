package com.ipartek.formacion.mf0223_3.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223_3.entidades.Plato;


/**
 * Controlador que se hace agrega un plato a la base de datod
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@WebServlet(name = "agregar", urlPatterns = { "/agregar" })
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/agregar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombrePlato = request.getParameter("nombrePlato");
		int calorias = Integer.parseInt(request.getParameter("calorias"));
		String elaboracion = request.getParameter("elaboracion");
		String dificultad = request.getParameter("dificultad");
		
		Plato plato = new Plato(1L, nombrePlato, calorias, elaboracion, dificultad, null, null);
		
		Config.platoNegocio.agregarPlato(plato);
		
		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
