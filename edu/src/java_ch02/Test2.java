package java_ch02;

public class Test2 {
	public static void main(String[] args) {
		int depositAmount;
		depositAmount = 50000;
		boolean Male = true;
		char gender;
		gender = 'F';
		String name = "hong gildong";//string literal
		long d = 2147523456l;
		float exchangeRate = 1480.f;
		double dollarRate = 1480.0f;//1480.0f
		System.out.println("depositAmount = " +depositAmount);
		System.out.println("male/female = " + Male);
		System.out.println("gender = " +gender);
		System.out.println("name :: " + name);
		int a = 10;
		a = a + 1;
		int b = ++a;
		int e = 10;
		short c2 = (short)(-e);
		System.out.println("b = " + b +", a = " + a );
		int num1 = 017; // 8진법
		int num2 = 0xf; // 16진법 => 0x로 표시
		System.out.println("num1=" + num1);
		System.out.println("num2=" + num2);
		int num3 = 14;
		System.out.println(Integer.toBinaryString(num3));
		System.out.println(Integer.toHexString(num3));
		
		
				
	}
}
