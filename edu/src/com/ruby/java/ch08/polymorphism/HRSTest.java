package com.ruby.java.ch08.polymorphism;

abstract class Employee {
	String name;
	int salary;

	public abstract void calcSalary();

	public abstract void calcBonus();
}

class Salesman extends Employee {
	int annual_sales;		//연간 판매 실적
	
	public void calcSalary() { // 부모 추상클래스가 가진 추상메서드를 모두 구현하여 일반클래스로 사용가능
		System.out.println("Salesman 급여 = 기본급 + 판매수당");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}

}

class Consultant extends Employee {
	int num_project;		//컨설팅 참여 수
	
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2");
	}

}

abstract class Manager extends Employee {
	int num_team;		//관리 팀 수
	
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}

public class HRSTest {
	public static void calcTax(Employee e) { // 'e' 참조변수를 선언 안해도되는 이유 : 여기서 선언도 된것
		if (e instanceof Salesman) {
			System.out.println("Salesman 입니다");
			System.out.println(e.annual_sales);
		} else if (e instanceof Manager) {
			System.out.println("Manager 입니다");
			System.out.println(e.num_team);
		} else if (e instanceof Consultant) {
			System.out.println("Consultant 입니다");
			System.out.println(e.num_project);			//p.354
		} else {
			System.out.println("Employee 입니다");
		}
	}

	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();

		/*
		 * s.calcBonus(); c.calcBonus(); d.calcBonus();
		 */

		calcTax(s);
		calcTax(c);
		calcTax(d);

//		System.out.println(s.toString()); // toString은 Object클래스에 있음
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//
//		Salesman s2 = s;
//		System.out.println(s2.toString());
//
//		if (s.equals(s2)) { // e1uals는 Object클래스에 있음
//			System.out.println("동일한 객체입니다.");
//		} else {
//			System.out.println("서로 다른 객체입니다.");
//		}
	}

}