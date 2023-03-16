package com.reference.constructor;

import java.util.function.*;

public class Principal {
	public static void main(String[] args) {
	
//		Supplier<Empleado> sup = () -> new Empleado();
		Supplier<Empleado> sup = Empleado::new;
		Empleado empleado = sup.get();
		System.out.println(empleado);

		//Constructor con un parámetro:
		//Function<String, Empleado> fun = name -> new Empleado(name);
		//con reference:
		Function<String, Empleado> fun = Empleado::new;
		empleado = fun.apply("Luis");
		System.out.println(empleado);
		
		//constructor con 2 parametros
		//BiFunction<Integer,String, Empleado> bifun = (id, name) -> new Empleado(id,name);
		BiFunction<Integer,String, Empleado> bifun = Empleado::new;
		empleado = bifun.apply(3, "Luis");
		System.out.println(empleado);
		
		//constructor con 3 parámetros
		TriFunction<Integer, String, Double, Empleado> trifun = Empleado::new;
		empleado = trifun.apply(3, "Fer", 500.0);
		System.out.println(empleado);

		
		
		
	}
}
