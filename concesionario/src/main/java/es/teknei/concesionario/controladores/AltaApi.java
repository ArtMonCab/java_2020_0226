package es.teknei.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.repositorios.Dao;


@RestController
@RequestMapping("/api/alta")
public class AltaApi {
	@Autowired
	private Dao<Coche> dao;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Coche post(@RequestBody Coche coche) {
		return dao.insertar(coche);
	}

}
