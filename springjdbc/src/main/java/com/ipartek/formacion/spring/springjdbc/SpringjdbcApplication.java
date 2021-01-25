package com.ipartek.formacion.spring.springjdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.springjdbc.entidades.Cliente;
import com.ipartek.formacion.spring.springjdbc.repositorios.Dao;


import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringjdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringjdbcApplication.class, args);
	}
	
	@Autowired
	private Dao<Cliente> dao;
	
	
	@Override
	public void run(String[] args) throws Exception{
		for (Cliente cliente: dao.obtenerTodos()) {
			System.out.println(cliente);
		}
		
	}
	

}
