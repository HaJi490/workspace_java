package java_ch09API;
/*
 * 실습 과제 - 스트링의 정렬
 */
import java.util.Arrays;

public class Test12_실습대상 {
	static void showData(String[]arr) {	//배열의 변수 타입을 넣어야됨
		System.out.println();
		for (String st: arr)	//확장형 for문
			System.out.print(st + " -> ");
	}
	static void sortData(String[]arr, int[]arrInt) {
		for (int i = 0; i< arr.length;i++)
		{
			arrInt[i] = Integer.parseInt(arr[i]);	//3. 정수로 바꿔서
		}
		Arrays.sort(arrInt);	//4. 정렬, 전달을 안해도 배열이 적용되어있음. 배열은 그대로있기때문(2.)
	}
	static void showNumber(int[]arr) {
		System.out.println();
		for (int n: arr)
			System.out.print(n + " -> ");
	}
	public static void main(String[] args) {
		// string 정렬의 문제 
		String arr[] = {"12", "9", "22", "5"};
		showData(arr);	//메서드 생성
		Arrays.sort(arr);	//대문자로 시작하면 일단 클래스
		showData(arr);
		
		int n1 = 10;
		Integer obj1 = n1; // 명령문이 컴파일되면서 Integer.valueOf(n1)로 변환 > 오토박싱, 참조타입변수에 기본타입변수 저장
		//obj1.* - methods를 사용하기 위해
		
		Integer obj2 = Integer.parseInt("20");// "9", "12" 정렬시에는 12,9가 온다 이때 필요	//String을 정수로 바꿀때
		int n2 = obj2; // obj2.intValue() > 오토박싱, 기본타입변수에 참조타입변수 저장
		//obj2.hashCode();
		
		Integer obj3 = 30; // new Integer(30)

		int n3 = obj3 + 40;	

		System.out.println("\n" + n1 + " : " + obj1);
		System.out.println(obj2 + " : " + n2);
		System.out.println(n3);
		//정수로 배열로 변환후 정렬 
		int []arrInt = new int[arr.length]; //1. 메모리에 빈 배열을 만듦.
		sortData(arr, arrInt); //2. sortData메서드로 인자를 넘김, 배열은 그대로 있음, arr은 스트링배열
		showNumber(arrInt);

	}
}
