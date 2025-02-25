package com.ruby.java.ch08.polymorphism;

class AClass{}

class BClass extends AClass{}

class CClass extends BClass{}

public class HRS1 {
	public static void main(String[] args) {
		BClass c = new CClass();
		
		if(c instanceof CClass) 
			System.out.println("CClass");
		else if(c instanceof BClass) 
			System.out.println("BClass");
		else if(c instanceof AClass)
			System.out.println("AClass");
		
	System.out.println(c.getClass().getName()); //참조변수의 클래스명을 알고싶을 때 
		
	}

}
