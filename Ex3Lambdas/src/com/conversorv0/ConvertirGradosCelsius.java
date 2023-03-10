package com.conversorv0;

public class ConvertirGradosCelsius extends ConvertirGrados {
	
	public double convertir(double valor, TipoGrado tipoGrado) {

		
		switch(tipoGrado) {
		case FARENHEIT:
			
			return ((valor - 32) * 5/9);
			
		case KELVIN:
			return valor - 273.15;
		default:
			System.out.println("no se ingresó un tipo de grado válido");
		}
		return valor;
		
		
	}

}