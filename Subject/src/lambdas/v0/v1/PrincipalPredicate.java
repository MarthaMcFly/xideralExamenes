package lambdas.v0.v1;
import java.util.function.*;

public class PrincipalPredicate {

	public static void main(String[] args) {

		//DEFINICION DE LAMBDA
		Predicate<String> pre01 = (String s) -> {
							System.out.println("Paso por Predicate");
							return s.contains("x");
						};
		
		//EJECUCION DE LA LAMBDA
		boolean res = pre01.test("xoco");
		
		System.out.println(res);
		
		
	}

}
