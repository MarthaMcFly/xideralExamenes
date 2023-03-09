package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Alumno;
import com.luv2code.springdemo.service.AlumnoService;

@Controller
@RequestMapping("/customer")
public class AlumnoController {

	// need to inject our customer service
		@Autowired
		private AlumnoService alumnoService;
		
		@GetMapping("/list")
		public String listAlumnos(Model theModel) {
			
			// get customers from the service
			List<Alumno> listaAlumnos = alumnoService.getAlumnos();
					
			// add the customers to the model
			theModel.addAttribute("customers", listaAlumnos);
			
			return "list-customers";    //checar esta linea
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Alumno _alumno = new Alumno();
			
			theModel.addAttribute("alumno", _alumno);
			
			return "customer-form"; //checar esta linea, acá debería ir el jsp alumno-form
		}
		
		@PostMapping("/saveAlumno")
		public String saveAlumno(@ModelAttribute("alumno") Alumno _alumno) {
			
			System.out.println("Entró controller savealumno");
			
			// save the customer using our service
			alumnoService.saveAlumno(_alumno);	
			
			return "redirect:/customer/list";  //checar esta linea 
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("customerId") int theId,
										Model theModel) {
			
			// get the customer from our service
			Alumno _alumno = alumnoService.getAlumno(theId);	
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("alumno", _alumno);
			
			// send over to our form		
			return "customer-form";  //checar esta linea, acá debería ir el jsp alumno-form
		}
		
		@GetMapping("/delete")
		public String deleteAlumno(@RequestParam("customerId") int theId) { //checar con list-jsp
			
			// delete the customer
			alumnoService.deleteAlumno(theId);
			
			return "redirect:/customer/list";  //checar esta linea 
		}
}










