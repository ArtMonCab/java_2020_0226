package es.teknei.concesionario.controladores;

import javax.security.auth.Subject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.filenet.api.collection.ObjectStoreSet;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.ClassNames;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Connection;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;
import com.filenet.api.util.Id;
import com.filenet.api.util.UserContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import es.teknei.concesionario.entidades.Marca;

@Controller
public class FilenetController {
//https://stackoverflow.com/questions/36036311/how-to-store-a-pdf-document-in-filenet

//https://stackoverflow.com/questions/11465177/file-upload-in-filenet

//https://stackoverflow.com/questions/31923654/how-to-update-a-filenet-documents-content-without-changing-the-version
	
	
	
	 // Instantiate object store from domain.
    /*public static void instanciar() // Example: "Domain1"
    {
   	 
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, usuario, password, "FileNetP8WSI");
		UserContext.get().pushSubject(subject);
		Domain domain = Factory.Domain.fetchInstance(conn, "Teknei", null);
	    ObjectStoreSet osColl = domain.get_ObjectStores();
	    // Get each object store.
	    Iterator iterator = osColl.iterator();
	    while(iterator.hasNext())
	    {
	        // Get next object store.
	        ObjectStore objStore = (ObjectStore)iterator.next();
	                        
	        // Get the display name of the object store.
	        String objStoreName = objStore.get_DisplayName();
	        System.out.println("Object store name = " + objStoreName); 
	    }
    }*/
    
    @GetMapping("/filenet")
    public void prueba() {
    	//crearDocumento();
    	//instanciar();
    	insertDocument();
    	System.out.println("Prueba de Filenet");
    }
    

    public static void addfiles_toicm(String directory, String lFolderPath)
    {
        try {
        DocumentUtil.initialize();
        String path = directory;
        System.out.println("This is the path:..............................."
                + path);
        String file_name;
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile())
            {
                file_name = listOfFiles[i].getName();
                System.out.println(file_name);
                String filePaths = directory + file_name;
                // File file = new File("C:\\FNB\\att.jpg");
                File file = new File(filePaths);
                InputStream attStream = null;
                    attStream = new FileInputStream(file);
                DocumentUtil.addDocumentWithStream(lFolderPath, attStream,
                        "pdf/application", file_name, "Document");
            }
        }
        } catch (FileNotFoundException e) 
        {
        e.printStackTrace();
         }
    }//end of method

    public static void addfile_toicm(File file_name, String lFolderPath)
    {
        try {
        DocumentUtil.initialize();
                InputStream attStream = null;
                    attStream = new FileInputStream(file_name);
                DocumentUtil.addDocumentWithStream(lFolderPath, attStream,
                        "image/jpeg", file_name.getName(), "Document");
                System.out.println("File added successfully");
        } catch (Exception e) 
        {
        System.out.println(e.getMessage());
       }
    }//end of method


	
	//@GetMapping("/listados")
	//public String subirFilenet(Marca marca) {
    /*public String insertDocument() {	
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, usuario, password, "FileNetP8WSI");
		UserContext.get().pushSubject(subject);
		
		try {
			//Obtener dominio por defecto
			Domain domain = Factory.Domain.fetchInstance(conn, null, null);
			System.out.println("Domain: " + domain.get_Name());
			
			//Obtener objectos almacenados dominio
			ObjectStoreSet osSet = domain.get_ObjectStores();
			ObjectStore store = null;
			//ObjectStore objStore = Factory.ObjectStore.fetchInstance(domain, "Teknei", null);
			Iterator osIter = osSet.iterator();
			
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
    
    /*public void crearDocumento() {
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, usuario, password, "FileNetP8WSI");
		UserContext.get().pushSubject(subject);
		
		
		//Obtener dominio por defecto
		Domain domain = Factory.Domain.fetchInstance(conn, null, null);
		System.out.println("Domain: " + domain.get_Name());
		
		//Obtener objectos almacenados dominio
		ObjectStoreSet osSet = domain.get_ObjectStores();
		//ObjectStore os = null;
		ObjectStore os = Factory.ObjectStore.fetchInstance(domain, "Teknei", null);
    	// Get document.
    	
    	Document doc=Factory.Document.getInstance(os, ClassNames.DOCUMENT, new Id("{8FD91CF0-E991-426D-9BCB-B63F0E30E604}") );

    	// Check out the Document object and save it.
    	doc.checkout(com.filenet.api.constants.ReservationType.EXCLUSIVE, null, doc.getClassName(), doc.getProperties());
    	doc.save(RefreshMode.REFRESH);

    	// Get the Reservation object from the Document object.
    	Document reservation = (Document) doc.get_Reservation();

    	// Specify internal and external files to be added as content.
    	File internalFile = new File("C:\temp\renault.pdf");
    	// non-Windows: File internalFile = new File("/tmp/docs/mydoc.txt");
    	//String externalFile = "ftp://ftp.mycompany.com/docs/relnotes.txt";

    	// Add content to the Reservation object.
    	try {
    	    // First, add a ContentTransfer object.
    	    ContentTransfer ctObject = Factory.ContentTransfer.createInstance();
    	    FileInputStream fileIS = new FileInputStream(internalFile.getAbsolutePath());
    	    ContentElementList contentList = Factory.ContentTransfer.createList();
    	    ctObject.setCaptureSource(fileIS);
    	    // Add ContentTransfer object to list.
    	    contentList.add(ctObject);

    	    // Second, add a ContentReference object.
    	    ContentReference crObject = Factory.ContentReference.createInstance(os);
    	    //crObject.set_ContentLocation(externalFile);
    	    crObject.set_ContentType("pdf/application"); // Must be set for ContentReference.
    	    // Add ContentReference object to list.
    	    contentList.add(crObject);

    	    reservation.set_ContentElements(contentList);
    	    reservation.save(RefreshMode.REFRESH);
    	    }
    	catch (Exception e)
    	{
    	    System.out.println(e.getMessage() );
    	}

    	// Check in Reservation object as major version.
    	reservation.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
    	reservation.save(RefreshMode.REFRESH);

}*/
    
    public static void insertDocument() {
		//Parametros conexión
		String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
		String usuario ="Arturo";
		String password ="Hola1234$";
		String domainName = "Teknei";
		//Hacer la conexión
		Connection conn = Factory.Connection.getConnection(uri);
		Subject subject = UserContext.createSubject(conn, usuario, password, "FileNetP8WSI");
		UserContext.get().pushSubject(subject);
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
            doc.set_MimeType("pdf/application"); // if its your pdf then set mimetype for PDF

            doc.save(RefreshMode.NO_REFRESH);

            // Check in the document.
            doc.checkin(AutoClassify.DO_NOT_AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
            doc.save(RefreshMode.NO_REFRESH);

            // File the document.
            Folder folder = Factory.Folder.getInstance(objStore, ClassNames.FOLDER, new Id("{20CAC079-0000-CB1C-B882-323B9F581CD9}")); // id of folder to which you want to store document.
            ReferentialContainmentRelationship rcr = folder.file(doc, AutoUniqueName.AUTO_UNIQUE, "New Document via Java API",
                    DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
            rcr.save(RefreshMode.NO_REFRESH);
        }
    }
}
