package exam.b2;

import java.time.LocalDate;

class Item {
	private String name; // 제품명
	private double price;// 제품가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item(String name, double price, int stockQuantity) {		
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	//게터 세터
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
	
	//메서드
	void reduceStock(int quantity) {		
		// 판매시 재고감소 메소드
		stockQuantity -= quantity;			
	}

	void increaseStock(int quantity) {
		stockQuantity += quantity;
	}

	public void show() {
		// name = ***, price=*** 등으로출력
		System.out.println(toString());			//toString으로 값보냄, show나 toString이나 비슷함
	}

	public String toString() {			
		return"name = " + name + ", price =" + price ;
	}
}

class Electronics extends Item {
	private int warranty;//제품보증기간
	
	 //생성자를Item 클래스를생성자를사용하여구현, this를사용
	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);		//왜 set으로는 안되는지
//		super.setName(name);
//		super.setPrice(price);
//		super.setStockQuantity(stockQuantity);
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
		super(name, price, stockQuantity) ;
//		super.setName(name);
//		super.setPrice(price);
//		super.setStockQuantity(stockQuantity);
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
	public Customer(String cname, String city, int age) {		
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	// 메서드
	public void show() {
		// name = ***, city = *** 등으로출력
		System.out.println(toString());				//toString에 저장한 값을 출력
	}

	@Override
	public String toString() {
		return "cname=" + cname + ", city=" + city + ", age=" + age;
	}

	public int getDiscountRate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

class PremiumCustomer extends Customer {
	private float discountRate;

//생성자를Customer 클래스생성자를사용하여구현, this를사용
	
	public PremiumCustomer(String cname, String city, int age, float discountRate) {
		super(cname, city, age);
		this.discountRate = discountRate;
	}
	
	
	public float getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}


	@Override
	public void show() {
		System.out.println(toString());
	} // name = ***, price=*** 등으로출력

	public String toString() {
		return super.toString() + ", discountRate = " + discountRate;
	}
}
	

class Order {
	private Customer customer; // 고객명
	private Item[] items; // 주문제품들
	private int[] quantities;// 주문제품수량들
	private String[] orderDates;// 주문일자들
	private int count = 0; // 배열인덱스

	// 생성자
	public Order(Customer customer) { 
		this.customer = customer;		
		items = new Item[10];			
		quantities = new int[10];
		orderDates = new String[10];
 	}


	void addItem(Item item, int orderNumber) {		
		items[count] = item;						
		quantities[count] = orderNumber;
		orderDates[count] = LocalDate.now().toString();
		item.reduceStock(orderNumber);				
		//items[count].reduceStock(orderNumber);
		count++;									
	}

	//금액산정
	double calculateTotal() {
		double total = 0.0;
		for(int i = 0; i < count ; i++) {					
			total +=(items[i].getPrice() * quantities[i]);
		}
		return total;
	}
	
	
	

	void printOrderSummary() {
		System.out.println(customer.toString());			
		for(int i = 0; i < count ; i++) {
			System.out.println(items[i].toString()+			
					", quantity = " + quantities[i] +", ordeDate = " + orderDates[i]);	
		}
		System.out.println("Total = " + calculateTotal());		
	}

}


public class ExamB2 {
	public static void main(String[] args) {
		//if문을 써서 instanceof가 타입을 비교해줌. 이 2개 타입캐스팅을 해라
		
		// 아이템생성
		Item laptop = new Electronics("노트북",1200.00,10,2); 
		Item tshirt = new Clothing("티셔츠",20.00,50,"XL","RED"); 
		
		//고객생성
		Customer boy = new PremiumCustomer("홍길동","부산",21,0.2f); //f가 타입캐스팅 (float)역할?
		Customer girl = new Customer("계백", "양산", 22); 
		
		
		
		//주문생성(홍길동)
		Order order1 = new Order(boy);
		order1.addItem(tshirt, 2);
		order1.addItem(laptop, 1);
		order1.printOrderSummary();
		if(boy instanceof PremiunCustomer) {
		PremiumCustomer.boy = (PremiumCustomer).boy2
			System.out.println("\t =>" + order1.calculateTotal()*(1 - PremiumCustomer.getDiscountRate()) +" [Discount]");
		}
		System.out.println("-".repeat(100));
		
		
		Order order2 = new Order(girl);
		order2.addItem(tshirt, 1);
		order2.addItem(laptop, 2);
		order2.printOrderSummary();
	}
}