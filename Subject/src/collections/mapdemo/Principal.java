package collections.mapdemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Principal {
	public static void main(String[] args) {
		
		Empleado e1 = new Empleado(0, "Goerge",100.0);
		Empleado e2 = new Empleado(1, "John",200.0);
		Empleado e3 = new Empleado(2, "Paul",300.0);
		Empleado e4  =new Empleado(3, "Ringo",400.0);
		Empleado e5 = new Empleado(1, "John",200.0);
		
		Map<String, Empleado> mapaEmpleados = new HashMap<>();
		
		mapaEmpleados.put("x400", e1);
		mapaEmpleados.put("x401", e2);
		mapaEmpleados.put("x402", e3);
		mapaEmpleados.put("x403", e4);
		mapaEmpleados.put("x404", e5);

		mapaEmpleados.forEach((k,v)-> System.out.println(k + ": " + v));
		
		Set<String> setString = mapaEmpleados.keySet(); //regresa la lista de claves en un set
		
		setString.forEach(System.out::println);
		
		Collection<Empleado> colValores = mapaEmpleados.values();
		colValores.forEach(System.out::println);

		
		
	}

}
