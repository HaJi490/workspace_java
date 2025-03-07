package ch02_기본자료구조;
/*
 * 2장 - 정수 배열 정렬
 */

//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class 실습2_5정수배열정렬 {

	
	static void showData(String msg, int[]data) {
		System.out.println(msg);
		for(int num : data) {
			System.out.print(num + " ");
		}
	}
	
	static void inputData(int []data) {
		Random rnd = new Random();
		for(int i = 0 ; i < data.length; i++ ) {
			data[i] = rnd.nextInt(100);
		}
	}
	
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	static void sortData(int []arr) {
		for(int i = 0 ; i< arr.length ; i++)
			for(int j = i+1 ; j < arr.length ; j++) {
				if(arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
	}
	
	static void reverse(int[] a) {//교재 67페이지
		for(int i = 0 ; i< a.length/2 ; i++) {
			swap(a, i, a.length -1 -i);
		}
			
			
	}
	static void reverseSort(int []arr) {
		for(int i = 0 ; i< arr.length ; i++)
			for(int j = i+1 ; j < arr.length ; j++) {
				if(arr[i] < arr[j]) {
					swap(arr, i, j);
				}
			}
	}
	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 */
	static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length + 1];
			for(int i = 0 ; i < data.length; i++) {
				newData[i] = data[i];
				newData[data.length] = value;
			}
			for(int i = 0 ; i < newData.length; i++)
				for(int j = i+1; j< newData.length; j++) {
					if(newData[i] > newData[j]) {
						swap(newData, i, j);
					}
				}
//			for(int i = 0 ; i < data.length; i++) {//안됨
//				if(data[i] < value) {
//					newData[i] = data[i];
//				}else {
//					newData[i] = value;
//					newData[i+1] = data[i];
//				}
//			}
			return newData;

		
	}
	
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("난수 입력", data);
		
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("\n역순 재배치", data);
		
		sortData(data);
		showData("\n정렬후", data);
		
		reverseSort(data);//역순으로 재배치 - 정렬
		showData("\n역순 정렬후", data);
		sortData(data);
		int realData = 15;
		int []result = insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		showData("\n실수 삽입후", result);
	}
	
	

}
