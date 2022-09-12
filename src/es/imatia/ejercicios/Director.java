package es.imatia.ejercicios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Director extends Employee {

	private String departament;

	private int staff;

	public Director(String name, int age, LocalDate admissionDate, float salary, String departament, int staff) {
		super(name, age, admissionDate, salary);
		this.departament = departament;
		this.staff = staff;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}

	public int getStaff() {
		return staff;
	}

	public void setStaff(int staff) {
		this.staff = staff;
	}

	@Override
	public void encorage() {
		long diff = this.getAdmissionDate().until(LocalDate.now(), ChronoUnit.MONTHS);

		if (this.getStaff() > 30 && diff > 30) {
			System.out.println("Tu bono de Director es: " + this.getSalary() + (BONO * 2));
		}

		System.out.println("Tu bono de Director es: " + this.getSalary());

	}

	@Override
	public String toString() {
		return "Director [departament=" + departament + ", staff=" + staff + "]";
	}

}
