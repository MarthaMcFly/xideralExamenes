package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Alumno;


public interface AlumnoDAO {

	public List<Alumno> getAlumnos();

	public void saveAlumno(Alumno _alumno);

	public Alumno getAlumno(int theId);

	public void deleteAlumno(int theId);
	
}
