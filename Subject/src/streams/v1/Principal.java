package streams.v1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
	
	private static Employee[] arrayOfEmps = { 
			new Employee(0, "Patrobas", 100.0), 
			new Employee(1, "Tercio", 200.0),
			new Employee(2, "Andronico", 300.0), 
			new Employee(3, "Epeneto", 400.0),
			new Employee(4, "Filologo", 500.0) };

	public static void main(String[] args) {
		
		List<Employee> listEmpleados = Arrays.asList(arrayOfEmps);
		
		//1.Filtrar los que ganan menos de 400
		//2.Incrementar su sueldo en 200
		//3.Filtrar los que tengan una longitud mayor a 6 en su nombre
		//4.Ordernar por nombre
		//5.Obtener una lista de los nombres: List<String> nombres
		
		List<String> nombres =
				listEmpleados.stream()
				.filter(x -> x.getSalary()<400)
				//.peek(System.out::println)
				.peek(emp -> emp.setSalary(emp.getSalary()+200))
				.peek(System.out::println)
				.filter(z -> z.getNombre().length()>6)
				//.peek(System.out::println)
				.sorted(Comparator.comparing(Employee::getNombre))
				//.peek(System.out::println)
				.map(y -> y.getNombre())
				//.peek(System.out::println)
				.collect(Collectors.toList());
		
		System.out.println(nombres);
		
	}

}
