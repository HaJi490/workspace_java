package ch01_기본알고리즘;

import java.util.Arrays;

public class 실습1_5_숫자변환 {
	/*
	 * split(" ")
	 * parseInt(stringArray[i])
	 */
	    // 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
	   public static String[] splitSortString(String input) {
		   String[] arr = input.split(" ");
		   Arrays.sort(arr); // 왜 이걸 바로 리턴하면 안되지(1_2 concat이랑 다른점) > Arrays.sort()는 리턴값이 void니까
		   return arr;  
	   }
	   
	    // 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
	   public static int[] convertSortToIntArray(String[] arr) { //교수님 도움받음!!!!!!
		   int[] data = new int[arr.length];
		   for (int i = 0 ; i < arr.length ; i++) {
			   data[i] = Integer.parseInt(arr[i]); 
		   }
		   Arrays.sort(data);
		   return data;
	   }
	    

	    // 문자열 배열 출력 함수
	   public static void printStringArray(String[] sortedStringArray) {
		   for(String str : sortedStringArray) {
			   System.out.println(str);
		   }
	   }
	    
	    // 정수 배열 출력 함수
	   public static void printIntArray(int[] arr) {
		   for(int i : arr) {
		   System.out.println(i);
		   }
	   }
	    

	    public static void main(String[] args) {
	        String input = "12 111 911 921 94 23 214 222";
	        
	        // 문자열 배열 정렬 및 출력
	        String[] sortedStringArray = splitSortString(input);
	        System.out.println("Sorted String Array:");
	        printStringArray(sortedStringArray); //static없이 객체만드는건 어떻게 만들어지는지
	        
	        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
	        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
	        System.out.println();
	        System.out.println("Sorted Integer Array:");
	        printIntArray(sortedIntArray);
	    }
	

}
