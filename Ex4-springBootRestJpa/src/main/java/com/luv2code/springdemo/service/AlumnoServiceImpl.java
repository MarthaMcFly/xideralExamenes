package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.AlumnoDAO;
import com.luv2code.springdemo.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	@Qualifier("alumnoDAOJdbc") //inyectamos la clase que va a aplicar con minuscula
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





