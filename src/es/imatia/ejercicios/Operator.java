package es.imatia.ejercicios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Operator extends Employee {

	private int level;

	public Operator(String name, int age, LocalDate admissionDate, float salary, int level) {
		super(name, age, admissionDate, salary);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void encorage() {
		long diff = this.getAdmissionDate().until(LocalDate.now(), ChronoUnit.YEARS);
		
		if (this.getAge() > 30 && this.getLevel() > 2) {
			System.out.println("Tu bono de operario es: " + this.getSalary() * (BONO * 2));
		}

		System.out.println("Tu bono de operario es: " + this.getSalary());

	}

	@Override
	public String toString() {
		return "Operator [level=" + level + "]";
	}

}
