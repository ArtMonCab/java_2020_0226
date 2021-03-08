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
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class RestauracionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(RestauracionServlet.class.getName());
	
	private static final String UPLOAD_DIRECTORY = "backupbd";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/vistas/restauracion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();
		
		String nombreFichero = null;
		
		for (Part part : request.getParts()) {
		    nombreFichero = part.getSubmittedFileName();
		    
		    LOG.info("Nombre de fichero: [" + nombreFichero + "]");
		    
		    if(nombreFichero != null && nombreFichero.trim().length() > 0) {
		    	LOG.info("Nombre de fichero ACEPTADO: [" + nombreFichero + "]");
			    part.write(uploadPath + File.separator + nombreFichero);
			    
			    break;
		    }
		}
		

		
		String restaurar = "mysql -uroot -e \"source " + uploadPath + File.separator + nombreFichero + "\"";
		try {
			Process runProcess = Runtime.getRuntime().exec(restaurar);
			int procesoCompletado = runProcess.waitFor();
			if(procesoCompletado == 0) {
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
