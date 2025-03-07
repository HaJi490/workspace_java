package exam.b4;

import exam.b2.Item;

interface Discountable {
	double getDiscountedPrice(double price);

	double setDiscountedPrice(double price);
}

//Item 추상클래스
abstract class Item {
	private String name; // 제품명
	private double price;// 제품가격
	private int stockQuantity; // 재고량

	
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

	void reduceStock(int quantity) { 
		// 판매시 재고감소 메소드
		stockQuantity -= quantity; 
	}

	void increaseStock(int quantity) {
		stockQuantity += quantity;
	}

	public void show() {
		// name = ***, price=*** 등으로출력
		System.out.println(toString());
	}

	public String toString() { 
								
		return "name = " + name + ", price =" + price + ", stockQuantity = " + stockQuantity;
	}
}

class Electronics extends Item {
	private int warranty;//제품보증기간
	
	 //생성자를Item 클래스를생성자를사용하여구현, this를사용
	public Electronics(String name, double price, int stockQuantity, int warranty) {
		//super(name, price, stockQuantity);		//왜 set으로는 안되는지
		super.setName(name);
		super.setPrice(price);
		super.setStockQuantity(stockQuantity);
		this.warranty = warranty;
	}
	
	 @Override
	 public void show() {
		 System.out.println(toString());
	 } // name = ***, price=*** 등으로출력

	public String toString() {
		return super.toString() + ", warranty = " + warranty;
	}
}


class Clothing extends Item {
	private String size;
	private String color;

	// 생성자를Item 클래스를생성자를사용하여구현, this를사용
	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		//super(name, price) ;
		super.setName(name);
		super.setPrice(price);
		super.setStockQuantity(stockQuantity);
		this.size = size;
		this.color = color;
	}

	@Override
	public void show() {
		System.out.println(toString());
	} // name = ***, price=*** 등으로출력

	public String toString() {
		return super.toString() + ", size = " + size + ", color = " + color;
	}
}

class Customer {
	private String cname;
	private String city;
	private int age;

	// 생성자
	public Customer(String cname, String city, int age) { // 4.생성된 객체의 값을 순서대로 인스턴스에 저장 ㅇㅇ
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

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

	// 메서드
	public void show() {
		// name = ***, city = *** 등으로출력
		System.out.println(toString()); // toString에 저장한 값을 출력
	}

	@Override
	public String toString() {
		return "cname=" + cname + ", city=" + city + ", age=" + age;
	}

}

class RegularCustomer extends Customer{
	
	public RegularCustomer(String cname) {
		
	}
}

class PremiumCustomer extends Customer{

	public PremiumCustomer(String string) {
		
	}
	
}

class Order {
	private Customer customer; // 고객명
	private Item[] items; // 주문제품들
	private int[] quantities;// 주문제품수량들
	private String[] orderDates;// 주문일자들
	private static int count;
	Discountable discountPolicy;

	void addItem(Item item, int quantity) {
		// 주문량이재고량보다적으면
		
	}

	double calculateTotal() {
		// 주문제품들의할인액을모두계산
		return customer.applyDiscount(total);
	}

	void printOrderSummary() {
		// 고객이름출력
		System.out.println(customer.toString());
		// 고객이 주문한 제품이름과 가격을출력
		 for (int i = 0 ; i <count ; i++) {
			 System.out.println (items[i].toString());
		};
		// 할인총액을출력
		
	}
}

public class ExamB4 {
	public static void main() {
		// Item 타입의배열생성
		Item[] items = new Item[4];

		// 배열에Electronics와Clothing 객체추가
		items[0] = new Electronics("Laptop", 1500.00, 24, 2);
		items[1] = new Clothing("T-Shirt", 19.99, 50, "XL", "RED" );
		items[2] = new Electronics("Smartphone", 800.00, 12, 2);
		items[3] = new Clothing("Jeans", 49.99, 60, "XL", "BLUE" );
		
		// 모든 아이템의 이름과 가격출력
		for(Item item : items) {
		
		// 동적바인딩에의해 각 클래스의 show() 메서드가호출
		item.show();
		}

		// 고객생성
		Customer regularCustomer = new RegularCustomer("Alice"); 
		Customer premiumCustomer = new PremiumCustomer("Bob"); 

		//주문생성 및 계산(RegularCustomer) 
		Order regularOrder = new Order(regularCustomer, items); 
		regularOrder.printOrderSummary(); 
		//고객별주문제품, 가격, 주문일자, 할인을
		//테이블형태로출력하는정적메소드코드구현
	}
}

