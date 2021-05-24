package es.teknei.concesionario.controladores;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.DaoCoche;

//https://spring.io/guides/tutorials/rest/
//https://bezkoder.com/spring-boot-vue-js-crud-example/
//https://www.baeldung.com/spring-controller-vs-restcontroller

@RestController
@RequestMapping("listado")
public class InicioController {
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> daoMarca;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@RequestMapping("/alta")
	public String alta(Model modelo) {
		modelo.addAttribute("marcas", obtenerMarcas());
		
		return "alta";
	}	
	
    @PostMapping("/listado")
    public String listadoPost(@ModelAttribute("marcas") Marca marcas) {
    //public String listadoPost(@RequestParam(value = "nombre") Marca marcas) {
    	System.out.println("Nombre: "+marcas.getNombre());
    	System.out.println("id: "+marcas.getId());
        return "listado";
    }

    
	@RequestMapping("/listado")
	public String listado(Model modelo) {
		
		/*ListadoApi listado;
		Long idMarca;
		
		modelo.addAttribute("coches", daoMarca.obtenerPorIdConCoches(2L).getCoches());
		
		modelo.addAttribute("coches", listado.);
		
		System.out.println("-----------------------------------------------");
		System.out.println(daoMarca.obtenerPorIdConCoches(2L).getCoches());
		System.out.println("-----------------------------------------------");
		
		modelo.addAttribute("marcas", daoMarca.obtenerTodos());*/
        //RestTemplate plantilla = new RestTemplate();
        //Iterable<Marca> marcas = plantilla.getForObject("http://localhost:8080/api/marcas", Iterable<Marca>.class);
        //System.out.println(marcas);
        
		modelo.addAttribute("marcas", obtenerMarcas());
		
		modelo.addAttribute("coches", cocheDao.obtenerCochePorMarca(1L));
		
		//modelo.addAttribute("coches", obtenerCochesPorMarca());
		
		//System.out.println(obtenerMarcas());
		
		return "listado";
	}
	
    public Iterable<Marca> obtenerMarcas(){
        ResponseEntity<Marca[]> response =
                  restTemplate.getForEntity(
                  "http://localhost:8080/api/marcas",
                  Marca[].class);
                Marca[] marcas = response.getBody();
                List<Marca> m = Arrays.asList(marcas);
        return  m;
    }
	
    
    public Iterable<Marca> obtenerCochesPorMarca(){
        ResponseEntity<Marca[]> response =
                  restTemplate.getForEntity(
                  "http://localhost:8080/api/coches/1",
                  Marca[].class);
                Marca[] coches = response.getBody();
                List<Marca> c = Arrays.asList(coches);
        return  c;
    }
}
