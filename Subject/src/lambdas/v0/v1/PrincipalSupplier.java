package lambdas.v0.v1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class PrincipalSupplier {

	public static void main(String[] args) {

		//DEFINICION DE LAMBDA
		Supplier<StringBuilder> sup1 = () -> new StringBuilder("Hola");
		//EJECUCION DE LA LAMBDA
		StringBuilder sbRes = sup1.get();	
		System.out.println(sbRes);
		
		Supplier<Integer> sup2 = () -> Integer.valueOf(9);
		Integer integer = sup2.get();
		System.out.println(integer);
		
		Supplier<Integer> sup3 = () -> 8;
		int i = sup3.get();
		System.out.println(i);
		
		Supplier<Employee> sup4 = () -> new Employee(4, "Filologo", 500.0);
		System.out.println(sup4.get());
		
		Supplier<List<String>> sup5 = () -> new ArrayList<String>();
		//Supplier<List<String>> sup5 = ArrayList::new;
		System.out.println(sup5.get());
		
	}	

}
