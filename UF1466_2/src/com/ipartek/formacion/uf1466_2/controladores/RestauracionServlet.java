package com.ipartek.formacion.uf1466_2.controladores;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.formacion.uf1466_2.accesodatos.LibroDao;
import com.ipartek.formacion.uf1466_2.accesodatos.LibroDaoMySql;
import com.ipartek.formacion.uf1466_2.entidades.Libro;


@WebServlet("/restauracion")

public class RestauracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(RestauracionServlet.class.getName());
       
	private static final String DIRECTORIO_BACKUP = "c:/backup/";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/vistas/restauracion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//Ojo, para que funcione el archivo debe cogerse del directorio indicado en DIRECTORIO_BACKUP, que en este caso es "c:\backup"
		String archivo = request.getParameter("archivo");
		
		String usuario ="root";
		String password = "";
		String origen = DIRECTORIO_BACKUP + archivo;
		String[] restaurar = new String[] { "mysql ", "--user=" + usuario, "--password=" + password, "-e",
			    "source " + origen };
		try {
			Process runProcess = Runtime.getRuntime().exec(restaurar);
			int processComplete = runProcess.waitFor();
			if(processComplete == 0) {
		 		response.sendRedirect(request.getContextPath() + "/listado");
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
