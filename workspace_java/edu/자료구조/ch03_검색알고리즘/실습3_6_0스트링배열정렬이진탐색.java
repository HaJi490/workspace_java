package ch03_검색알고리즘;

/*
 * 3장 2번 실습과제 - 스트링 배열의 정렬과 이진검색 
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class 실습3_6_0스트링배열정렬이진탐색 {
	static void showData(String msg, String[] dt) {
		System.out.println(msg);
		for(String str : dt) {
			System.out.print(str + " ");
		}
		System.out.println("\n");
	}
	
	static void sortData(String[] dt) {
		for ( int i = 0 ; i < dt.length ; i++)
			for(int j = i+1 ; j < dt.length ; j++) {
				if(dt[i].compareTo(dt[j]) > 0) {
					swap(dt, i, j);
				}
			}
	}
		
	static void swap(String[] dt, int i, int j) {
		String temp = dt[i];
		dt[i] = dt[j];
		dt[j]=temp;
	}
	
	static int linearSearch(String[] dt, String key) {
		int i = 0;
		while(true) {
			if(i == dt.length)
				return -1;
			if(dt[i].equals(key))
				return i ;
			i++;
			}
		}
	
	
	
	static int binarySearch(String[] dt, String key) {
		int pl = 0;
		int pr = dt.length -1;
		
		while(pl <= pr) {
			int pc = (pl+pr)/2;
			if(dt[pc].equals(key))
				return pc;
			else if(key.compareTo(dt[pc]) < 0)
				pl = pc+1;
			else if(key.compareTo(dt[pc]) > 0)
				pr = pc-1;
		}
		return -1;
			
	}

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};
		showData("[정렬전]", data);
		sortData(data);//올림차순으로 정렬 교재211-212 단순 선택 정렬 알고리즘으로 구현
		showData("[정렬후]", data);

		String key = "포도";
		int resultIndex = linearSearch(data, key);//교재 100 페이지 seqSearch() 함수로 구현
		System.out.println("\nlinearSearch(포도): key = " + key + ", result 색인 = " + resultIndex);

		key = "배";
		resultIndex = binarySearch(data, key);//교재 109 페이지 binSearch() 함수로 구현
		System.out.println("\nbinarySearch(배):key = " + key + ",  result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 * public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
		 *     @Override
		 *     public int compareTo(String anotherString) { //compareTo #comparable로 구현됨
		 *             return this.compareTo(anotherString);
		 *     }
		 *	}
		 *
		 *  binarySearch(String[], String key)를 호출하면, 
		 *  내부적으로 String 배열이 자동으로 Comparable<String>[]로 해석.
		 */
		resultIndex = Arrays.binarySearch(data, key);//교재 120 페이지 API 참조
		System.out.println("\nArrays.binarySearch(산딸기): key = " + key + ", result = " + resultIndex);
	}
}
