package java_ch03;

import java.util.Scanner;

public class 실습3_1_10 {
	public static void main(String[] args) {
		/*
		 * 교재 139의 구구단 출력 결과를 테이블 형태
		 * 1x1 1x2 ... 1x9
		 * ..
		 * 9x1 9x2 ... 9x9
		 * 
		 */
		Scanner scn = new Scanner(System.in);
		System.out.println("입력할 단: ");
		int dan = scn.nextInt();//입력받기 때문에
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "x "+ i + " = " + dan * i);
		
	}

}
