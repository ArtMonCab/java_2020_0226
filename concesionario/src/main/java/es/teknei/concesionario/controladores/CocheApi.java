package es.teknei.concesionario.controladores;

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

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.repositorios.Dao;



@RestController
@RequestMapping("/api/coches")
public class CocheApi {
	@Autowired
	private Dao<Coche> dao;
	
	@GetMapping
	public Iterable<Coche> get() {
		return dao.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Coche> getPorId(@PathVariable Long id) {
		Coche coche = dao.obtenerPorId(id);
		
		if(coche == null) {
			return new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Coche>(coche, HttpStatus.OK);
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Coche post(@RequestBody Coche coche) {
		return dao.insertar(coche);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Coche> put(@PathVariable Long id, @RequestBody Coche coche) {
		if(id != coche.getId()) {
			return new ResponseEntity<Coche>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Coche>(dao.modificar(coche), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Coche> delete(@PathVariable Long id) {
		try {
			dao.borrar(id);
			return new ResponseEntity<Coche>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<Coche>(HttpStatus.NOT_FOUND);
		}
	}

}
