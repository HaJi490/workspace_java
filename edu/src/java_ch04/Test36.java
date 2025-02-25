package java_ch04;

public class Test36 {

	public static void main(String[] args) {
		int[][]arr = new int[2][] ;
		arr[0] = new int[5];
		arr[1] = new int[3];
		
		char letter = 'A';
		char[] alpha = new char[26];
		int b = (int)letter + 1;//implicit type casting
		System.out.println((char)b);
		for(int i = 0; i< alpha.length; i++) {
			alpha[i] = (char)(letter + i);//int를 char로 넣을려고해서 오류 (4byte를 1byte에 넣을려고 해서)
		}
		for(char c: alpha)
			System.out.print(c + "");
			


	}

}
