package covariant;

public class Parque extends Zoologico{
	@Overide
	Aguila getAnimal(String nombre) { //regresamos una subclase de animal
		return new Aguila();
	}
}
