package es.teknei.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.repositorios.Dao;


@Controller
public class InicioController {
	
	@Autowired
	private Dao<Coche> daoCoche;

	@RequestMapping("/alta")
	public String alta(Model modelo) {
		return "alta";
	}	
	
	@RequestMapping("/listado")
	public String listado(Model modelo) {
		modelo.addAttribute("coches", daoCoche.obtenerTodos());
		
		System.out.println(daoCoche.obtenerTodos());
		return "listado";
	}
	
	
}
