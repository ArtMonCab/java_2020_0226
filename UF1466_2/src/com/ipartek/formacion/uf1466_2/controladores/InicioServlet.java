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


@WebServlet("/inicio")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(InicioServlet.class.getName());
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/vistas/inicio.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		

		String archivo = request.getParameter("archivo");

		
		String usuario ="root";
		String password = "";
		String origen ="c:/temp/" + archivo;
		String[] restaurar = new String[] { "mysql ", "--user=" + usuario, "--password=" + password, "-e",
			    "source " + origen };
		try {
			Process runProcess = Runtime.getRuntime().exec(restaurar);
			int processComplete = runProcess.waitFor();
			if(processComplete == 0) {
		 		LibroDao dao = new LibroDaoMySql();
				
		 		Iterable<Libro> libros = dao.obtenerTodos();
		
		 		LOG.log(Level.INFO, "Libros: {0}", libros);
		
		 		request.setAttribute("libros", libros);
		
		 		request.getRequestDispatcher("/WEB-INF/vistas/listado.jsp").forward(request, response);
			}else {
				System.out.println("Ha habido algún error");
				doGet(request, response);
			}
		} catch (InterruptedException e) {
		
			System.out.println("Proceso no completado");
			doGet(request, response);
		}
		
		
		
		
	}

}
