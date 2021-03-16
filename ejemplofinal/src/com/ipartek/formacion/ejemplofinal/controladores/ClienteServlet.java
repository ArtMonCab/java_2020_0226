package com.ipartek.formacion.ejemplofinal.controladores;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplofinal.entidades.Cliente;

/**
 * Controlador que gestiona a los clientes para la creación de facturas.
 * En el post recoge la información, la empaqueta en  un objeto cliente, y la manda a crear-factura
 * 
 * @author Arturo Montañez
 * @version 1.0
 */
@WebServlet("/cliente")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(Config.PATH_VISTAS + "cliente.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * Recoger información
		 */
		String nombre = request.getParameter("Nombre");
		String apellidos = request.getParameter("apellidos");
		String cif = request.getParameter("cif");
		String fechaNacimiento =request.getParameter("fecha-nacimiento");

		
		/*
		 * Empaquetarlo en un objeto
		 */
		Cliente cliente = new Cliente(null, nombre,apellidos, cif,LocalDate.parse(fechaNacimiento), null);
				
		
		Config.clienteNegocio.altaCliente(cliente);
		
		request.setAttribute("cliente", cliente);
		request.getRequestDispatcher("/crear-factura").forward(request, response);
				
				
	}

}
