package es.teknei.concesionario.controladores;

import javax.security.auth.Subject;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.ClassNames;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;
import com.filenet.api.util.UserContext;
import com.filenet.api.core.Document;

import es.teknei.concesionario.entidades.Marca;

@Controller
public class FilenetController {
//https://stackoverflow.com/questions/36036311/how-to-store-a-pdf-document-in-filenet

//https://stackoverflow.com/questions/11465177/file-upload-in-filenet

//https://stackoverflow.com/questions/31923654/how-to-update-a-filenet-documents-content-without-changing-the-version
	
	// Get object store instance.
	@GetMapping("/filenet")
	static void getObjectStoreInstance()    // Example: "ObjectStore1"
	 {
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, usuario, password, "FIleNetP8WSI");
		UserContext.get().pushSubject(subject);
		Domain domain = Factory.Domain.fetchInstance(conn, "Teknei", null);
	    ObjectStoreSet osColl = domain.get_ObjectStores();
		String objStoreName = "Teknei";
	    // Get object store (fetchless instantiation).
	    ObjectStore ojbStore = Factory.ObjectStore.getInstance(domain, objStoreName);

	    // Show object store name.
	    ojbStore.refresh();
	    System.out.println("Object store name: " + ojbStore.get_Name());                    
	 }
	/*public static void insertDocument(Connection conn, String domainName) {
	    // Get domain.
	    Domain domain = Factory.Domain.fetchInstance(conn, domainName, null);
	    ObjectStoreSet osColl = domain.get_ObjectStores();

	    // Get each object store.
	    Iterator iterator =  osColl.iterator();
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
	*/
	/*@GetMapping("/listados")
	public String subirFilenet(Marca marca) {
		
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, usuario, password, "FIleNetP8WSI");
		UserContext.get().pushSubject(subject);
		
		try {
			//Obtener dominio por defecto
			Domain domain = Factory.Domain.fetchInstance(conn, "Teknei", null);
			System.out.println("Domain: " + domain.get_Name());
			
			//Obtener objectos almacenados dominio
			ObjectStoreSet osSet = domain.get_ObjectStores();
			//ObjectStore store = null;
			ObjectStore objStore = Factory.ObjectStore.fetchInstance(domain, "Teknei", null);
			Iterator osIter = osSet.Iterator.next();
			
			while (osIter.hasNext()) {
				store = (ObjectStore) osIter.next();
			}
			
			Document doc = Factory.Document.createInstance(store,"Coches");
			
			doc.set_MimeType("pdf/application");
			
		} finally {
			UserContext.get().popSubject();
		}
		
		return "inicio";
	}*/

}
