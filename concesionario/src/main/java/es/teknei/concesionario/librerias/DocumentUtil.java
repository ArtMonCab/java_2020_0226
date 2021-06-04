package es.teknei.concesionario.librerias;

	
import java.io.InputStream;
import java.util.List;

import javax.security.auth.Subject;

import com.filenet.api.collection.ContentElementList;
import com.filenet.api.constants.AutoClassify;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.CheckinType;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Connection;
import com.filenet.api.core.ContentTransfer;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;
import com.filenet.api.util.UserContext;

		public class DocumentUtil {

		    public static ObjectStore objectStore = null;
		    public static Domain domain = null;
		    public static Connection conn = null;


		    public static void initialize()
		    {		    	
		    	
				//Parametros conexión
				String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
				String usuario ="Arturo";
				String password ="Hola1234$";
				
				//Hacer la conexión
				conn = Factory.Connection.getConnection(uri);
				Subject subject = UserContext.createSubject(conn, usuario, password, "FileNetP8WSI");
				UserContext.get().pushSubject(subject);
				
		        domain = Factory.Domain.getInstance(conn, null);
		        objectStore = Factory.ObjectStore.fetchInstance(domain, "Teknei", null);
		        System.out.println("\n\n objectStore--> " + objectStore.get_DisplayName());
		    }

		    public static void addDocumentWithPath(String folderPath, String filePath,
		            String mimeType, String docName, String docClass) {

		        Folder folder = Factory.Folder.fetchInstance(objectStore,
		                folderPath, null);

		        System.out.println("\n\n Folder ID: " + folder.get_Id());
		        // Document doc = Factory.Document.createInstance(os, classId);

		        //Document doc = CEUtil.createDocNoContent(mimeType, objectStore, new File(filePath), docClass);
		        Document doc = CEUtil.createDocNoContent(mimeType, objectStore, filePath, docClass);
		        doc.save(RefreshMode.REFRESH);

		        doc = CEUtil.createDocNoContent(mimeType, objectStore, docName, docClass);
		        doc.save(RefreshMode.REFRESH);
		        CEUtil.checkinDoc(doc);
		        ReferentialContainmentRelationship rcr = CEUtil.fileObject(objectStore, doc, folderPath);
		        rcr.save(RefreshMode.REFRESH);

		    }

		    public static void addDocumentWithStream(String folderPath,
		            InputStream inputStream, String mimeType, 
		            String docName, String docClass) {

		        Folder folder = Factory.Folder.fetchInstance(objectStore,
		                folderPath, null);

		        System.out.println("\n\n Folder ID: " + folder.get_Id());
		        // Document doc = Factory.Document.createInstance(os, classId);

		        Document doc = Factory.Document.createInstance(objectStore, null);

		        ContentElementList contEleList = Factory.ContentElement.createList();
		        ContentTransfer ct = Factory.ContentTransfer.createInstance();

		        ct.setCaptureSource(inputStream);
		        ct.set_ContentType(mimeType);
		        ct.set_RetrievalName(docName);
		        contEleList.add(ct);

		        doc.set_ContentElements(contEleList);
		        doc.getProperties().putValue("DocumentTitle", docName);

		        doc.set_MimeType(mimeType);
		        doc.checkin(AutoClassify.AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		        doc.save(RefreshMode.REFRESH);

		        ReferentialContainmentRelationship rcr = folder.file(doc,
		                AutoUniqueName.AUTO_UNIQUE, docName, 
		                DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		        rcr.save(RefreshMode.REFRESH);
		        /*

		        doc.save(RefreshMode.REFRESH);

		        doc = CEUtil.createDocNoContent(mimeType, objectStore, docName, docClass);

		        CEUtil.checkinDoc(doc);
		        ReferentialContainmentRelationship rcr = CEUtil.fileObject(objectStore, doc, folderPath);
		        rcr.save(RefreshMode.REFRESH);
		        */
		    }
		    
		    public static void addDocumentWithStreamProperties(String folderPath,
		            InputStream inputStream, String mimeType, 
		            String docName, String docClass, List<String> marca, List<String> modelo, List<String> matricula) {

		        Folder folder = Factory.Folder.fetchInstance(objectStore,
		                folderPath, null);

		        System.out.println("\n\n Folder ID: " + folder.get_Id());
		        // Document doc = Factory.Document.createInstance(os, classId);

		        Document doc = Factory.Document.createInstance(objectStore, "Coches");
		        //Document doc = Factory.Document.getInstance(objectStore,"Coches",
		        ContentElementList contEleList = Factory.ContentElement.createList();
		        ContentTransfer ct = Factory.ContentTransfer.createInstance();

		        ct.setCaptureSource(inputStream);
		        ct.set_ContentType(mimeType);
		        ct.set_RetrievalName(docName);
		        contEleList.add(ct);
		      
		        doc.set_ContentElements(contEleList);
		        doc.getProperties().putValue("DocumentTitle", docName);
		        doc.getProperties().putValue("Marca", String.valueOf(marca));
		        doc.getProperties().putValue("Modelo", String.valueOf(modelo));
		        doc.getProperties().putValue("Matricula", String.valueOf(matricula));
		        
		        doc.set_MimeType(mimeType);
		        doc.checkin(AutoClassify.AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
		        doc.save(RefreshMode.REFRESH);

		        ReferentialContainmentRelationship rcr = folder.file(doc,
		                AutoUniqueName.AUTO_UNIQUE, docName, 
		                DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
		        rcr.save(RefreshMode.REFRESH);
		        /*

		        doc.save(RefreshMode.REFRESH);

		        doc = CEUtil.createDocNoContent(mimeType, objectStore, docName, docClass);

		        CEUtil.checkinDoc(doc);
		        ReferentialContainmentRelationship rcr = CEUtil.fileObject(objectStore, doc, folderPath);
		        rcr.save(RefreshMode.REFRESH);
		        */
		    }

		    public static ObjectStore getObjectStore()
		    {
		        if (objectStore != null) {
		            return objectStore;
		        }

				//Parametros conexión
				String uri = "http://34.234.153.200/wsi/FNCEWS40MTOM";
				String usuario ="Arturo";
				String password ="Hola1234$";
				
				//Hacer la conexión
				Connection conn = Factory.Connection.getConnection(uri);
				Subject subject = UserContext.createSubject(conn, usuario, password, "FileNetP8WSI");
				UserContext.get().pushSubject(subject);
				
		        try {
		            // Get default domain.
		            Domain domain = Factory.Domain.getInstance(conn, null);


		            // Get object stores for domain.
		            objectStore = Factory.ObjectStore.fetchInstance(domain, "TARGET",
		                    null);

		            System.out.println("\n\n Connection to Content Engine successful !!");
		        } finally {
		            UserContext.get().popSubject();
		        }

		        return objectStore;

		    }

		}
