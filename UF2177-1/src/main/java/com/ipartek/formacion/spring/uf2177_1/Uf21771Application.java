package com.ipartek.formacion.spring.uf2177_1;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;

import com.ipartek.formacion.spring.uf2177_1.entidades.Medicamento;
import com.ipartek.formacion.spring.uf2177_1.repositorios.Dao;

@SpringBootApplication
public class Uf21771Application implements CommandLineRunner {
	
	static final protected String OP_LISTADO = "1";
	static final protected String OP_ALTA = "2";
	static final protected String OP_BAJA = "3";
	static final protected String OP_MODIFICACION = "4";
	static final protected String OP_MOSTRAR = "5";
	static final protected String OP_SALIR = "S";
	static final protected String NOMBRE_OBJETO = "medicamento";
	static String opcion = "";
	static private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(Uf21771Application.class, args);
	}
	
	@Autowired
	private Dao<Medicamento> dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		boolean salir = false;
		
		do {
			crearMenu(NOMBRE_OBJETO);
			
			opcion = sc.nextLine();	
			
			try {
				switch (opcion.toUpperCase()) { 
				
				case OP_LISTADO:
					listado();
					break;
				case OP_ALTA:
					alta(true);
					break;	
				case OP_BAJA:
					baja();
					break;
				case OP_MODIFICACION:
					alta(false);
					break;
				case OP_MOSTRAR:
					mostrar();
					break;
				case OP_SALIR:
					salir = true;
					System.out.println("***********  Programa finalizado   **************");
					break;
				default:
						System.out.println("Escoge una opcion correcta");
				}
				
				
			} catch (DataAccessException e) {
				System.out.println("Error de base de datos");
				e.printStackTrace();
			}
			

		}while(!salir);
		
		sc.close();
				
	}
	
	protected static void crearMenu( final String nombreObjeto ) {
		
		System.out.println("");
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("");
		System.out.println("***********  GESTION DE FARMACIA   **************");

		System.out.println("*************************************************");
		System.out.println(" " + OP_LISTADO + ".- Listar todos los " + nombreObjeto + "s");
		System.out.println(" " + OP_ALTA + ".- Dar de alta un " +nombreObjeto);
		System.out.println(" " + OP_BAJA + ".- Dar de baja un " + nombreObjeto);
		System.out.println(" " + OP_MODIFICACION + ".- Modificar un " + nombreObjeto);
		System.out.println(" " + OP_MOSTRAR + ".- Mostrar un " + nombreObjeto);
		System.out.println(" ");
		System.out.println(" " + OP_SALIR + " - Salir");
		System.out.println("*************************************************");
		
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("");
		System.out.println("Introduzca una opción: ");
		System.out.println("");

	}
	
	protected void listado() {
		for(Medicamento medicamento: dao.obtenerTodos()) {
			System.out.println("Id.: "+medicamento.getId()+" - Ref.: "+medicamento.getReferencia()+" - Nombre: "+medicamento.getNombre()+" - Precio:"+medicamento.getPrecio());
		}
	}
	
	protected void alta(boolean nuevo) {
		String referencia;
		String nombre;
		long id = 0;
		double precio = 0;
		Medicamento medicamento;
		boolean repetir = true;
		
		if(!nuevo) {
			do {
				try {
					System.out.println("Introduzca el ID del "+NOMBRE_OBJETO+" que desea ver");
					id =Long.parseLong(sc.nextLine());
					medicamento = dao.obtenerPorId(id);
					System.out.println("Id.: "+medicamento.getId()+
							" - Referencia: "+medicamento.getReferencia()+
							" - Nombre: "+medicamento.getNombre()+
							" - Precio: "+medicamento.getPrecio());
					
					repetir = false;
				}catch(Exception e) {
					System.out.println("El ID es incorrecto ");
				}
			}while (repetir);
				
		}
		
		repetir = true;
		
		do {
			System.out.println("Introduzca la referencia del "+NOMBRE_OBJETO+": ");
			referencia = sc.nextLine();
			if (!referencia.isEmpty() && !referencia.equals(" ") && referencia != null) {
				repetir = false;
			}
		}while (repetir);
		
		repetir = true;
		
		do {
			System.out.println("Introduzca el nombre del "+NOMBRE_OBJETO+": ");
			nombre = sc.nextLine();
			if (!nombre.isEmpty() && !nombre.equals(" ") && nombre != null) {
				repetir = false;
			}
		}while (repetir);
		
		repetir = true;
		
		do {
			try {
				System.out.println("Introduzca el precio del "+NOMBRE_OBJETO+": ");
				precio = Double.parseDouble(sc.nextLine());
				repetir = false;
			}catch (Exception E){
				System.out.println("El precio tiene un valor numérico");
				repetir = true;
			}
		}while (repetir);
		
		if (nuevo) {
			dao.agregar(new Medicamento(id, referencia,nombre, precio));
		}else {
			dao.modificar(new Medicamento(id, referencia,nombre, precio));
		}
	}
	
	protected void baja() {
		String referencia;
		Long id;
		boolean salir = false;
		
		listado();
		
		
		System.out.println("");
		System.out.println("--------------Baja de medicamento----------------");
		System.out.println("");
		System.out.println("1. Baja por referencia");
		System.out.println("2. Baja por identificador");
		System.out.println("");
		System.out.println("-------------------------------------------------");

		
		do {
			System.out.println("");
			System.out.println("Elija entre la opción 1 y y la opción 2: ");
			System.out.println(""); 
			opcion = sc.nextLine();	
			
			if (opcion.equals("1")){
				System.out.println("Introduzca la referencia del medicamento que desea eliminar");
				referencia = sc.nextLine();
				try {
					dao.borrarPorRef(referencia);
				}catch(Exception e) {
					System.out.println("El medicamento con la referencia "+referencia+" no existe");
				}
				salir = true;
			}	
			
			
			if (opcion.equals("2")) {
				System.out.println("Introduzca el identificador del medicamento que desea eliminar");
				
				id = Long.parseLong(sc.nextLine());
				try {
					dao.borrar(id);
				}catch(Exception e) {
					System.out.println("El medicamento con el id "+id+" no existe");
				}

				salir = true;
		
			}
		
			
		}while (!salir);
		

	}
	

	protected void mostrar() {
		long id;
		Medicamento medicamento;
		System.out.println("Introduzca el ID del medicamento que desea ver");
		id = Long.parseLong(sc.nextLine());
		try {
			medicamento = dao.obtenerPorId(id);
			System.out.println("Id.: "+medicamento.getId()+
					" - Referencia: "+medicamento.getReferencia()+
					" - Nombre: "+medicamento.getNombre()+
					" - Precio: "+medicamento.getPrecio());
		}catch (Exception e) {
			System.out.println("No existe ningún medicamento con ese ID");
		}
	}

}
