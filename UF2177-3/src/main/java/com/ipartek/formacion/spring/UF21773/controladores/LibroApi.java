package com.ipartek.formacion.spring.UF21773.controladores;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.UF21773.entidades.Libro;
import com.ipartek.formacion.spring.UF21773.entidades.Resena;
import com.ipartek.formacion.spring.UF21773.repositorio.LibroDaoJdbcTemplate;
import com.ipartek.formacion.spring.UF21773.repositorio.ResenaDaoJdbcTemplate;


@RestController
@RequestMapping("/api/libros")
public class LibroApi {
	
	private static final Logger LOGGER = Logger.getLogger(LibroApi.class.getName());
	
	@Autowired
	private LibroDaoJdbcTemplate dao;
	
	@GetMapping
	public Iterable<Libro> get(){
		return dao.obtenerTodos();
	}
	

	
	

}
