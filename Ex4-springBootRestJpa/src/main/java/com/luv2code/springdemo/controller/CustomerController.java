package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Alumno;
import com.luv2code.springdemo.service.AlumnoService;

@RestController
@RequestMapping("/rest")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private AlumnoService alumnoService;
	
	@GetMapping("/alumnos")
	public List<Alumno> findAll() {
		return alumnoService.getAlumnos();
	}
	
	@GetMapping("/alumnos/{alumnoId}")
	public Alumno getCustomer(@PathVariable int alumnoId) throws Exception {
		
		Alumno _alumno = alumnoService.getAlumno(alumnoId);
		
		if (_alumno == null) {
			throw new Exception("Alumno id not found - " + alumnoId);
		}
		
		return _alumno;
	}
	
	@PostMapping("/alumnos")
	public Alumno addAlumno(@RequestBody Alumno _alumno) {
		
		_alumno.setId(0);
		
		Alumno addAlumno = alumnoService.saveAlumno(_alumno);
		
		return addAlumno; //regresa el customer que estamos dando de alta con su id
	}
	
	@PutMapping("/alumnos")
	public Alumno updateAlumno(@RequestBody Alumno _alumno) {
		
		Alumno Alumno=alumnoService.saveAlumno(_alumno);//recupera la información cambiada y la manda de regreso 
		
		return Alumno;
	}
	
	@DeleteMapping("/alumnos/{alumnoId}")
	public String deleteAlumno(@PathVariable int alumnoId) {
		
		Alumno tempAlumno = alumnoService.getAlumno(alumnoId);
		
		// throw exception if null
		
		if (tempAlumno == null) {
			throw new RuntimeException("Alumno id not found - " + alumnoId);
		}
		
		alumnoService.deleteAlumno(alumnoId);
		
		return "Deleted alumno id - " + alumnoId;
	}
	
	
}










