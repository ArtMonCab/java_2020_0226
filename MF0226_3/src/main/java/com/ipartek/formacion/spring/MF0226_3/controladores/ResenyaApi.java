package com.ipartek.formacion.spring.MF0226_3.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.MF0226_3.entidades.Resenya;
import com.ipartek.formacion.spring.MF0226_3.repositorios.ResenyaDao;

@RestController
@RequestMapping("/api/resenyas")
public class ResenyaApi {

	@Autowired 
	private ResenyaDao dao;
	
	@GetMapping
	public Iterable<Resenya> get() {
		return dao.obtenerTodos();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Resenya post(@RequestBody Resenya resenya) {
		return dao.insertar(resenya);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Resenya> put(@PathVariable Long id, @RequestBody Resenya resenya) {
		if(id != resenya.getCodigo()) {
			return new ResponseEntity<Resenya>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Resenya>(dao.modificar(resenya), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Resenya> delete(@PathVariable int id) {
		try {
			dao.borrar(id);
			return new ResponseEntity<Resenya>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<Resenya>(HttpStatus.NOT_FOUND);
		}
	}
}
