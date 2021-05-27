package es.teknei.concesionario.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.DaoCoche;




@Controller
public class InicioController {
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> marcaDao;
	
	@RequestMapping("/listado")
	public String listadoCoches(Model modelo) {
		
		modelo.addAttribute("marcas", marcaDao.obtenerTodos());
		return "listado";
	}
	
	
    @PostMapping("/listado")
    public String marcasPost(@ModelAttribute("coches") Coche coches, Model modelo) {
    	modelo.addAttribute("coches", cocheDao.obtenerCochePorMarca(coches.getMarca().getId()));
    	modelo.addAttribute("marcas", marcaDao.obtenerTodos());
    	
        return "listado";
    }
    
	

	@RequestMapping("/alta")
	public String altaCoche(Model modelo) {
		
		modelo.addAttribute("marcas", marcaDao.obtenerTodos());
		return "alta";
	}

	@PostMapping("/alta")
	public String cochePost(Coche coche) {
		
		cocheDao.insertar(coche);

		return "/listado";
	}
	

}
