 package com.ipartek.formacion.uf1466_2.controladores;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf1466_2.accesodatos.LibroDao;
import com.ipartek.formacion.uf1466_2.accesodatos.LibroDaoMySql;
import com.ipartek.formacion.uf1466_2.entidades.Autor;
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
		
		String opcion  = request.getParameter("opcion");
		String termino = request.getParameter("termino");
<<<<<<< HEAD
=======
		
		//LOG.log(Level.INFO, opcion+" - "+termino);
		//request.setAttribute("libros", libros);
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		LibroDao dao = new LibroDaoMySql();
		
		Iterable<Libro> libros = null;
		
		LOG.info("Opcion: "+ opcion);
		LOG.info("Termino: " + termino);
		
		
 		if (termino != null) {
 			//Busqueda por titulo
 			if (opcion.equals("1") ) {
 				libros = dao.obtenerPorTitulo("%" + termino+ "%");
 			}
 			
 			//Busqueda por ISBN
 			if (opcion.equals("2")) {
 				libros = dao.obtenerPorIsbn(termino);
 			}
 			
			
			request.getSession().setAttribute("libros", libros);
			LOG.log(Level.INFO, "Libros: {0}", libros);
			request.getRequestDispatcher("/WEB-INF/vistas/busqueda.jsp").forward(request, response);
			

		} else {
			request.setAttribute("mensaje", "No se ha encontrado ningún libro con ese termino");
			request.setAttribute("nivel", "danger");

			request.setAttribute("termino", termino);

			doGet(request, response);
		}
=======
		//Autor autor = new Autor(1L, "Miguel", "De Cervantes");
		//Libro libro = new Libro(1L, "Prueba", "1223134123", autor);

 		LibroDao dao = new LibroDaoMySql();
		
 		Iterable<Libro> libros = dao.obtenerPorIsbn("844151860");
 		//Iterable<Libro> libros = dao.obtenerPorTitulo("Ja");

 		LOG.log(Level.INFO, "Libros: {0}", libros);

 		request.setAttribute("libros", libros);

 		request.getRequestDispatcher("/WEB-INF/vistas/busqueda.jsp").forward(request, response);
 		
 		//if ((opcion == "1") || (opcion == "2")) {
 			
 		//}else {
 			//doGet(request, response);
 		//}
 		
		//response.sendRedirect(request.getContextPath() + "/busqueda");


		
>>>>>>> refs/remotes/origin/master

		
		
		
	}

}
