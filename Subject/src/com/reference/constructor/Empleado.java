package com.reference.constructor;

public class Empleado {
	
	private int id;
	private String nombre;
	private static double salary;
	
	public Empleado(int id, String nombre, double salary) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.salary = salary;
	}

	public Empleado(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Empleado() {
		super();
	}

	public Empleado(String nombre) {
		super();
		this.nombre = nombre;
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
	
	
}
