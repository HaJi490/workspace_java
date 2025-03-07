package ch02_기본자료구조;

import java.util.Random;
/*
 * 2장: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */
public class 실습2_4메소드배열전달 {
		static int top = 8; //어디쓰는건지 > 배열을 10개 만들더라도 8개만 쓸 수 있다
		static final int MAX_LENGTH = 20;
		
		//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
		static void showData(String str, int[] data) {
			System.out.println(str);
			for(int i = 0 ; i<top ; i++)
				System.out.println( data[i]);
			
		}
		
		//top이 배열에 저장된 갯수를 저장
		static void inputData(int[] data) {//교재 63 - 난수의 생성
			Random rnd = new Random();
			for(int i = 0 ; i < top ; i++) {
				data[i] = rnd.nextInt(MAX_LENGTH);
			}
		}
		
		//최대값을 리턴한다 
		static int findMax(int[] data) { //교수님도움받음!!!!
			//int arr[] = new int[data.length];
			int max = 0;
			for(int i = 0 ; i < top ; i++) {
				if(data[i] > max) 
					max=data[i];
			}
			return max;
		}
		
		//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		static boolean findValue(int[] dt, int num) {
			for(int element : dt) {
				if(element == num)  { 
					return true;
				}
			}
			return false;
		}
		
		//역순 출력
		static int[] reverse(int[] dt) { //교수님도움받음!!!!!!
			for(int i = 0 ; i < top/2 ; i++) {
				int j = top -1 -i;
				int temp = dt[i];
				dt[i] = dt[j];
				dt[j] = temp;
			}
			return dt;
		}
		
		
		public static void main(String[] args) {
			int []data = new int[10];
			inputData(data);//함수호출 - 매개변수 전달
			showData("소스데이터",data);
			int max = findMax(data);
			System.out.println("\nmax = " + max);
			boolean existValue = findValue(data, 3);
			System.out.println("\n찾는 값 = " + 3 + ", 존재여부 = " + existValue);
			reverse(data);// 역순으로 출력 
			showData("\n역순 데이터", data);
			
		}
		

}
