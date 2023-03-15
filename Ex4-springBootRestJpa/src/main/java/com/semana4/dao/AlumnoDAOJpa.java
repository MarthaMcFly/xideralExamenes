package com.semana4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.semana4.entity.Alumno;

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
		System.out.println("PASO POR AlumnoDAOJpa método getAlumnos"); 
		
        TypedQuery<Alumno> theQuery = entityManager.createQuery("from Alumno", Alumno.class);

        // execute query and get result list
        List<Alumno> alumnos = theQuery.getResultList();

        // return the results
        return alumnos;
	}

	@Override
	public Alumno saveAlumno(Alumno _alumno) {
		System.out.println("PASO POR AlumnoDAOJpa método saveAlumno"); 

		Alumno alumno = entityManager.merge(_alumno);
		return alumno;
	}

	@Override
	public Alumno getAlumno(int theId) {
		System.out.println("PASO POR AlumnoDAOJpa método getAlumno"); 

		Alumno _alumno = entityManager.find(Alumno.class, theId);
		return _alumno;
	}

	@Override
	public void deleteAlumno(int theId) {
		System.out.println("PASO POR AlumnoDAOJpa método deleteAlumno"); 

		Alumno _alumno = entityManager.find(Alumno.class, theId);
        // remove employee
        entityManager.remove(_alumno);
		
	}

}
