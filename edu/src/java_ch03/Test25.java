package java_ch03;

import java.util.Scanner;

public class Test25 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("입력할 단: ");
		int dan = scn.nextInt();//입력받기 때문에
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "x "+ i + " = " + dan * i);
		}

	}
	
}
