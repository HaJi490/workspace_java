package java_ch10API활용;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {
	
	public static void main(String[] args) {
		
		lotto_generateor(5); 
		
	}
	
	public static void lotto_generateor(int n) {
		Random number = new Random();
		HashSet<Integer> lotto = null;	
		for(int i = 0 ; i < n ; i++) {
			
			int count = 0;
			lotto = new HashSet<Integer>();	//HashSet은 중복x
			
			//while(lotto.size()<= 6) {
			for(; lotto.size() <= 6 ;) { //조건식만 남겨둘 수 있음 = while문과 비슷
				lotto.add(number.nextInt(45)+1);
				count++;
			}
			
			List<Integer> L = new ArrayList<Integer>(lotto);
			Collections.sort(L);
			System.out.println(L + " =>" + count);	//count는 몇번 루프돌았는지
		}
	}

}
