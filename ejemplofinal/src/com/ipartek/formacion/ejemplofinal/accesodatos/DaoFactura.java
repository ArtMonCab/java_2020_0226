package com.ipartek.formacion.ejemplofinal.accesodatos;

import com.ipartek.formacion.ejemplofinal.entidades.Factura;

/**
 * Interfaz donde se añade al interfaz Dao el método para obtener el último codigo usado.
 * 
 * @author Arturo Montañez
 * @version
 */


public interface DaoFactura extends Dao<Factura>{
	String obtenerUltimoCodigo();
}
