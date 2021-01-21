package com.ipartek.formacion.spring.springmvcbasico;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaludarController {
	
	@GetMapping("/saludo")
	public String saludo(String nombre, Model modelo) {
		modelo.addAttribute("nombre",nombre);
		return "saludo";
		
	}

}
