package com.conversorv0;
public class ConvertirGradosFarenheit extends ConvertirGrados {
	
	public double convertir(double valor, TipoGrado tipoGrado) {
		
		
		
		switch(tipoGrado) {
		case CELCIUS:
			return (valor * 9/5) + 32;
			
		case KELVIN:
			return (valor - 273.15) * 9/5 + 32;
		default:
			System.out.println("no se ingresó un tipo de grado válido");
		}
		return valor;
		
	}

}