package es.teknei.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.DaoCoche;

//https://spring.io/guides/tutorials/rest/

@Controller
public class InicioController {
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> daoMarca;
	
	@RequestMapping("/alta")
	public String alta(Model modelo) {
		modelo.addAttribute("marcas", daoMarca.obtenerTodos());
		
		return "alta";
	}	
	
	@RequestMapping("/listado")
	public String listado(Model modelo) {
		Long idMarca;
		
		modelo.addAttribute("coches", cocheDao.obtenerPorMarca(2));
		
		modelo.getAttribute("marca.id");
		
		System.out.println("-----------------------------------------------");
		System.out.println(modelo);
		System.out.println("-----------------------------------------------");
		
		modelo.addAttribute("marcas", daoMarca.obtenerTodos());
		
		
		return "listado";
	}
	
	
}
