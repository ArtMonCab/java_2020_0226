package com.ipartek.formacion.spring.UF1466_1;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import com.ipartek.formacion.spring.UF1466_1.entidades.Cliente;
import com.ipartek.formacion.spring.UF1466_1.repositorios.Dao;


@SpringBootApplication
public class Uf14661Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Uf14661Application.class, args);
	}

	@Autowired
	private Dao<Cliente> dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		Date fecha = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		FileWriter fw = new FileWriter(hourdateFormat.format(fecha)+".csv");
		PrintWriter pw = new PrintWriter(fw);
		
		String fila = "";
		
		System.out.println("Creando el fichero "+hourdateFormat.format(fecha)+".csv");
	
		try {
			
			fila = dao.obtenerCampos();
			pw.println(fila);
			System.out.println(fila);

			for(Cliente cliente: dao.obtenerTodos()) {
				fila  = cliente.getCodigo()+";"+
						cliente.getNombre()+";"+
						cliente.getEmail()+";"+
						cliente.getTelefono()+";"+
						cliente.getDireccion()+";"+
						cliente.getPoblacion()+";"+
						cliente.getCodigopostal()+";"+
						cliente.getIdentificador()+";"+
						cliente.getActivo();
				pw.println(fila);
				System.out.println(fila);
			
			}
			
			pw.close();
			System.out.println("Fichero "+hourdateFormat.format(fecha)+".csv completado");
			
		} catch (DataAccessException e) {
			System.out.println("Error de acceso a datos");
			System.out.println(e.getMessage());
		}
	}
	
	
}
