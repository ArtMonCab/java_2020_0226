package com.ipartek.formacion.spring.servidorrestspring.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clientes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
	@id
	@GeneratedValue(strategy = Generation,IDENTITY)

}
