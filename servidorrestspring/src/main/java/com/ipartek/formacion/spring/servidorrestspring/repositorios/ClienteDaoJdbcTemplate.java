package com.ipartek.formacion.spring.servidorrestspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.servidorrestspring.entidades.Cliente;

@Repository
//Si quiero cambiar de Dao, quito de aqui @Repository y la pongo en el otro fichero
public class ClienteDaoJdbcTemplate implements Dao<Cliente>{

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	public Iterable<Cliente> obtenerTodos() {
		return jdbc.query("SELECT * FROM clientes", new BeanPropertyRowMapper<Cliente>());
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return jdbc.queryForObject("SELECT * FROM clientes WHERE id = ?", new BeanPropertyRowMapper<Cliente>(),id);
	}

	@Override
	public Cliente agregar(Cliente cliente) {
		KeyHolder keyholder = new GeneratedKeyHolder();
		
		jdbc.update(connection -> {
			PrepareStatement ps = connection.prepareStatement(arg0)
			
		}, keyholder);
		
		return cliente;
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		jdbc.update("UPDATE clientes set nombre = ?, apellidos = ? WHERE id = ?", cliente.getNombre(), cliente.getApellido(), cliente.getId());
		return cliente;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
