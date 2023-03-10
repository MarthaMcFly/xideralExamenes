package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Alumno;


@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<Alumno> getAlumnos() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query  ... ordenado por apellido
			Query<Alumno> theQuery = 
					currentSession.createQuery("from Alumno order by apellido", //no son los nombre de la base de datos sino los de la entity
												Alumno.class);
			
			// execute query and get result list
			List<Alumno> alumnos = theQuery.getResultList();
					
			// return the results		
			return alumnos;
		}

		@Override
		public void saveAlumno(Alumno _alumno) {

			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save/upate the alumno ... finally LOL
			currentSession.saveOrUpdate(_alumno);
			
		}

		@Override
		public Alumno getAlumno(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
			Alumno _alumno = currentSession.get(Alumno.class, theId);
			
			return _alumno;
		}

		@Override
		public void deleteAlumno(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// delete object with primary key
			Query theQuery = 
					currentSession.createQuery("delete from Alumno where id=:alumnoId"); //acuerdate que es el del entity no de la DB
			theQuery.setParameter("alumnoId", theId);  //checar customerId
			
			theQuery.executeUpdate();		
		}

}











