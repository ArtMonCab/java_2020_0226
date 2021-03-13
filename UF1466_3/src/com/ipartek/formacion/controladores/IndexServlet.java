package com.ipartek.formacion.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.formacion.accesodatos.Conexion;



@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(IndexServlet.class.getName());
	
	private static final String UPLOAD_DIRECTORY = "backupbd";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request,  response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		//Nombre de la nueva base de datos.
		String nombre = request.getParameter("nombre");
		Conexion conexion = Conexion.getInstancia();
		
		//Hacer la copia de la base de datos gestion docente
		
		try {
			//En caso de usar passwor, abria que poner -p[password]
			Process p = Runtime
			            .getRuntime()
			            .exec("mysqldump -u root gestiondocente");

			InputStream is = p.getInputStream();
			FileOutputStream fos = new FileOutputStream("c:/temp/" + nombre + ".sql");
			byte[] buffer = new byte[1000];

			int leido = is.read(buffer);
			while (leido > 0) {
				fos.write(buffer, 0, leido);
			    leido = is.read(buffer);
			}

			fos.close();
			System.out.println("Fichero " + nombre + ".sql creado correctamente");
		} catch (Exception e) {
			System.out.println("No se ha podido crear el fichero " + nombre + ".sql");
		}


		conexion.dropDatabase(nombre);
		conexion.createDatabase(nombre);
		
	
	
	//Copio la nueva base de datos
		//En caso de usar passwor, abria que poner -p[password]
		try {
			Process p = Runtime
					.getRuntime()
			        .exec("mysql -u root " + nombre);

			OutputStream os = p.getOutputStream();
			FileInputStream fis = new FileInputStream("c:/temp/" + nombre + ".sql");
			byte[] buffer = new byte[1000];

			int leido = fis.read(buffer);
			while (leido > 0) {
			         os.write(buffer, 0, leido);
			         leido = fis.read(buffer);
			}

			os.flush();
			os.close();
			fis.close();
			System.out.println("Base de datos " + nombre + " creada correctamente");

		} catch (Exception e) {
			System.out.println("Error en la creacion de la base de datos " + nombre);
		}
		
		
		   
		
		doGet(request, response);
	}
}
