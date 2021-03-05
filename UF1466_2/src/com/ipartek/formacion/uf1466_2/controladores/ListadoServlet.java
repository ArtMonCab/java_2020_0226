 package com.ipartek.formacion.uf1466_2.controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ipartek.formacion.uf1466_2.accesodatos.LibroDao;
import com.ipartek.formacion.uf1466_2.accesodatos.LibroDaoMySql;
import com.ipartek.formacion.uf1466_2.entidades.Libro;


@WebServlet("/listado")
public class ListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOG = Logger.getLogger(ListadoServlet.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroDao dao = new LibroDaoMySql();
		
		Iterable<Libro> libros = dao.obtenerTodos();
		
		LOG.log(Level.INFO, "Libros: {0}", libros);
		
		request.setAttribute("libros", libros);
		
		request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String opcion = request.getParameter("opcion");
		String termino = request.getParameter("termino");
		
		LOG.log(Level.INFO, opcion+" - "+termino);

		if (opcion == "1") {
			doGet(request, response);
		}
		
		if (opcion == "2") {
			//LibroDao dao = new LibroDaoMySql();
			
			//Libro libro = dao.obtenerPorIsbn(termino);
			
			request.getRequestDispatcher("/WEB-INF/vistas/detalle.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/detalle");
		}
		


		
	}

}
