package es.teknei.concesionario.librerias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import es.teknei.concesionario.entidades.Coche;

public class PDFUtil {
	
    public static void crearPDFMarcas(Iterable<Coche> coches, String marca) {
    	
    	Document documento = new Document();

    	try {
    		String FILE_NAME = "c:/temp/" + marca + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(new File(FILE_NAME)));
            
            documento.open();
            
            documento.add(new Paragraph("Fichero " + marca + ".pdf"));
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(2);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla.addCell("Modelo");
            tabla.addCell("Matrícula");
            for (Coche coche:coches) {
            	tabla.addCell(coche.getModelo());
            	tabla.addCell(coche.getMatricula());
            }

            documento.add(tabla);

            documento.close();
            
    		
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
    
    public static void crearPDFTodos(Iterable<Coche> coches) {
    	
    	Document documento = new Document();

    	try {
    		String FILE_NAME = "c:/temp/concesionarios/todos/Coches.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(new File(FILE_NAME)));
            
            documento.open();
            
            documento.add(new Paragraph("Coches.pdf"));
            documento.add(new Paragraph(" "));
            
            PdfPTable tabla = new PdfPTable(3);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla.addCell("Modelo");
            tabla.addCell("Modelo");
            tabla.addCell("Matrícula");
            for (Coche coche:coches) {
            	tabla.addCell(coche.getMarca().getNombre());
            	tabla.addCell(coche.getModelo());
            	tabla.addCell(coche.getMatricula());
            }

            documento.add(tabla);

            documento.close();
            
    		
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    	
    }

}
