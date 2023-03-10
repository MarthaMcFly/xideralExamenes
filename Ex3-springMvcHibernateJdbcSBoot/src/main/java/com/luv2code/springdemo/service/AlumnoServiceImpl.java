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

	// need to inject customer dao
		@Autowired
		@Qualifier("alumnoDAOJdbc") //inyectamos la clase que va a aplicar con minuscula
		private AlumnoDAO customerDAO;
		
		@Override
		@Transactional
		public List<Alumno> getAlumnos() {
			return customerDAO.getAlumnos(); //MOVER DE LA DAO
		}

		@Override
		@Transactional
		public void saveAlumno(Alumno _alumno) {

			customerDAO.saveAlumno(_alumno); //DE LA DAO
		}

		@Override
		@Transactional
		public Alumno getAlumno(int theId) {
			
			return customerDAO.getAlumno(theId); //DE LA DAO
		}

		@Override
		@Transactional
		public void deleteAlumno(int theId) {
			
			customerDAO.deleteAlumno(theId);  //DE LA DAO
		}
}





