package es.teknei.concesionario.controladores;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.librerias.DocumentUtil;
import es.teknei.concesionario.librerias.PDFUtil;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.DaoCoche;

import java.io.InputStream;
//https://www.toolbox.com/tech/question/how-can-we-add-a-multivalue-using-api-041410/
//https://www.ibm.com/support/pages/how-get-and-set-multi-value-properties-both-cm8-and-filenet-content-engine-using-ibm-content-integrator-ici
//https://www.ibm.com/support/pages/how-do-i-set-values-multi-value-property-ibm-filenet-p8-content-engine-web-service-cews-app
//https://stackoverflow.com/questions/54564866/api-for-adding-values-into-multi-value-property-into-filenet-p8-in-java
@Controller
public class FilenetController {
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> marcaDao;
	
    
    @GetMapping("/filenet")
    public String AgregarPDF() {
    		
    	Iterable<Marca> marcas = marcaDao.obtenerTodos();
    	Iterable<Coche> listadoCoches = null;
    
    	
    	for (Marca marca:marcas) {
    		listadoCoches = cocheDao.obtenerCochePorMarca(marca.getId());
    		PDFUtil.crearPDFMarcas(listadoCoches, marca.getNombre());
    	}
    	
    	agregarFicherosDirectorio("C:\\temp\\concesionario\\", "\\ConcesionarioTeknei");

    	listadoCoches = cocheDao.obtenerTodos();
    	PDFUtil.crearPDFTodos(listadoCoches);
    	
    	return "redirect:/inicio";
    }
    

    public static void agregarFicherosDirectorio(String directory, String lFolderPath)
    {
        try {
        DocumentUtil.initialize();
        String path = directory;
        System.out.println("Los archivos PDF están en: " + path );
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

    public static void agregarFichero(File file_name, String lFolderPath)
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


	

    

}
