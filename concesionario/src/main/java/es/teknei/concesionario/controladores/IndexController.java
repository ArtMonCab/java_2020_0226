package es.teknei.concesionario.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(Model modelo) {
		//modelo.addAttribute("coches", );
		return "listado";
		//https://www.creativosonline.org/menus-css-de-barra-lateral.html
	}
}
