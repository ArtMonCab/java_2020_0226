package es.teknei.concesionario.controladores;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.web.bind.annotation.GetMapping;

import es.teknei.concesionario.entidades.Marca;

public class FilenetController {
//https://stackoverflow.com/questions/36036311/how-to-store-a-pdf-document-in-filenet

//https://stackoverflow.com/questions/11465177/file-upload-in-filenet

//https://stackoverflow.com/questions/31923654/how-to-update-a-filenet-documents-content-without-changing-the-version
	
	public static void insertDocument(Connection conn, String domainName) {
	    // Get domain.
	    Domain domain = Factory.Domain.fetchInstance(conn, domainName, null);
	    ObjectStoreSet osColl = domain.get_ObjectStores();

	    // Get each object store.
	    Iterator iterator = osColl.iterator();
	    while (iterator.hasNext()) {
	        // Get next object store.
	        ObjectStore objStore = (ObjectStore) iterator.next();

	        // Get the display name of the object store.
	        String objStoreName = objStore.get_DisplayName();
	        System.out.println("Object store name = " + objStoreName);

	        // Create a document instance.
	        Document doc = Factory.Document.createInstance(objStore, ClassNames.DOCUMENT);

	        // Set document properties.
	        doc.getProperties().putValue("DocumentTitle", "New Document via Java API");
	        doc.set_MimeType("text/plain"); // if its your pdf then set mimetype for PDF

	        doc.save(RefreshMode.NO_REFRESH);

	        // Check in the document.
	        doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
	        doc.save(RefreshMode.NO_REFRESH);

	        // File the document.
	        Folder folder = Factory.Folder.getInstance(objStore, ClassNames.FOLDER, new Id("{42A3FC29-D635-4C37-8C86-84BAC73FFA3F}")); // id of folder to which you want to store document.
	        ReferentialContainmentRelationship rcr = folder.file(doc, AutoUniqueName.AUTO_UNIQUE, "New Document via Java API",
	                DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
	        rcr.save(RefreshMode.NO_REFRESH);
	    }
	}
	
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
