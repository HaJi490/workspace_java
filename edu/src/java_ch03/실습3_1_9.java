package java_ch03;

import java.util.Scanner;

public class 실습3_1_9 {

	public static void main(String[] args) {
		/*
		 * 출력 형태를 다음과 같이 만들기 실습
		 * 실습1:
		 * $$$$$
		 * $$$$
		 * $$$
		 * $$
		 * $
		 * 
		 * 실습2: 정삼각형 형태로 출력하기
		 * $$$$$$
		 *  $$$
		 *   $
		 */
		for(int i = 5; i>0;i--) {
			for(int j =0; j < 6-i ; j++);
			System.out.print("$");
		}
		//for (int k =0; k  )
//		System.out.println("");
		
		
	
	}

}
