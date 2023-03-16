package com.reference.staticmetod;

public class Empleado {
	
	private int id;
	private String nombre;
	private static double salary;
	
	public Empleado(int id, String nombre, double salary) {
		this.id = id;
		this.nombre = nombre;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", nombre=" + nombre + ", salary=" + salary + "]";
	}
	
	public void incrementarSalario(double inc) {
		this.setSalary(this.getSalary()*inc);
	}
	
	public Empleado decrementarSalario(double dec) {
		this.setSalary(this.getSalary()-this.getSalary()*dec);
		return this;
	}
}
