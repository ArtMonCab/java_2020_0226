package es.teknei.concesionario.controladores;

	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
		    public static Connection connection = null;


		    public static void main(String[] args)
		    {
		        initialize();
		        /*
		        addDocumentWithPath("/FNB", "C:\\Users\\Administrator\\Desktop\\Sample.txt.txt",
		                "text/plain", "NNN", "Document");
		        */
		        File file = new File("E:\\Users\\Administrator\\Desktop\\TT.txt");

		        FileInputStream fis = null;
		        try {
		            fis = new FileInputStream(file);
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }

		        addDocumentWithStream("/FNB", fis, "text/plain", "My New Doc", "Document");
		    }

		    public static void initialize()
		    {

		        System.setProperty("WASP.LOCATION", "C:\\Progra~1\\IBM\\WebSphere\\AppServer\\profiles\\AppSrv01\\installedApps\\P8Node01Cell\\FileNetEngine.ear \\cews.war\\WEB-INF\\classes\\com\\filenet\\engine\\wsi");
		        System.setProperty("SECURITY.AUTH.LOGIN.CONFIG",
		                "C:\\Progra~1\\IBM\\WebSphere\\AppServer\\profiles\\AppSrv01\\installedApps\\P8Node01Cell\\FileNetEngine.ear\\client-download.war\\FileNet\\Download\\dap501.153\\jaas.conf.wsi");
		        System.setProperty(":SECURITY.AUTH.LOGIN.CONFIG",
		                "C:\\Progra~1\\IBM\\WebSphere\\AppServer\\profiles\\AppSrv01\\installedApps\\P8Node01Cell\\FileNetEngine.ear\\client-download.war\\FileNet\\Download\\dap501.153\\jaas.conf.wsi");
		        System.setProperty("java.security.auth.login.config","C:\\Progra~1\\IBM\\WebSphere\\AppServer\\java\\jre");
		        connection = Factory.Connection.getConnection(CEConnection.uri);
		        Subject sub = UserContext.createSubject(connection,
		                com.user.CEConnection.username, CEConnection.password,
		                CEConnection.stanza);
		        UserContext.get().pushSubject(sub);
		        domain = Factory.Domain.getInstance(connection, null);
		        objectStore = Factory.ObjectStore.fetchInstance(domain, "TARGET", null);
		        System.out.println("\n\n objectStore--> " + objectStore.get_DisplayName());
		    }

		    public static void addDocumentWithPath(String folderPath, String filePath,
		            String mimeType, String docName, String docClass) {

		        Folder folder = Factory.Folder.fetchInstance(objectStore,
		                folderPath, null);

		        System.out.println("\n\n Folder ID: " + folder.get_Id());
		        // Document doc = Factory.Document.createInstance(os, classId);

		        Document doc = CEUtil.createDocWithContent(new File(filePath), mimeType, 
		                objectStore, docName, docClass);

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

		    public static ObjectStore getObjecctStore()
		    {
		        if (objectStore != null) {
		            return objectStore;
		        }

		        // Make connection.
		        com.filenet.api.core.Connection conn = Factory.Connection
		                .getConnection(CEConnection.uri);
		        Subject subject = UserContext.createSubject(conn,
		                CEConnection.username, CEConnection.password, null);
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
