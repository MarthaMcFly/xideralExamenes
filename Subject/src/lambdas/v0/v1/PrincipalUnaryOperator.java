package lambdas.v0.v1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class PrincipalUnaryOperator {

	public static void main(String[] args) {

		//DEFINICION DE LA LAMBDA
		Function<String,String> fun = s -> s.concat("World");
		System.out.println(fun.apply("Hello "));
		
		UnaryOperator<String> uo = s -> s.concat("World");	
		System.out.println(uo.apply("Hello "));
		
		UnaryOperator<Employee> uoEmp = e -> {e.setSalary(10);
											  e.setNombre("Peter");
												return e;
											 };
											 
		Employee e = new Employee(4, "Filologo", 500.0);
		Employee newEmp = uoEmp.apply(e);
		System.out.println(newEmp);		
		
		System.out.println("****************");
		
		List<Employee> listOfEmps = new ArrayList<>();
		
		listOfEmps.add(new Employee(0, "Patrobas", 100.0)); 
		listOfEmps.add(new Employee(1, "Tercio", 200.0)); 
		listOfEmps.add(new Employee(2, "Andronico", 300.0));  
		listOfEmps.add(new Employee(3, "Epeneto", 400.0)); 
		listOfEmps.add(new Employee(4, "Filologo", 500.0)); 
		
		
		listOfEmps.removeIf(emp -> emp.getSalary()>=400);
		
		listOfEmps.replaceAll(w -> {
			w.setSalary(w.getSalary()+10);
			return w;
		});
		
		listOfEmps.forEach(x -> System.out.println(x));
	}
		


}
