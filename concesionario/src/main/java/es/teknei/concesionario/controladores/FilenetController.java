package es.teknei.concesionario.controladores;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.web.bind.annotation.GetMapping;

import es.teknei.concesionario.entidades.Marca;

public class FilenetController {
//https://stackoverflow.com/questions/36036311/how-to-store-a-pdf-document-in-filenet
//https://stackoverflow.com/questions/11465177/file-upload-in-filenet
	
	
	@GetMapping("/listados")
	public String subirFilenet(Marca marca) {
		/*
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, username, password, "FIleNetP8WSI");
		UserContext.get().pushSubject(subject);
		
		try {
			//Obtener dominio por defecto
			Domain domain = Factory.Domain.fetchInstance(conn, null, null);
			System.out.printnl("Domain: " + domain.get_Name());
			
			//Obtener objectos almacenados dominio
			ObjectStoreSet osSet = domain.get_ObjectStores();
			ObjectStore store = null
			Iterator osIter = osSet.iterator.netx();
			
			while (osIter.hasNext()) {
				store = (ObjectStore) osIter.next();
			}
			
			Document doc = Factory.Document.createInstance(store,"Coches");
			
			doc.set_MineType("pdf/application");
			
		} finally {
			USerContext.get().popSubject();
		}
		*/
		return "inicio";
	}

}
