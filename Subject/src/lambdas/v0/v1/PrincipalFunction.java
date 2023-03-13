package lambdas.v0.v1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class PrincipalFunction {

	public static void main(String[] args) {

		//DEFINICION DE LA LAMBDA
		Function<String,Integer> fun1 = s -> s.length();
		//EJECUCION DE LA LAMBDA
		int i = fun1.apply("Hola");
		System.out.println(i);
		
		Function<StringBuilder,Employee> fun2 = 
				sb -> new Employee(0,sb.toString(),200.00);
		Employee e = fun2.apply(new StringBuilder("Filologo"));
		System.out.println(e);
		
		Function<Object[],Employee> fun3 = 
			o -> new Employee(((Integer)(o[0])),((String)(o[1])),((Double)(o[2])));
		Employee e1 = fun3.apply(new Object[]{500,"Patrobas",400.0});
		System.out.println(e1);
		
		BiFunction<String,Double,Employee> biFun1 = 
				(s,d) -> new Employee(new Random().nextInt(200),s,d);
		Employee e2 = biFun1.apply("Mary", 50.00);
		System.out.println(e2);
				
		
		
	}

}
