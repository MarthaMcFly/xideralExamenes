package streams.v1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
	
	private static Employee[] arrayOfEmps = { new Employee(0, "Patrobas", 100.0), new Employee(1, "Tercio", 200.0),
			new Employee(2, "Andronico", 300.0), new Employee(3, "Epeneto", 400.0),
			new Employee(4, "Filologo", 500.0) };

	public static void main(String[] args) {

		List<Employee> listaEmpleados = Arrays.asList(arrayOfEmps);

		Stream<Employee> streamEmp = listaEmpleados.stream();

		listaEmpleados = streamEmp.filter(emp -> emp.getSalary() > 300).collect(Collectors.toList());

		listaEmpleados.forEach(System.out::println);

		System.out.println("************");

		Stream<Employee> streamEmp2 = Arrays.stream(arrayOfEmps);

		List<String> listaNombres = streamEmp2.map(emp -> emp.getNombre()).collect(Collectors.toList());

		listaNombres.forEach(System.out::println);

		System.out.println("******streamEmp3******");

		Stream<Employee> streamEmp3 = Arrays.stream(arrayOfEmps);

		streamEmp3.map(emp -> emp.getNombre()).forEach(System.out::println);

		System.out.println("******streamEmp4******");

		Stream<Employee> streamEmp4 = Arrays.stream(arrayOfEmps);

		long elementos = streamEmp4
				.peek((emp) -> {
					System.out.println(emp);
					})
				.map(emp -> emp.getNombre()).count();

		System.out.println(elementos);
		
		System.out.println("******streamEmp5******");

		Stream<Employee> streamEmp5 = Arrays.stream(arrayOfEmps);

		listaNombres = streamEmp5
				.peek((emp) -> {
					System.out.println(emp);
					})
				.map(emp -> emp.getNombre())
				.collect(Collectors.toList());

		System.out.println(listaNombres);

	}
}
