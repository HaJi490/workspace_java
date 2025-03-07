package ch01_기본알고리즘;

import java.util.Arrays;

public class 실습1_4_문자데이터변환 {
	/*
	 * valueOf(boolVal)
	 * Arrays.sort(array)
	 */
	    // 값을 문자열로 변환하여 배열에 저장하는 함수
		public static String[] convertValuesToString(boolean b, char c, double e, int i, double d) {
			String s1 = Boolean.toString(b);	//다른 타입 문자열로 변환
			String s2 = Character.toString(c);
			String s3 = Double.toString(e);
			String s4 = Integer.toString(i);
			String s5 = Double.toString(d);
			String[] arr = {s1, s2, s3, s4, s5};
			return arr;
		}
	  
	    // 배열을 정렬하는 함수
	    public static void sortStringArray(String[] arr) {
	    	Arrays.sort(arr);
	    }

	    // 배열을 출력하는 함수
	    public static void showAllString(String[] arr) {
	    	for(String str : arr) {
	    		System.out.println(str);
	    	}
	    	
	    }
	    
	    public static void main(String[] args) {
	        // 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
	        String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f); // boolean, char, float, int, double
	        
	        // 정렬 전 배열 출력
	        System.out.println("정렬전:");
	        showAllString(stringArray);
	        
	        // 배열 정렬
	        sortStringArray(stringArray);
	        
	        // 정렬 후 배열 출력
	        System.out.println("\n정렬후:");
	        showAllString(stringArray);
	    }
	

}
