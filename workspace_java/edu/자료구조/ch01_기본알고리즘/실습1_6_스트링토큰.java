package ch01_기본알고리즘;

import java.util.Arrays;

public class 실습1_6_스트링토큰 {
	/*
	 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
	 * parseDouble(stringArray[i])
	 */
	    //문자열 배열 저장하고 정렬하는 함수
		public static String[] extractSortStrings(String msg) {
			String[] arr = msg.split(" ");
			Arrays.sort(arr);
			return arr;
		}
	
		// 문자열을 실수로 추출하여 배열에 저장하고 정렬하는 함수
		public static double[] convertSortToDouble(String[] arr) {
			double[] data = new double[arr.length];
			for(int i = 0 ; i < arr.length ; i++) {
				data[i] = Double.parseDouble(arr[i]);
			}
			Arrays.sort(data);
			return data;
		}
	    

	    // 문자열 배열을 실수 배열로 변환한 후 정렬하는 함수
	       
	    // 문자열 배열을 실수 배열로 변환
	        

	    // 문자열 배열 출력 함수
	    public static void printStringArray(String[] arr) {
	    	for(String str : arr) {
	    		System.out.println(str);
	    	}
	    }

	    // 실수 배열 출력 함수
	    public static void printDoubleArray(double[] arr) {
	    	for(double doub : arr) {
	    		System.out.println(doub);
	    	}
	    }
	
	    

	    public static void main(String[] args) {
	        String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";
	        
	        // 실수를 문자열로 추출하고 정렬 후 출력
	        String[] sortedStringArray = extractSortStrings(msg);
	        System.out.println("정렬 스트링 배열:");
	        printStringArray(sortedStringArray);
	        
	        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
	        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
	        System.out.println("\n정렬 실수 배열:");
	        printDoubleArray(sortedDoubleArray);
	    }

}
