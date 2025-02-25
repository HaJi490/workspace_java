package java_ch05;

public class Gugudan {

	// 메소드
//	public void print(int num) {
//		for (int i = 2; i < 10; i++) {
//			System.out.print(i + "x" + num + "=" + (num * i) + "\t");
//		}
//	}

//	public void printVertical() {
//		for(int i =2 ; i<10 ; i++) {
//			print(i);                   //2. print 메소드에서 for문 실행
//			System.out.println("-".repeat(20));
//		}
//		print(2);
//		print(3);
//

//	//Horizontal
//	public void printHorizontal() {
//		for (int i = 1; i < 10; i++) {
//			print(i);
//			//printColumn();
//			System.out.println();
//		}
//	}

	// printColumn
	public void printColumn(int col) {
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + "x" + j + "=" + (j * i) + "\t");
				for (int k =i; k > col; k++) {
					System.out.println();
				}
			}

		}
	}

}
