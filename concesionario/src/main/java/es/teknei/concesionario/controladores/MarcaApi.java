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

import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;



@RestController
@RequestMapping("/api/marcas")
public class MarcaApi {
	@Autowired
	private Dao<Marca> dao;
	
	@GetMapping
	public Iterable<Marca> get() {
		return dao.obtenerTodos();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Marca> getPorId(@PathVariable Long id) {
		Marca marca = dao.obtenerPorId(id);
		
		if(marca == null) {
			return new ResponseEntity<Marca>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Marca>(marca, HttpStatus.OK);
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Marca post(@RequestBody Marca marca) {
		return dao.insertar(marca);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Marca> put(@PathVariable Long id, @RequestBody Marca marca) {
		if(id != marca.getId()) {
			return new ResponseEntity<Marca>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Marca>(dao.modificar(marca), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Marca> delete(@PathVariable Long id) {
		try {
			dao.borrar(id);
			return new ResponseEntity<Marca>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<Marca>(HttpStatus.NOT_FOUND);
		}
	}


}
