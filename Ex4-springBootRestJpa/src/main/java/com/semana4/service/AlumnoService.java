package com.semana4.service;

import java.util.List;

import com.semana4.entity.Alumno;


public interface AlumnoService {

	public List<Alumno> getAlumnos();

	public Alumno saveAlumno(Alumno _alumno);

	public Alumno getAlumno(int theId);

	public void deleteAlumno(int theId);
	
}
