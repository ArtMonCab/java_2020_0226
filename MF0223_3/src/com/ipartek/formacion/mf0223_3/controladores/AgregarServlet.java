package com.ipartek.formacion.mf0223_3.controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0223_3.entidades.Categoria;
import com.ipartek.formacion.mf0223_3.entidades.Origen;
import com.ipartek.formacion.mf0223_3.entidades.Plato;

/**
 * Controlador que se hace agrega un plato a la base de datos
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@WebServlet(name = "agregar", urlPatterns = { "/agregar" })
public class AgregarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(ListadoServlet.class.getName());
	
	
	/**
	 * El Get carga las categorias y los origenes en los desplegables
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Iterable<Categoria> categorias= Config.categoriaNegocio.listadoCategorias();
		
		LOG.log(Level.INFO, "Categorias: {0}", categorias);
		
		request.setAttribute("categorias",categorias);
		
		
		Iterable<Origen> origenes = Config.origenNegocio.listadoOrigenes();
		
		LOG.log(Level.INFO, "Origenes: {0}", origenes);
		
		request.setAttribute("origenes",origenes);
		
		request.getRequestDispatcher(Config.PATH_VISTAS + "agregar.jsp").forward(request, response);
	}

	/**
	 * El Post guarda el plato en la base de datos, y nos manda a la pantalla donde está el listado de platos
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int calorias = Integer.parseInt(request.getParameter("calorias"));
		String nombrePlato = request.getParameter("nombrePlato");
		String elaboracion = request.getParameter("elaboracion");
		String dificultad = request.getParameter("dificultad");
		long idCategoria = Long.parseLong(request.getParameter("categoria"));
		long idOrigen = Long.parseLong(request.getParameter("origen"));
		
		Categoria categoria = Config.categoriaNegocio.categoriaPorId(idCategoria);
		Origen origen = Config.origenNegocio.origenPorId(idOrigen);
		
		LOG.log(Level.INFO, "Origen: {0}", origen);
		LOG.log(Level.INFO, "Categoria: {0}", categoria);
		
			
		Plato plato = new Plato(1L, nombrePlato, calorias, elaboracion, dificultad, categoria, origen);	
		
		Config.platoNegocio.agregarPlato(plato);
			
		response.sendRedirect(request.getContextPath() + "/listado");
	}

}
