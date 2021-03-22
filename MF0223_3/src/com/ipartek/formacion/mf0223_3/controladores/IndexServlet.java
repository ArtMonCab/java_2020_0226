package com.ipartek.formacion.mf0223_3.controladores;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.formacion.mf0223_3.entidades.Alerta;

/**
 * Controlador que se hace la carga de una base de datos desde el fichero seleccionado
 * 
 * @author Arturo Montañez
 * @version 1.0
 */


@WebServlet("/index")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOG = Logger.getLogger(IndexServlet.class.getName());
	
	private static final String UPLOAD_DIRECTORY = "backupbd";

	/**
	 * En el Get voy a la vista de Index.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Config.PATH_VISTAS + "index.jsp").forward(request, response);
	}


	/**
	 * En el Post selecciono el fichero donde está la copia de la base de datos y la cargo
	 */
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
				request.getSession().setAttribute("alerta", new Alerta("success", "Base de datos cargada correctamente"));
		 		response.sendRedirect(request.getContextPath() + "/listado");
			}else {
				System.out.println("Ha habido algun error");
				request.setAttribute("alerta", new Alerta("danger", "Ha habido algún error con la carga de la base de datos"));
				doGet(request, response);
			}
		} catch (InterruptedException e) {
		
			System.out.println("Proceso no completado");
			request.setAttribute("alerta", new Alerta("danger", "Proceso no completado"));
			doGet(request, response);
		}
	}

}
