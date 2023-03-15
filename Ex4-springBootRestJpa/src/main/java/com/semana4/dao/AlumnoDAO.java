package com.semana4.dao;

import java.util.List;

import com.semana4.entity.Alumno;

public interface AlumnoDAO {

	public List<Alumno> getAlumnos();

	public Alumno saveAlumno(Alumno _alumno);

	public Alumno getAlumno(int theId);

	public void deleteAlumno(int theId);
	
}
