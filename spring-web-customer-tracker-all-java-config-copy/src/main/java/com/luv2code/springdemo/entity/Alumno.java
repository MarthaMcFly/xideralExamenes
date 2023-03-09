package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //el entity es para mapear con la DB a partir de la clase POJO
@Table(name="alumno") //nombre de la tabla
public class Alumno { //nombre de la Entity

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
	
	public Alumno() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calif) {
		this.calificacion = calif;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + nombre + ", lastName=" + apellido + ", email=" + grupo + ", calificacion" + calificacion + "]";
	}
		
}





