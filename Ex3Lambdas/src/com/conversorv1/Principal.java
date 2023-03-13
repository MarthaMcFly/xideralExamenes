package com.conversorv1;

import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Principal {
	public static void main(String[] args) {

		System.out.println("¿Qué conversión deseas realizar? "
				+ "+\n1. Celsius a Farenheit"
				+ "\n2. Farenheit a Celsius"
				+ "\n3. Celsius a Kelvin"
				+ "\n4. Kelvin a Celsius"
				+ "\n5. Farenheit a Kelvin"
				+ "\n6. Kelvin a Farenheit");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		
		System.out.println("Ingrese el valor de los grados que desea convertir");
		double valor = sc.nextDouble();
		
		switch(option) {
			case 1:
		        DoubleFunction<Double> celsiusToFahrenheit = v -> (v * 9 / 5) + 32;
		        System.out.println(celsiusToFahrenheit.apply(valor));
		        break;
			case 2: 
				 DoubleFunction<Double> farenheitToCelsius = v -> ((v - 32) * 5/9);
			     System.out.println(farenheitToCelsius.apply(valor));
				 break; 
			case 3: 
				DoubleFunction<Double> celsiusToKelvin = v -> v + 273.15;
				System.out.println(celsiusToKelvin.apply(valor));
				break;
			case 4:
				DoubleFunction<Double> kelvinToCelsius = v -> v - 273.15;
				System.out.println(kelvinToCelsius.apply(valor));
				break;
			case 5: 
				DoubleFunction<Double> farenheitToKelvin = v -> (v - 32) * 5/9 + 273.15;
				System.out.println(farenheitToKelvin.apply(valor));
				break;
			case 6: 
				DoubleFunction<Double> kelvinToFarenheit = v -> (v - 273.15) * 9/5 + 32;
				System.out.println(kelvinToFarenheit.apply(valor));
			break;
			default:
				System.out.println("No se ingresó una opción válida");
		}
	
	}

}
