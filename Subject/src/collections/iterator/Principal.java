package collections.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;

public class Principal {
	public static void main(String[] args) {
		
		//iterator: 
		Iterator<Empleado> iteratorEmpleados;
		
		Empleado e1 = new Empleado(0, "Goerge",100.0);
		Empleado e2 = new Empleado(1, "John",200.0);
		Empleado e3 = new Empleado(2, "Paul",300.0);
		Empleado e4  =new Empleado(3, "Ringo",400.0);
		Empleado e5 = new Empleado(1, "John",200.0);
		
		Set<Empleado> setEmpleados = new HashSet<>();
		setEmpleados.add(e1);
		setEmpleados.add(e2);
		setEmpleados.add(e3);
		setEmpleados.add(e4);
		setEmpleados.add(e5);
		
		//convirtió el set de empleado een un iterator 
		iteratorEmpleados = setEmpleados.iterator();
		showCollection(iteratorEmpleados);

		//lista de empleados
		List<Empleado> listEmpleados = new ArrayList<>();
		listEmpleados.add(e1);
		listEmpleados.add(e2);
		listEmpleados.add(e3);
		listEmpleados.add(e4);
		listEmpleados.add(e5);
		//convirtió el list de empleado een un iterator 
		iteratorEmpleados = listEmpleados.iterator();
		showCollection(iteratorEmpleados);
		
		//queue de empleados 
		Queue<Empleado> queueEmpleados = new LinkedList<>();
		queueEmpleados.add(e1);
		queueEmpleados.add(e2);
		queueEmpleados.add(e3);
		queueEmpleados.add(e4);
		queueEmpleados.add(e5);
		
		//convirtió el list de empleado een un iterator 
		iteratorEmpleados = queueEmpleados.iterator();
		showCollection(iteratorEmpleados);
	}
	
	//metodo static para iterar las colecciones 
	static void showCollection(Iterator<Empleado> iterator) {
		System.out.println("***************");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	

}
