package lambdas.v0;
import java.util.function.*;

public class Principal {

	public static void main(String[] args) {

		Predicate<String> pre01 = s -> s.contains("x");
		
		boolean res = pre01.test("xochimilco");
		
		System.out.println(res);
	}

}
