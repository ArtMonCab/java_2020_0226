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
import java.util.ArrayList;
import java.util.List;
@Controller
public class FilenetController {
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> marcaDao;
	
    
    @GetMapping("/filenet")
    public String AgregarPDF() {
    	//Creo los PDF's de cada Marca y los subo a Filenet
    	Iterable<Marca> marcas = marcaDao.obtenerTodos();
    	Iterable<Coche> coches = null;
    
    	
    	for (Marca marca:marcas) {
    		coches = cocheDao.obtenerCochePorMarca(marca.getId());
    		PDFUtil.crearPDFMarcas(coches, marca.getNombre());
    	}
    	
    	agregarFicherosDirectorio("C:\\temp\\", "\\ConcesionarioTeknei");

    	//Creo el PDF con todos los coches, le añado atributos multivalor y lo subo a Filenet
    	coches = cocheDao.obtenerTodos();
    	PDFUtil.crearPDFTodos(coches);
    	
    	//Les introduzco los valores del os atributos
    	

    	
    	List<String> marca = new ArrayList<String>();
    	List<String> modelo = new ArrayList<String>();
    	List<String> matricula = new ArrayList<String>();
    	
    	//Relleno los strings con lso valores del os atributos
    	for (Coche coche:coches) {
    		marca.add(coche.getMarca().getNombre());
    		modelo.add(coche.getModelo());
    		matricula.add(coche.getMatricula());
    	}
    	
    	System.out.println("--------------------------");
    	System.out.println(marca);
    	System.out.println(modelo);
    	System.out.println(matricula);
    	System.out.println("------------------------");
    	//doc.getProperties().putValue( accountNumbers, String.valueOf( accountNumbersSplit) )
    	
    	File fichero = new File("c:/temp/todos/Coches.pdf");
    	agregarFichero(fichero, "\\ConcesionarioTeknei", marca, modelo, matricula);
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

    public static void agregarFichero(File file_name, String lFolderPath, List<String> marca, List<String> modelo, List<String> matricula)
    {
        try {
        DocumentUtil.initialize();
                InputStream attStream = null;
                    attStream = new FileInputStream(file_name);
                DocumentUtil.addDocumentWithStreamProperties(lFolderPath, attStream,
                        "pdf/application", file_name.getName(), "Document", marca, modelo, matricula);
                System.out.println("Fichero agregado con exito");
        } catch (Exception e) 
        {
        System.out.println(e.getMessage());
       }
    }//end of method


	

    

}
