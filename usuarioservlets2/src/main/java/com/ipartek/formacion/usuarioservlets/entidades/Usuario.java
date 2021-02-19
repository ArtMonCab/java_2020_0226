package com.ipartek.formacion.usuarioservlets.entidades;

import java.io.Serializable;

public class Usuario implements Serializable{


	private static final long serialVersionUID = 4405516435523560707L;
	
	private Long id;
	private String email;
	private String password;
	
	private Rol rol;

	public Usuario(Long id, String email, String password, Rol rol) {
		super();
		setId(id);
		setEmail(email);
		setPassword(password);
		setRol(rol);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
