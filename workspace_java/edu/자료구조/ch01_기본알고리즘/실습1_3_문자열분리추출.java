package ch01_기본알고리즘;

import java.util.Arrays;

public class 실습1_3_문자열분리추출 {
	/*
	 * split(",")
	 * trim()
	 * Arrays.sort(list)
	 * equals(target)
	 */
	    // 문자열을 comma로 분리하여 배열로 저장하고 정렬하는 함수
	    

	    // 배열에서 특정 문자열을 찾는 함수 (있으면 true, 없으면 false 반환)
	 public static int findAllString(String[] array, String target) {
	    	int num = 0; //if문안에 들어가면 계속 0으로 리셋
	    	for (String str : array) {
	    		if(str.equals(target)) { //array[str]할거없이 바로 str로 비교하면됨
	    			num++;
	    		}
	    	}
	    	return num;
	    }


	    public static void main(String[] args) {
	        String s = "한국, 일본,미국,중국 , 미국 ,   독일   ,   프랑스, 미국 ";
	        
	        // 문자열을 분리하고 정렬한 배열을 반환, 분리된 문자열의 앞뒤 공백도 제거
	        String[] sortedArray = s.split(",");//split() #지정한 구분자로 문자열 자른후 String[] 배열로 반환 p.419
	        for(int i = 0 ; i < sortedArray.length ; i++) {
	        	sortedArray[i] = sortedArray[i].trim(); // trim() #공백제거
	        }
	        Arrays.sort(sortedArray);//ArrayList가 아니라 기본API Arrays클래스 p.440
	        		
	        // 정렬된 배열 출력
	        System.out.println("Sorted Array:");
	        for (String item : sortedArray) {
	            System.out.print(item + " ");
	        }
	        System.out.println("\nArray length = " + sortedArray.length);
	        
	        // 특정 문자열 찾기
	        String target = "미국";
	        int frequency = findAllString(sortedArray, target);
	        System.out.println("빈도수 = " + frequency);
	  
	    }
	    
	   
}
