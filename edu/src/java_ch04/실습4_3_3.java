package java_ch04;

import java.util.Scanner;

public class 실습4_3_3 {
	public static void main(String[] args) {
		String[] names = { "홍길동", "김유신", "계백", "강감찬", "을지문덕" };
		String[] subjs = { "수학", "국어", "영어", "과학", "역사" };
		int[][] scores = { { 85, 90, 78, 88, 92 }, { 75, 80, 85, 90, 95 }, { 65, 70, 75, 80, 85 },
				{ 95, 92, 88, 84, 91 }, { 88, 76, 85, 79, 90 } };
		int[] criteria = { 50, 60, 70, 80, 90 };
		String result = "";
		for (int i = 0; i < names.length; i++) {
			System.out.println("[" + names[i] + "]");
			
			for (int j = 0; j < subjs.length; j++) {
				System.out.println("\t" + subjs[j] + ": " + scores[i][j] + " => " + (criteria[j] > scores[i][j] ? "과락" : "통과"));
			}
		}
		
		
		System.out.println("\r"+"=".repeat(60));
		System.out.println("이름" + "\t " + "수학" + "\t" + "국어" + "\t" + "영어" + "\t" + "과학" + "\t" + "역사");//반복문?
		System.out.println("-".repeat(60));
		for (int i = 0; i < names.length; i++) {
			System.out.print("\r" + names[i]);  //'홍길동'앞쪽에서 행안뛰게 하는거
			for (int j = 0; j < subjs.length; j++) {
				System.out.print( "\t" + scores[i][j]);//아닌거같다. 열이 안맞음
			}
		}
		System.out.println("\r"+"=".repeat(60));
		System.out.println("과목" + "\t " +"점수" + "\t " +"이름");
		System.out.println("-".repeat(60));
		for (int i=0; i<subjs.length; i++) {
			System.out.println(subjs[i]);
		}
	}
}