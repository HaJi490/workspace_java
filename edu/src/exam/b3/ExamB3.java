package exam.b3;

//Discountable 클래스
interface Discountable {
	double getDiscountedPrice(double price);
	
	double setDiscountedPrice(double price);
}

//SeasonalDiscount 클래스
class SeasonalDiscount implements Discountable {
	private double discountRate;
	
	public SeasonalDiscount(double discountRate) {
		this.discountRate = discountRate;
	}

	// Discountable 인터페이스메서드구현
	
	@Override
	public double getDiscountedPrice(double price) {
		return price * (1 - discountRate);
	}

	@Override
	public double setDiscountedPrice(double price) {
		return 0;
	}
}


//Customer class
abstract class Customer {
	private String name;
	
	public Customer(String name) {
		this.name = name;
	}

	abstract double applyDiscount(double totalAmount);
}


//RegularCustomer 클래스(Customer 상속)
class RegularCustomer extends Customer {

	public RegularCustomer(String name) {
		super(name);
	}

	double applyDiscount(double totalAmount) {
		return totalAmount;
	}
}


//PremiumCustomer 클래스(Customer 상속)
class PremiumCustomer extends Customer {
	static final double DISCOUNT_RATE = 0.1;
	
	public PremiumCustomer(String name) {
		super(name);
	}

	double applyDiscount(double totalAmount) {
		return totalAmount * (1 - DISCOUNT_RATE);
		
	}
}



public class ExamB3 {
	
	public static void main(String[] args) {
		
	
	// 고객생성
	Customer regularCustomer = new RegularCustomer("홍길동");
	Customer premiumCustomer = new PremiumCustomer("김유신");
	double itemPrice = 100.0; 
	System.out.println("itemPrice :" + itemPrice);
	// 아이템생성(가격은임의로설정)
	
	
	
	// 할인정책결정(계절할인예시)
	Discountable seasonalDiscount = new SeasonalDiscount(0.2);
	
	// 20% 할인
	double discountedPrice = seasonalDiscount.getDiscountedPrice(itemPrice);
	System.out.println("discountedPrice = " + discountedPrice); 
	
	// 일반고객의주문생성
	double regularCustomerFinalPrice = regularCustomer.applyDiscount(discountedPrice);
	System.out.println("regularCustomerFinalPrice = " + regularCustomerFinalPrice);
	
	// 프리미엄고객의주문생성
	double premiumCustomerFinalPrice = premiumCustomer.applyDiscount(discountedPrice);
	System.out.println("premiumCustomerFinalPrice = " + premiumCustomerFinalPrice);
	}
}
