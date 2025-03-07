package java_ch03;

import java.util.Scanner;

public class 실습3_1_7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 항의 수
		/*
		int first = 0;
		int second = 1;
		System.out.println(first);
		for (int i = 2; i <= n; i++) {
			System.out.println(second);
			int next = first + second;
			first = second;
			second = next;
		}
		*/
		//while
		/*int first = 0;
		int second = 1;
		System.out.println(first);
		int i = 2;
		while(i<=n) {
			System.out.println(second);
			i++;
			int next = first + second;
			first = second;
			second = next;
		}
		*/
		
	//do~while
		int first=0;
		int second = 1;
		System.out.println(first);
		int i = 2;
		do {
			System.out.println(second);
			i++;
			int next = first + second;
			first = second;
			second = next;
		}while(i<=n);
		
	}

}
