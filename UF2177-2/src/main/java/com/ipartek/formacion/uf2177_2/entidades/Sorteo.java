package com.ipartek.formacion.uf2177_2.entidades;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Sorteo {
	@Min(1)
	private long id;
	@NotBlank
	@Min(1)
	@Max(50)
	private int num1;
	@NotBlank
	@Min(1)
	@Max(50)
	private int num2;
	@NotBlank
	@Min(1)
	@Max(50)
	private int num3;
	@NotBlank
	@Min(1)
	@Max(50)
	private int num4;
	@NotBlank
	@Min(1)
	@Max(50)
	private int num5;
	@NotBlank
	@Min(1)
	@Max(12)
	private int est1;
	@NotBlank
	@Min(1)
	@Max(12)
	private int est2;
	@NotBlank
	@Past
	private Date fecha;
	
}
