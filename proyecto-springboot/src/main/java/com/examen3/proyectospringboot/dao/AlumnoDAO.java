package com.examen3.proyectospringboot.dao;

import java.util.List;

import com.examen3.proyectospringboot.entity.Alumno;


public interface AlumnoDAO {

	public List<Alumno> getAlumnos();

	public void saveAlumno(Alumno _alumno);

	public Alumno getAlumno(int theId);

	public void deleteAlumno(int theId);
	
}
