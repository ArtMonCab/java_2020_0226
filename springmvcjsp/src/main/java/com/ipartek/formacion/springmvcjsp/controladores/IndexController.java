package com.ipartek.formacion.springmvcjsp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//Vale para get, post y cualquier peticion que llegue al raiz se procesa con esta controlador
@Controller
@RequestMapping("/") //Equivalente a @Webservlet("/")
public class IndexController { //extends HttpServlet
	@GetMapping
	public String get () {//Equivalente a doGet
		return "index";   //request.getResquestDistpacher("/WEB-INF/vistas/index.jsp").forward(request,response)
	}
	
	@PostMapping
	public String post(String nombre, Model modelo) {//Equivalente a doPost
		System.out.println(nombre);
		
		modelo.addAttribute("nombre", nombre);
		
		//return "saludo"; //request.getResquestDistpacher("/WEB-INF/vistas/saludo.jsp").forward(request,response)
		//return saludo(nombre, modelo);
		return "forward:/saludo";//request.getResquestDistpacher("/saludo").forward(request,response)
	}
	
	@RequestMapping("saludo")
	public String saludo() { //(String nombre, Model modelo) {
		//modelo.addAttribute("saludo", "¿Que passa tio?");
		return "saludo";
	}
	
	
	@GetMapping("index")
	public String indice() {
		return "redirect:/"; //Equivalente a response.sendRedirect("/");
		
	}
}
