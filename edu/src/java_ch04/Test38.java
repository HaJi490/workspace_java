package java_ch04;

public class Test38 {
	public static void main(String[] args) {
		int[][] arr = new int[3][4];
		for (int i = 0; i < arr.length; i++) 
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = i + j;
		
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) 
					System.out.print(arr[i][j] + " ");
					System.out.println();			
			}
		
		//확장형for문
			System.out.println();
		for (int []n : arr) {
			for (int num: n)
				System.out.print(num + " ");
			System.out.println();
		}

	}
}
