package com.luv2code.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {

	private int id;
	
	private String nombre;  //nombre con el que se guarda en Spring
	
	private String apellido;
	
	private String grupo;
	
	private float calificacion;
	
		
}





