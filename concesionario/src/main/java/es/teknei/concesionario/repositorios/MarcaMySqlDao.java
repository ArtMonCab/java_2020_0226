package es.teknei.concesionario.repositorios;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import es.teknei.concesionario.entidades.Coche;
import es.teknei.concesionario.entidades.Marca;

public class MarcaMySqlDao implements MarcaDao{
	
	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Marca> obtenerTodos(){
		return jdbc.query("SELECT * FROM marcas", new BeanPropertyRowMapper<Marca>(Marca.class));
	}
	
	@Override
	public Marca obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM marcas WHERE id = ?", new BeanPropertyRowMapper<Marca>(Marca.class), id);
	}
	
	@Override
	public Marca obtenerPorIdConCoches(Long id) {
		Marca marca = obtenerPorId(id);
		Collection<Coche> coches = jdbc.query(
				//"SELECT p.id, p.nombre, p.precio FROM productos p LEFT JOIN categorias c ON c.id = p.categoria_id WHERE c.id = ?",
				"SELECT c.id, c.modelo, c.matricula FROM coches c LEFT JOIN marcas m ON m.id = c.marca_id WHERE m.id = ?",
				new BeanPropertyRowMapper<Coche>(Coche.class), id);
		marca.getCoches().addAll(coches);
		
		return marca;
	}


	

}
