package com.examen3.proyectospringboot.service;

import java.util.List;

import com.examen3.proyectospringboot.entity.Alumno;

public interface AlumnoService {

	public List<Alumno> getAlumnos();

	public void saveAlumno(Alumno _alumno);

	public Alumno getAlumno(int theId);

	public void deleteAlumno(int theId);
	
}
