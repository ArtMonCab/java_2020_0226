package es.teknei.concesionario.controladores;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.teknei.concesionario.librerias.DocumentUtil;

import java.io.InputStream;

@Controller
public class FilenetController {
	
	
    
    @GetMapping("/filenet")
    public void prueba() {
    	agregarFicherosDirectorio("C:\\temp\\", "\\ConcesionarioTeknei");
    	System.out.println("Prueba de Filenet");
    }
    

    public static void agregarFicherosDirectorio(String directory, String lFolderPath)
    {
        try {
        DocumentUtil.initialize();
        String path = directory;
        System.out.println("This is the path -> " + path + "*");
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
