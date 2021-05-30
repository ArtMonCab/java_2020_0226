package es.teknei.concesionario.controladores;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;
import es.teknei.concesionario.repositorios.Dao;
import es.teknei.concesionario.repositorios.DaoCoche;




@Controller
public class InicioController {
	
	@Autowired
	private DaoCoche cocheDao;
	
	@Autowired
	private Dao<Marca> marcaDao;
	
	@RequestMapping("/listado")
	public String listadoCoches(Model modelo) {
		modelo.addAttribute("marcas", marcaDao.obtenerTodos());
		return "listado";
	}
	
	@GetMapping("/listado")
	public String cargarCoches(Model modelo) {
		modelo.addAttribute("marcas", marcaDao.obtenerTodos());
		return "listado";
	}
	
    @PostMapping("/listado")
    public String marcasPost(@ModelAttribute("coches") Coche coches, Model modelo) {
    	Iterable<Coche> listadoCoches = cocheDao.obtenerCochePorMarca(coches.getMarca().getId());
    	
    	
    	modelo.addAttribute("coches", listadoCoches);
    	
    	String marca = coches.getMarca().getNombre();
    	
    	crearPDF(listadoCoches, marca);

    	modelo.addAttribute("marcas", marcaDao.obtenerTodos());
    	
    	
        return "listado";
    }
    
	

	@RequestMapping("/alta")
	public String altaCoche(Model modelo) {
		
		modelo.addAttribute("marcas", marcaDao.obtenerTodos());
		return "alta";
	}

	@PostMapping("/alta")
	public String cochePost(Coche coche) {
		
		cocheDao.insertar(coche);

		return "redirect:/listado";
	}
	
    public void crearPDF(Iterable<Coche> coches, String marca) {
    	
    	Document documento = new Document();
    	Date fecha = new Date();
    	String codigoFecha = new SimpleDateFormat("yyyyMMdd").format(fecha);
        //
    	try {
    		String FILE_NAME = "c:/temp/" + marca + codigoFecha + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(new File(FILE_NAME)));
            
            documento.open();
            
            documento.add(new Paragraph("Fichero " + marca + codigoFecha + ".pdf"));
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
}
