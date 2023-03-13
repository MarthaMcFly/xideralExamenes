package lambdas.v0.v1;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class PrincipalConsumer {

	public static void main(String[] args) {

		//DEFINICION DE LAMBDA
		Consumer<String> con1 = s -> System.out.println(s + " World");
		//EJECUTAR LA LAMBA
		con1.accept("Hello");
		
		Employee e = new Employee(4, "Filologo", 500.0);
		Consumer<Employee> con2 = emp -> emp.setSalary(emp.getSalary()+100);
		con2.accept(e);
		
		//System.out.println(e);
		
		System.out.println("***********");
		List<Employee> listOfEmps = Arrays.asList( 
				new Employee(0, "Patrobas", 100.0), 
				new Employee(1, "Tercio", 200.0),
				new Employee(2, "Andronico", 300.0), 
				new Employee(3, "Epeneto", 400.0),
				new Employee(4, "Filologo", 500.0) 
		);
		listOfEmps.forEach(t -> t.setSalary(t.getSalary()+10));
		
		listOfEmps.forEach(t -> System.out.println(t));
		
		System.out.println("*****BiConsumer******");
		
		Employee emp5 = new Employee(4, "Filologo", 500.0); 
		
		BiConsumer<Employee,Double> biCon = 
				(emp,d) -> emp.setSalary(emp.getSalary()+d);
				
		biCon.accept(emp5,100.0);
		
		System.out.println(emp5);
		
		
		
		
	}

}
