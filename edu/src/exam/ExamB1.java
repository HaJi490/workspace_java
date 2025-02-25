package exam;

import java.time.LocalDate;

class Item {
	private String name; // 제품명
	private double price;// 제품가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item(String name, double price, int stockQuantity) {		//2. 생성된 객체의 값을 순서대로 인스턴스에 저장 ㅇㅇ
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
	void reduceStock(int quantity) {		//8.addItem으로 실행된 값을 보냄
		// 판매시 재고감소 메소드
		stockQuantity -= quantity;			//8-1.stockQuantity 값은 뭔지?>> main에서 설정함
	}

	void increaseStock(int quantity) {
		stockQuantity += quantity;
	}

	public void show() {
		// name = ***, price=*** 등으로출력
		System.out.println(toString());			//toString으로 값보냄, show나 toString이나 비슷함
	}

	public String toString() {			//12.printOS에서 보낸 건 'laptop'(addItem 메서드)인데 name,price에 값이 할당되는 이유 >> items[0]객체에 저장된 이름과 가격
		return"name = " + name + ", price =" + price ;
	}
}

class Customer {
	private String cname;
	private String city;
	private int age;

	// 생성자
	public Customer(String cname, String city, int age) {		//4.생성된 객체의 값을 순서대로 인스턴스에 저장 ㅇㅇ
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
	
	
}

class Order {
	private Customer customer; // 고객명
	private Item[] items; // 주문제품들
	private int[] quantities;// 주문제품수량들
	private String[] orderDates;// 주문일자들
	private int count = 0; // 배열인덱스

	// 생성자
	public Order(Customer customer) { //5. 참조변수 customer에 참조변수 boy값이 저장됨 // customer만 생성하면 됨 // main의 주문생성에서 boy만 있으니까
		this.customer = customer;		
		items = new Item[10];			//5-1. 생성된 필드의 배열의 데이터자리를 만듦(null) //배열을 10개로 안정하려면 this.items[]=items 하면되나>안됨
		quantities = new int[10];
		orderDates = new String[10];
 	}


	void addItem(Item item, int orderNumber) {		//7. 받은 값(laptop, 1)을 넣어서 실행문 진행//Item클래스인스턴스를 가르키는 참조변수 item
		items[count] = item;						//7-1.count에 들어가는 값 = 0 >> order1진행하면서 0,1 / order2진행하면서 0,1
		quantities[count] = orderNumber;
		orderDates[count] = LocalDate.now().toString();
		item.reduceStock(orderNumber);				//7-2.Item클래스인스턴스에서 reduceR 메서드를 실행한 값을 가져옴
		//items[count].reduceStock(orderNumber);
		count++;									//7-3.왜 ++인지 >> order1에서 [0]배열에 laptop정보저장하고 [1]배열에선 tshirt정보저장
	}

	//금액산정
	double calculateTotal() {
		double total = 0.0;
		for(int i = 0; i < count ; i++) {					//15. i < count인 이유 >> addItem메서드에서 count++한 값 = 2가 넘어옴
			total +=(items[i].getPrice() * quantities[i]);
		}
		return total;
	}

	void printOrderSummary() {
		System.out.println(customer.toString());			//10. Customer클래스 인스턴스를 가르키는 참조변수 customer를 통해 Customer클래스의 toString값 가져옴
		for(int i = 0; i < count ; i++) {
			System.out.println(items[i].toString()+			//11. items가 Item클래스인스턴스의 참조변수니까 Item클래스의 toString 실행한값 가져옴.
					", quantity = " + quantities[i] +", ordeDate = " + orderDates[i]);	//13.addItem메서드에서 저장한 배열에 해당하는 값이 입력됨.
		}
		System.out.println("Total = " + calculateTotal());		//14. calculateT값 가져옴

	}

}

public class ExamB1 {
	public static void main(String[] args) {
		// 아이템생성
		Item laptop = new Item("노트북", 1200.00, 10);		//1. Item클래스타입의 객체를 생성해서 Item클래스타입의 참조변수 laptop에 할당.
		Item tshirt = new Item("티셔츠", 20.00, 50);			//1+. 매개변수값 안넣으면 default생성자가 생김. 위에 생성자에 매개변수를 넣은 생성자가 있으면 ()빈괄호여도 default생성자가 안생기니까 기본생성자를 따로 만들어줘야함.


		// 고객생성
		Customer boy = new Customer("홍길동", "부산", 21);		//3. Cutomer클래스에 boy객체를 생성해서 값을 Customer 클래스(생성자)로 보냄 >1.이 정확한 설명
		Customer girl = new Customer("계백", "양산", 22);

	
		// 주문생성
		Order order1 = new Order(boy); 				//4.Order클래스타입의 객체를 생성. 이때 생성자에 참조변수 boy를 매개변수로 넘김.

		order1.addItem(laptop, 1);					//6.Order클래스의 addItem메서드에 값을 보냄
		order1.addItem(tshirt, 2);
		order1.printOrderSummary();					//9. Order클래스의 printOS 메서드 실행한 값을 나타냄
		System.out.println("-".repeat(70));
		
		Order order2 = new Order(girl); 
		order2.addItem(laptop, 2);
		order2.addItem(tshirt, 1);
		order2.printOrderSummary();
		

	}

}
