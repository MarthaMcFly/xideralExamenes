package com.reference.clasmetod;

import java.util.function.*;

public class Principal {
	public static void main(String[] args) {
		Empleado empleado = new Empleado(4, "Filologo", 500.0) ;
	
	//	Consumer<Empleado> cons = empl -> Empleado.incrementarSalario(empl);
		
	//	cons.accept(empleado);
		
	//	System.out.println(empleado);
		
		//**********
		//Function<Double, Empleado> fun = (d) -> empleado::incrementarSalario;
		
		//Empleado empRes = fun.apply(0.30);
		
//		System.out.println(empRes);
		
		
		
		

		 
		
	
		
	}
}
