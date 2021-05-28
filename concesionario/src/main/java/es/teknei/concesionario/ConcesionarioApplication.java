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
	
/*
 https://stackoverflow.com/questions/29313687/trying-to-use-spring-boot-rest-to-read-json-string-from-post
 https://parzibyte.me/blog/2020/09/07/api-rest-spring-boot-mysql/
 https://juanda.gitbooks.io/webapps/content/api/arquitectura-api-rest.html
 https://www.arquitecturajava.com/spring-rest-service-con-restcontroller/
 https://aprenderaprogramar.com/foros/index.php?topic=2270.0
 https://stackoverflow.com/questions/32045271/how-to-pass-thobject-values-from-html-to-controller
 https://www.javascripttutorial.net/javascript-dom/javascript-select-box/#:~:text=The%20element%20allows%20you,value%20of%20the%20selected%20option.
 https://es.stackoverflow.com/questions/329084/llenar-campo-select-html-a-partir-de-consulta
 https://es.stackoverflow.com/questions/184974/c%C3%B3mo-obtener-valor-de-un-select-thymeleaf
 https://www.baeldung.com/spring-rest-template-list
 https://spring.io/guides/gs/consuming-rest/
 https://sacavix.com/2020/03/07/consumo-de-api-rest-con-spring-boot/
 https://www.google.com/search?q=llamar+a+apirest+desde+java+spring+boot&rlz=1C1GCEA_enES842ES842&oq=llamar+a+apirest+desde+java&aqs=chrome.2.69i57j33i22i29i30l3.10457j0j7&sourceid=chrome&ie=UTF-8
 https://www.baeldung.com/spring-controller-vs-restcontroller
 https://www.bing.com/search?q=restcontroller+spring+html&cvid=2d8c23fa1fdb45cbb8c0fc5ba2c45f50&aqs=edge..69i57.6476j0j1&pglt=43&FORM=ANNTA1&PC=U531
 https://stackoverflow.com/questions/38700790/how-to-return-a-html-page-from-a-restful-controller-in-spring-boot
*/

@SpringBootApplication
public class ConcesionarioApplication{ // implements CommandLineRunner{
	
	/*@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> marcaDao;
	
	@Autowired
	private CocheRepository coches;
	
	@Autowired
	private MarcaRepository marcas;*/
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}


	
	/*@Override
	public void run(String... args) throws Exception {
		System.out.println(cocheDao.obtenerCochePorMarca(1L));
		
        
	}
	
	@Transactional
	private void mostrarDatos() {
		System.out.println(coches.findById(2L).orElse(null));
		System.out.println(coches.findAll());

		System.out.println(marcas.findById(1L).orElse(null));
		System.out.println(marcas.findAll());


	}*/
	
	
}
