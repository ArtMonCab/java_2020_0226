package es.teknei.concesionario.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.DaoMarca;


@RestController
@RequestMapping("/api/listado")
public class ListadoApi {
	@Autowired
	private DaoMarca dao;
	
	@GetMapping("{id}")
	public ResponseEntity<Marca> getPorIdConCoches(@PathVariable Long id) {
		Marca marca = dao.obtenerPorIdConCoches(id);
		
		if(marca == null) {
			return new ResponseEntity<Marca>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Marca>(marca, HttpStatus.OK);
	}

}
