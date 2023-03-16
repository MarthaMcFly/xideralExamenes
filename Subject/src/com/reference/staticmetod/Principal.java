package com.reference.staticmetod;

import java.util.function.*;

public class Principal {
	public static void main(String[] args) {
		Empleado empl = new Empleado(4, "Filologo", 500.0) ;
	
		/*BiConsumer<Empleado, Double> bicons =
				(e,d) -> e.incrementarSalario(d);
		*/
		//con reference:
		BiConsumer<Empleado, Double> bicons =
				Empleado::incrementarSalario;
		
		bicons.accept(empl, 1.15);
		System.out.println(empl);
		
		//***********************
		//BiFunction<Empleado, Double, Empleado> bifun =(e,d) -> e.decrementarSalario(d);
		
		//reference
		BiFunction<Empleado, Double, Empleado> bifun = Empleado::decrementarSalario;
		
		Empleado empRes= bifun.apply(empl, .60);
		System.out.println(empRes);
		
		
		
		
		
	
		
	}
}
