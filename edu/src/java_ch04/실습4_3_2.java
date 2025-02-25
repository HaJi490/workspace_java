package java_ch04;

import java.util.Scanner;

public class 실습4_3_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String name = sc.next();
		System.out.print("과목: ");
		String subject = sc.next();
		System.out.print("성적: ");
		int score = sc.nextInt();
		String result="";
		if(score>=60) {
			result = "합격";
		}else {
			result ="과락";
		}
		
		System.out.println("이름 = "+ name + ", 과목 = " + subject + ", 성적 = " + score + ", 통과 = " + result);
				
	}

}
