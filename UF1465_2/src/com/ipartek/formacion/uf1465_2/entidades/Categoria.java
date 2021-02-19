package com.ipartek.formacion.uf1465_2.entidades;

import java.io.Serializable;
import java.util.Set;


public class Categoria implements Serializable{
	

	private static final long serialVersionUID = -3419539872440240717L;

	private Long id;
	private String nombreCategoria;
	
	private Set<Producto> productos;

	public Categoria(Long id, String nombreCategoria) {
		super();
		this.id = id;
		this.nombreCategoria = nombreCategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombreCategoria == null) ? 0 : nombreCategoria.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreCategoria == null) {
			if (other.nombreCategoria != null)
				return false;
		} else if (!nombreCategoria.equals(other.nombreCategoria))
			return false;
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	
	

}
