package ch05_재귀알고리즘;
/*
 * //실습 5-6 : recursive의 tail 부분을 non-recursive 코드로 수정
 * 
 */
//

import java.util.Scanner;

class 실습5_3_1Recursive_while문 {
 //--- 꼬리 재귀를 제거한 recur ---교재 174페이지 실습5-4//
 static void recur(int n) {
     while (n > 0) { //recur(n-2) 호출을 while 로 변경
    	 System.out.println("recur(" + n + " - 1) 호출됨");
         recur(n - 1);
         System.out.println("n ========= " + n);
         System.out.println("    n = " + n + " - 2으로 계산됨");
         //recur(n-2);	//if문 #조건이 참이면 한 번만 실행
         //while 루프는 매 반복마다 조건을 다시 확인->변경된 n 값이 while 조건을 만족하는지 다시 체크
         //실행문이 끝나면 다시 while 조건식을 확인하고, 참이면 계속 반복
         n = n - 2;	//while문 #조건이 참이면 계속 반복 실행
     }
 }

 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.print("정수를 입력하세요 : ");
     int x = stdIn.nextInt();

     recur(x);
 }
}
