package com.ipartek.formacion.spring.uf2177_1;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import com.ipartek.formacion.spring.uf2177_1.entidades.Medicamento;
import com.ipartek.formacion.spring.uf2177_1.repositorios.Dao;

@SpringBootApplication
public class Uf21771Application {

	public static void main(String[] args) {
		SpringApplication.run(Uf21771Application.class, args);
	}
	
	@Autowired
	private Dao<Medicamento> dao;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			//Se pasa el null al id porque la BD ya se encarga de rellenarlo
			//Se puede hacer también haciendo otro constructor
			//dao.agregar(new Medicamento(null, "Perico", "De Los Palotes", "12345678A", LocalDate.now()));
			
			//dao.modificar(new Medicamento(2L, "John", "Smith", "76543321Z", LocalDate.now()));
			
			//dao.borrar(7L);
			
			for(Medicamento medicamento: dao.obtenerTodos()) {
				System.out.println(medicamento);
			}
			
			System.out.println(dao.obtenerPorId(1L));
		} catch (DataAccessException e) {
			System.out.println("Error de acceso a datos");
			e.printStackTrace();
		}
	}
}
