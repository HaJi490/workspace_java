package ch03_검색알고리즘;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class 실습3_4정수배열이진탐색 {
	
	static Random rnd = new Random();
	
	static void inputData(int[] dt) {
		for(int i = 0; i < dt.length; i++) {
			dt[i] = rnd.nextInt(30)+1;
		}
	}
	
	static void showList(String msg, int[] dt) {
		System.out.println(msg);
		for(int num : dt) {
			System.out.print(num + ", ");
		}
		System.out.println("\n");
	}
	
	static boolean linearSearch(int[] dt, int key) {
		int count = 0;
		//while문의 true 조건식은 무한루프 > 그러나 return문을 만나면 실행종료
		//조건식이 true일 때 {}안의 실행문들이 실행되는거
		while(true) {
			for(int i = 0; i < dt.length ; i++) {
				if(count == dt.length-1)
					return false;
				if(dt[i] == key)
					return true;
				count++;
			}
		}
	}
	
	static boolean binarySearch(int[] dt, int key) {
		int pl =0;
		int pr =dt.length -1;
		
		//조건식이 true일때 실행되는거니까
		while(pl <= pr) {
			int pc = (pl+pr)/2;
			if(dt[pc] == key)
				return true;
			else if(dt[pc] < key)
				pl = pc+1;
			else if(dt[pc] > key)
				pr = pc-1;
		}
		return false;
	}

	public static void main(String[] args) {
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = 13;
		boolean resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch(13): key = " + key + ", result = " + resultIndex);

		key = 19;
		/*
		 * 교재 109~113
		 */
		//binarysearch를 하려면 오름차순으로 정렬된 배열
		resultIndex = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch(19): key = " + key + ", result = " + resultIndex);
		
		key = 10;
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		//resultIndex는 boolean인데 어떻게 저 값을 받는지
		//resultIndex= Arrays.binarySearch(data, key);
		int resultArr = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + resultArr);

	}
}

