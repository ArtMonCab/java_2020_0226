                                                                                                                                                                   package es.teknei.concesionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConcesionarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}
	
	@GetMapping("/concesionario")
	public String hello(@RequestParam(value = "name", defaultValue = "Usuario") String name) {
	return String.format("¡Hola %s!", name);
	}
}
