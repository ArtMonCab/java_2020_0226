package com.ipartek.formacion.spring.MF0226_3.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.MF0226_3.entidades.Curso;
import com.ipartek.formacion.spring.MF0226_3.repositorios.Dao;


@RestController
@RequestMapping("/api/cursos")
public class CursoApi {
	@Autowired 
	private Dao<Curso> dao;
	
	@GetMapping
	public Iterable<Curso> get() {
		return dao.obtenerTodos();
	}
	

	@GetMapping("{id}")
	public ResponseEntity<Curso> getPorId(@PathVariable int id) {
		Curso curso = dao.obtenerPorId(id);
		
		if(curso == null) {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	

}
