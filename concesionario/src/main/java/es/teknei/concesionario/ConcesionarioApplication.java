                                                                                                                                                                   package es.teknei.concesionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.DaoCoche;


@SpringBootApplication
public class ConcesionarioApplication implements CommandLineRunner{
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> marcaDao;
	
	/*@Autowired
	private CocheRepository coches;
	
	@Autowired
	private MarcaRepository marcas;*/
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}


	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(cocheDao.obtenerCochePorMarca(1L));
		
        
	}
	
	/*@Transactional
	private void mostrarDatos() {
		System.out.println(coches.findById(2L).orElse(null));
		System.out.println(coches.findAll());

		System.out.println(marcas.findById(1L).orElse(null));
		System.out.println(marcas.findAll());


	}*/
	
	
}
