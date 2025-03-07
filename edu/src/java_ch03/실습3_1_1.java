package java_ch03;

public class 실습3_1_1 {
	public static void main(String[] args) {
		

		
			int score = 65;
			//String result = "";
			char grade =0;
			if(score>=90) {
				grade = 'A';
			} else if(score>=80) {
				grade = 'B';
			} else if(score>=70) {
				grade = 'C';
			} else if(score>=60) {
				grade = 'D';
			}
			
			System.out.println(grade);
			
			int weight = 3500;
			//String result = "";
			int price = 0;
			if(weight<=1000) {
				price = 3000;			
			} else if (weight>1000 && weight<5000) {
				price = 5000;
			} else if (weight>=5000 && weight<10000) {
				price = 8000;
			} else if (weight>=10000) {
				price = 12000;
			}
			System.out.println("택배요금 =" + price);
		}

	}
