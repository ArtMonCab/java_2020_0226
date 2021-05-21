package es.teknei.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.MarcaDao;

//https://spring.io/guides/tutorials/rest/

@Controller
public class InicioController {
	
	@Autowired
	private Dao<Coche> daoCoche;
	
	@Autowired
	private MarcaDao daoMarca;
	
	@RequestMapping("/alta")
	public String alta(Model modelo) {
		modelo.addAttribute("marcas", daoMarca.obtenerTodos());
		
		return "alta";
	}	
	
	@RequestMapping("/listado")
	public String listado(Model modelo) {
		modelo.addAttribute("coches", daoCoche.obtenerTodos());
		
		modelo.addAttribute("marcas", daoMarca.obtenerTodos());
		
		
		return "listado";
	}
	
	
}
