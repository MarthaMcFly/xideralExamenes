package covariant;

public class Principal {
	public static void main(String[] args) {
		Zoologico z = new Parque();
		z.getAnimal("nombre");
		
		Animal a = z.getAnimal("nombre");
		
		System.out.println(a.getClass().getName());
	}

}
