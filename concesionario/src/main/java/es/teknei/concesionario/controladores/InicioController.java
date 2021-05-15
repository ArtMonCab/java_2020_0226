package es.teknei.concesionario.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

	@RequestMapping("/prueba")
    public String prueba() {
        
        return "prueba";
    }
}
