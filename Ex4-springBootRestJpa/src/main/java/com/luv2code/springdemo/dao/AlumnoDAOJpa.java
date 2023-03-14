package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Alumno;

@Repository
public class AlumnoDAOJpa implements AlumnoDAO {
	
    // define field for entitymanager
    private EntityManager entityManager;
    
    // set up constructor injection
    @Autowired
    public AlumnoDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


	@Override
	public List<Alumno> getAlumnos() {
		// create a query
        TypedQuery<Alumno> theQuery = entityManager.createQuery("from Alumno", Alumno.class);

        // execute query and get result list
        List<Alumno> alumnos = theQuery.getResultList();

        // return the results
        return alumnos;
	}

	@Override
	public Alumno saveAlumno(Alumno _alumno) {
		Alumno alumno = entityManager.merge(_alumno);
		return alumno;
	}

	@Override
	public Alumno getAlumno(int theId) {
		Alumno _alumno = entityManager.find(Alumno.class, theId);
		return _alumno;
	}

	@Override
	public void deleteAlumno(int theId) {
		Alumno _alumno = entityManager.find(Alumno.class, theId);
        // remove employee
        entityManager.remove(_alumno);
		
	}

}
