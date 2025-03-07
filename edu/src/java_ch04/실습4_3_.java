package java_ch04;

import java.util.Scanner;

public class 실습4_3_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 5; i++) {
			System.out.print("이름["+i+"]: ");
			String name = sc.next();
			System.out.print("국어, 수학, 영어 : ");
			int kor = sc.nextInt();
			int mat = sc.nextInt();
			int eng = sc.nextInt();
			String result = "";
			if (kor >= 60 && mat >= 50 && eng >= 70) {
				result = "합격";
			} else {
				result = "과락";	
			}
				System.out.println("이름 = " + name + ", 국어 = " + kor + ", 수학 = " + mat + ", 영어 = " + eng + " : " + result);
			
		}
	}

}
