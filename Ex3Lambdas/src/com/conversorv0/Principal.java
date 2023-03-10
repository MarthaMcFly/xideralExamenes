package com.conversorv0;

public class Principal {
	public static void main(String[] args) {

		//De grados F° a grados C°   Validado
		ConvertirGrados con1 = new ConvertirGradosCelsius();
		double resultado = con1.convertir(50, TipoGrado.FARENHEIT);
		System.out.println("resultado de 50°F" + resultado + "°C"); //resultado 10
		
		//De grados K° a grados C°    VALIDADO
		resultado = con1.convertir(280.15, TipoGrado.KELVIN);
		System.out.println("resultado de grados k en grados C" + resultado); //resultado 7
		

		//De grados C° a grados F°     VALIDADO
		ConvertirGrados con2 = new ConvertirGradosFarenheit();
		resultado = con2.convertir(25, TipoGrado.CELCIUS);
		System.out.println("resultado de grados 25°C" + resultado + "°F"); //resultado 77
		
		//De grados K° a grados F°     VALIDADO
		resultado = con2.convertir(329, TipoGrado.KELVIN);
		System.out.println("resultado de grados 329°K" + resultado + "°F"); //resultado 132.53
		
		//De grados C° a grados K°     VALIDADO
		ConvertirGrados con3 = new ConvertirGradosKelvin();
		resultado = con3.convertir(32, TipoGrado.CELCIUS);
		System.out.println("resultado de grados 32°C" + resultado + "°K"); //resultado 305.15
		
		//De grados C° a grados K°     VALIDADO
		resultado = con3.convertir(32, TipoGrado.FARENHEIT);
		System.out.println("resultado de grados 32°F" + resultado + "°K"); //resultado 273.15
	
		
	
	
	}

}
