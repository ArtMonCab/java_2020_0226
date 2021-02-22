package com.ipartek.formacion.uf1465_2.controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf1465_2.accesodatos.Dao;
import com.ipartek.formacion.uf1465_2.accesodatos.ProductoDaoMySql;
import com.ipartek.formacion.uf1465_2.entidades.Producto;


@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger LOG = Logger.getLogger(ProductoServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dao<Producto> dao = new ProductoDaoMySql();
		
		Iterable<Producto> productos = dao.obtenerTodos();
		
		LOG.log(Level.INFO, "Productos: {0}", productos);
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/productos.jsp").forward(request, response);
		
		 
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
