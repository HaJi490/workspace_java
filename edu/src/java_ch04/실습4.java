package java_ch04;

public class 실습4 {
	public static void sum1() {
		int sum =0;
		for(int i =1; i<=100;i++) {	
			if (i % 2 == 0) {
				sum += i;
			}
			 
			//sum +=(i%2==0)?sum+i:sum;
			//sum = (i%2==0)?sum+i:sum;
		}
		System.out.println("짝수합:\t" + sum);
	}
	public static void main(String[] args) {
		
		System.out.println("*".repeat(60));
		sum1();//method
		//System.out.println('-'.repeat(60));
	}
	}

