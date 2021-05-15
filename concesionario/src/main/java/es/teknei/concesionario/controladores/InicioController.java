package es.teknei.concesionario.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

	@RequestMapping("/alta")
	public ModelAndView firstPage() {
		return new ModelAndView("alta");
	}
}
