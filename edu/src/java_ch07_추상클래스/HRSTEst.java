package java_ch07_추상클래스;

abstract class Employee {
	String name;
	int salary;

	public abstract void calcSalary();// abstract 메소드

	public abstract void calcBonus();
}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여");
	}

	public void calcBonus() {
		System.out.println("Manager 보너스");
	}
}

public class HRSTEst {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		// Manager m = new Manager();

		s.calcSalary();
		c.calcSalary();
		// m.calcSalary();

		s.calcBonus();
		c.calcBonus();
		// m.calcBonus();

	}
}