package java_ch05;

import java.util.Scanner;

public class PrimeNumber2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("Number[0:exit]:");
			int num = sc.nextInt();
			if (num == 0)break;
				

			int s = (int) Math.pow(10.0, (double) (num - 1));   //Math.pow(a,2)라면 a의 2승을 의미한다.
			int e = (int) Math.pow(10.0, (double) (num));
			for (int i =s ; i<e; i++) { 
				if(isPrime(num))
					
				}

			// 코드 작성

			System.out.println("Number of Prime :" + count);
		}
		System.out.println("Done!");
		
	}
	public static boolean isPrime(int num) {
		for (int i= 2 ; i < num; i++) {
			if(num%i <= 0) {
				return false;
			}
		}
		return true;

}
