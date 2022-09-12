package es.imatia.ejercicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class Employee {
	
	private String name;
	
	private int age;
	
	private LocalDate admissionDate;
	
	private float salary;
	
	protected final float BONO = 2;
	
	
	

	public Employee(String name, int age, LocalDate admissionDate, float salary) {
		super();
		this.name = name;
		this.age = age;
		this.admissionDate = admissionDate;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public void encorage() {
	  System.out.println("Tu bono de empleado es: " + this.getSalary());
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", admissionDate=" + admissionDate + ", salary=" + salary
				+ ", BONO=" + BONO + "]";
	}
	
}
