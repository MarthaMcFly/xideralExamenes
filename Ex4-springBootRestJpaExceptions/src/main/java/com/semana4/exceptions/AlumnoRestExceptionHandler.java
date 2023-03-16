package com.semana4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//manejador de excepciones: filtro de la peticion rest, entra aquí cada vez que se manda una peticion rest

@ControllerAdvice
public class AlumnoRestExceptionHandler {

	@ExceptionHandler
    public ResponseEntity<AlumnoErrorResponse> handleException(AlumnoNotFoundException exc) {
		System.out.println("****AlumnoNotFoundException");

        // create a AlumnoErrorResponse

		//cacha la exception y manda un mensaje:
		AlumnoErrorResponse error = new AlumnoErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler
    public ResponseEntity<AlumnoErrorResponse> handleException(Exception exc) {

		System.out.println("****exception");
        // create a CustomerErrorResponse
		AlumnoErrorResponse error = new AlumnoErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
}
