package com.ipartek.formacion.spring.springjdbc;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import com.ipartek.formacion.spring.springjdbc.entidades.Cliente;
import com.ipartek.formacion.spring.springjdbc.repositorios.Dao;

@SpringBootApplication
public class SpringjdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringjdbcApplication.class, args);
	}

	@Autowired
	private Dao<Cliente> dao;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			//Se pasa el null al id porque la BD ya se encarga de rellenarlo
			//Se puede hacer también haciendo otro constructor
			dao.agregar(new Cliente(null, "Perico", "De Los Palotes", "12345678A", LocalDate.now()));
			
			dao.modificar(new Cliente(2L, "John", "Smith", "76543321Z", LocalDate.now()));
			
			dao.borrar(7L);
			
			for(Cliente cliente: dao.obtenerTodos()) {
				System.out.println(cliente);
			}
			
			System.out.println(dao.obtenerPorId(1L));
		} catch (DataAccessException e) {
			System.out.println("Error de acceso a datos");
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

}
