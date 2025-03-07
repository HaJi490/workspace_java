package java_ch04;

public class Test32 {

	public static void main(String[] args) {
		int score[] = {1,2,3,4,5};
		
		for (int i=0; i<score.length; i++) {
			System.out.println(score[i]);
		}
		
		for (int n : score)       //확장for문
			System.out.println(n);
		
		/*
		 * int j =0; while(j<score.length) { System.out.println(score[j++]); score[j]=10
		 * * (j+1); //j++; }
		 */
		

	}

}
