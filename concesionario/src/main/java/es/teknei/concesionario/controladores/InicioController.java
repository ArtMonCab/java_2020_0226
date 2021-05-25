package es.teknei.concesionario.controladores;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.client.RestTemplate;


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
		modelo.addAttribute("coches", cocheDao.obtenerCochePorMarca(1L));
		return "listado";
	}
	
	//Donde se envia el valor seleccionado
    @PostMapping("/listado")
    public String marcasPost(@ModelAttribute("marcas") Marca marcas) {
    	System.out.println("Has elegido: "+ marcas);
        return "listado";
    }
	
	@RequestMapping("/alta")
	public String altaCoche(Model modelo) {
		
		modelo.addAttribute("marcas", marcaDao.obtenerTodos());
		//modelo.addAttribute("coches", cocheDao.obtenerCochePorMarca(1L));
		return "alta";
	}

	@PostMapping("/alta")
	public String cochePost(Coche coche) {
		//çclienteNegocio.altaCliente(cliente);
		
		cocheDao.insertar(coche);

		System.out.println(coche.toString());

		return "/listado";
	}

}
