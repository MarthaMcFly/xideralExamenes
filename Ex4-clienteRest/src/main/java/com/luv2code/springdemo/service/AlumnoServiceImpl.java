package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public AlumnoServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}
	
	
	@Override
	public List<Alumno> getAlumnos() {

		logger.info("in getAlumnos(): Calling REST API " + crmRestUrl);

		// make REST call

		ResponseEntity<List<Alumno>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Alumno>>() {
				});

		// get the list of customers from response

		List<Alumno> alumnos = responseEntity.getBody();

		logger.info("in getCustomers(): customers" + alumnos);

		return alumnos;	}

	@Override
	public void saveAlumno(Alumno _alumno) {

		
	}

	@Override
	public Alumno getAlumno(int theId) {
		
		return null; 
	}

	@Override
	public void deleteAlumno(int theId) {
		
	}
}





