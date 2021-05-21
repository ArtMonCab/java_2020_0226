                                                                                                                                                                   package es.teknei.concesionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import es.teknei.concesionario.repositorios.CocheRepository;
import es.teknei.concesionario.repositorios.MarcaRepository;

@SpringBootApplication
@RestController
public class ConcesionarioApplication implements CommandLineRunner{
	
	//@Autowired
	//private Dao<Coche> daoCoches;
	
	//@Autowired
	//private MarcaDao daoMarcas;
	
	@Autowired
	private CocheRepository coches;
	
	@Autowired
	private MarcaRepository marcas;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*System.out.println(daoCoches.obtenerPorId(2L));
		
		Marca marca = daoMarcas.obtenerporIdConCoches(1L);
		
		System.out.println(marca);

		for (Coche coche : marca.getCoches()) {
			System.out.println(coche);
		}*/
		
		mostrarDatos();
	}
	
	@Transactional
	private void mostrarDatos() {
		System.out.println(coches.findById(2L).orElse(null));
		System.out.println(coches.findAll());

		System.out.println(marcas.findById(1L).orElse(null));
		System.out.println(marcas.findAll());


	}
	
	
}
