package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="alumno") 
public class Alumno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre") //nombre de la columna
	private String nombre;  //nombre con el que se guarda en Spring
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="grupo")
	private String grupo;
	
	@Column(name="calificacion") //columna añadida
	private float calificacion;
		
}





