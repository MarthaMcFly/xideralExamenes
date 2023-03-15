package com.semana4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.semana4.dao.AlumnoDAO;
import com.semana4.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	//@Qualifier("alumnoDAOJdbc") //inyectamos a Jdbc
	@Qualifier("alumnoDAOJpa") //inyectamos con Jpa
	private AlumnoDAO alumnoDAO;
	
	@Override
	@Transactional
	public List<Alumno> getAlumnos() {
		return alumnoDAO.getAlumnos();
	}

	@Override
	@Transactional
	public Alumno saveAlumno(Alumno _alumno) {
		Alumno alumno = alumnoDAO.saveAlumno(_alumno);
		return alumno;
	}

	@Override
	@Transactional
	public Alumno getAlumno(int theId) {
		
		return alumnoDAO.getAlumno(theId);
	}

	@Override
	@Transactional
	public void deleteAlumno(int theId) {
		
		alumnoDAO.deleteAlumno(theId);
	}
}





