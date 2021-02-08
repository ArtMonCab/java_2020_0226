package com.ipartek.formacion.spring.MF0226_3.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.MF0226_3.entidades.Curso;
import com.ipartek.formacion.spring.MF0226_3.entidades.Resenya;
import com.ipartek.formacion.spring.MF0226_3.repositorios.DaoCurso;
import com.ipartek.formacion.spring.MF0226_3.repositorios.DaoResenya;



@RestController
@RequestMapping("/api")
public class GestionDocenteApi {
	@Autowired 
	private DaoCurso<Curso> daoCurso;
	private DaoResenya<Resenya> daoResenya;
	
	@GetMapping
	public Iterable<Curso> get() {
		return daoCurso.obtenerTodos();
	}
	
	public ResponseEntity<Curso> getPorId
	/*
	 	@GetMapping("{id}")
	public ResponseEntity<Cliente> getPorId(@PathVariable Long id) {
		Cliente cliente = dao.obtenerPorId(id);
		
		if(cliente == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	 */
	
}
