package collections.v0;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main(String[] args) {
		List<Empleado> lista = new ArrayList<>();
		lista.add(new Empleado(0, "Goerge",100.0));
		lista.add(new Empleado(1, "John",200.0));
		lista.add(new Empleado(2, "Paul",300.0));
		lista.add(new Empleado(3, "Ringo",400.0));
		
		Empleado e = new Empleado(4, "brian", 500.0);
		
			lista.add(1,e);
		
		System.out.println(lista.get(2));
		
		
	}

}
