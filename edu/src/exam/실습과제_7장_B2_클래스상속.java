package exam;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public void reduceStock(int quantity) {
		stockQuantity -= quantity;
	}

	public void increaseStock(int quantity) {
		stockQuantity += quantity;
	}
	
	public void show() {
		System.out.println("name = " + name + ", price = " + price + "stockQuantity = " + stockQuantity );
	}
	
	public String toString() {
		return "name = " + name +", price = "+ price + ", stockQuantity = " + stockQuantity;
	}

}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간
	
	//생성자
	public Electronics (String name, double price, int stockQuantity, int warranty) {
		super.setName(name);
		super.setPrice(price);
		super.setStockQuantity(stockQuantity);
		this.warranty = warranty;
	}


	@Override
	public void show() {
		super.show();
		System.out.print(", warranty =" + warranty);
	}

	@Override
	public String toString() {
		return super.toString() +", warranty =" + warranty;	//Item2필드가 private이어서 못쓰니까 toString으로 입력한 값 받음
		
	}
}

//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;
	
	//생성자
	public Clothing (String name, double price, int stockQuantity,String size, String color) {
		//super(name, price, stockQuantity);
		super.setName(name);
		super.setPrice(price);
		super.setStockQuantity(stockQuantity);
		this.size = size;
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return super.toString() + ", size = " + size + ", color =" + color;
	}
}

//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;

	//게터 세터
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void show() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "name = " + cname + ", city = " + city + ", age =" + age;
	}

	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer2 {
	//필드
	static final double REGULARDISCOUNT_RATE = 0.03;
	
	//생성자
	public RegularCustomer(String name, String city, int age) {
		super.setCname(name);
		super.setCity(city);
		super.setAge(age);
		}

	@Override
	double applyDiscount(double totalAmount) {

		return  totalAmount*(1-REGULARDISCOUNT_RATE);// 일반 고객 할인 적용

	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	
	//생성자
	public PremiumCustomer(String name, String city, int age) {
		super.setCname(name);
		super.setCity(city);
		super.setAge(age);
	}

	
	@Override
	double applyDiscount(double totalAmount) {
		return  totalAmount*(1-PREMIUMDISCOUNT_RATE);
	}
}

//Order 클래스
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount; //주문한 제품의 종류
	
	public Order2(Customer2 cust, int gaesu) {
		customer = cust;
		items = new Item2[gaesu];
		quantities = new int[gaesu];
	}


	public void addItem(Item2 item, int quantity) { //laptop, 1
		items[itemCount] = item;
		quantities[itemCount] = quantity;
		item.reduceStock(quantity);
		itemCount++;
	}

	public double calculateTotal() { //이 값을 applyDiscount로
		double total = 0.0;
		for(int i=0 ; i < itemCount ; i++) {
			total += items[i].getPrice() * quantities[i]; //왜 =아니고 +=인지 모르겠
			}
			return total;
	}

	public double calculateDiscountedTotal() {
		return customer.applyDiscount(calculateTotal());		//어떻게 알아서 Regular랑 Premium으로 가는거지

	}

	public void printOrderSummary() {
		System.out.println(customer.toString() + ", discount rate = " );
//					+ if(){		//프리미엄고객이면
//						return PremiumCustomer.PREMIUMDISCOUNT_RATE;
//					}else {
//						return RegularCustomer.REGULARDISCOUNT_RATE;
//					}
					
		for( int i = 0 ; i < itemCount ; i++ ){
				System.out.println(items[i].toString() +", quantity =" +quantities[i]);}
		 //할인된 가격의 합계 출력 할인 금액 합계 출력
		System.out.println("Total =" + calculateTotal() + "\rDiscountedTotal = " + calculateDiscountedTotal());

	}
}

public class 실습과제_7장_B2_클래스상속 {

	public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Item2 laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

//		System.out.println(laptop.toString());
//		laptop.show();
		
		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 4);	//4는 배열의 개수 = 주문최대개수 =생성자매개변수 gaesu
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();
		System.out.println("-".repeat(100));

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
	}
}
