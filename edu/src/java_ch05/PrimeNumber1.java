package java_ch05;

import java.util.Scanner;

public class PrimeNumber1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Number[0:exit]:"); 
			int num = sc.nextInt();
			if (num == 0) break;
			if (isPrime(num) == true) {  //isPrime 메소드값 받아서 출력
				System.out.println(num + " is a Prime.");
			}else {
				System.out.println(num + " is not a Prime.");
			}
		
		}
		sc.close();
		System.out.println("Done!");
	}

	// num이소수면true, 그렇지않으면false를리턴
	public static boolean isPrime(int num) {
		for (int i= 2 ; i < num; i++) {
			if(num%i <= 0) {
				return false;
			}
		}
		return true;
		
	}

}
