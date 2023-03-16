package collections.hashcode.v1;

import java.util.HashSet;
import java.util.Set;

public class Principal {
	public static void main(String[] args) {
		Empleado e1 = new Empleado(0, "Goerge",100.0);
		Empleado e2 = new Empleado(1, "John",200.0);
		Empleado e3 = new Empleado(2, "Paul",300.0);
		Empleado e4  =new Empleado(3, "Ringo",400.0);
		Empleado e5 = new Empleado(1, "John",200.0);

		//HASH SET
		Set<String> setNombre = new HashSet<>();
		
		setNombre.add(e1.getNombre());
		setNombre.add(e2.getNombre());
		setNombre.add(e3.getNombre());
		setNombre.add(e4.getNombre());
		setNombre.add(e5.getNombre());

		setNombre.forEach(System.out::println);
		
		System.out.println("***************");
		
		System.out.println(e2.equals(e5));
		
		Set<Empleado> setEmpleados = new HashSet<>();
		setEmpleados.add(e1);
		setEmpleados.add(e2);
		setEmpleados.add(e3);
		setEmpleados.add(e4);
		setEmpleados.add(e5);
		
		setEmpleados.forEach(System.out::println);

	}

}
