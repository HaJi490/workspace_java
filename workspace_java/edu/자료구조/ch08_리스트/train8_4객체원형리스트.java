package ch08_리스트;
/*
 * p.338~
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트 
 * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject3 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름
	String expire;//  유효기간 필드를 추가
	
	//번호 게터/세터
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public SimpleObject3() {// head node를 만들 때 사용
		this.no = null;
		this.name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node3 {
	SimpleObject3 data;
	Node3 link;

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}


class CircularList {
	Node3 first; //원형일때는 first보다 last를 가리키는게 코드가 더 간결함**

	public CircularList() { //head node(데이터를 갖지않는 더미노드)
		SimpleObject3 data = new SimpleObject3();
		first = new Node3(data);
		first.link = first;
	}
	
//	public CircularList() { //head node업는 버전
//		first = null;
//	}

	/*
	 * static void sortData(Fruit []arr, Comparator<Fruit> cc) { for (int i = 0; i <
	 * arr.length; i++) { for (int j = i; j < arr.length; j++) if
	 * (cc.compare(arr[i], arr[j])> 0) swap(arr, i, j); } }
	 */
	public int Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) { // delete the element
//		Node3 q, current = first.link;
		Node3 p = first.link, q = null;
		// q = current;
		while( p != first) {
			if(cc.compare(element, p.data) == 0) {//삭제할 요소가 있으면
				if ( p != first.link) {
					q.link = p.link;
					while(cc.compare(p.data, p.link.data) == 0) { //같은숫자 여러개
						p = p.link;
						q.link = p.link;
					}
					return Integer.parseInt(p.data.getNo());
				}else{//first.link 삭제할때
					first.link = p.link;
					while(cc.compare(p.data, p.link.data) == 0) { //같은숫자 여러개
						p = p.link;
						first.link = p.link;
					}
					return Integer.parseInt(p.data.getNo());
				}
			}
			q = p; p = p.link;
		}
		return -1;// 삭제할 대상이 없다.
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node3 p = first.link;
		SimpleObject3 so;
		
		while(p != first) {
			System.out.println(p.data);
			p = p.link;
		}

	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) {// 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
		Node3 newNode = new Node3(element);
		// Node3 last = null;
		//head node가 없는 경우 -->항상 더미노드가 있지않나
//		if (first == null) {
//			first = newNode;
//			first.link = first;
//			return;
//		}
		//head node가 있는 경우: 맨처음에 아무것도 없을때 자기자신을 가리킴, 코드가 더 간결함**
		if(first.link == first){// 더미노드만 있음
			newNode.link = first;
			first.link = newNode;
			return;
		}
		
		//넣을 자리 찾기
		Node3 p = first.link, q = null;
		while (p != first) {
			if(cc.compare(element, p.data) == -1 || cc.compare(element, p.data) == 0){// element가 더 작을때
				newNode.link = p;
				if ( p != first.link) {//중간에 넣을때
					q.link = newNode;
					return;
				}else { //first.link에 넣을때
					first.link = newNode;
					return;
				}
			}// element가 더 클때
			q=p; p = p.link;
		}//제일 끝에 넣을때
		q.link = newNode;
		newNode.link = first;
	}
	
	

	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 전체 리스트를 순서대로 출력한다.
		Node3 current = first.link, q = null;
		//Node3 p= first.link; //더미노드 이후부터
		
		while(current != first) {
			if(cc.compare(element, current.data) == 0) {
				return true;
			}
			q = current ; current = current.link;
		}
		return false;
	}
	
	void Merge(CircularList2 b, Comparator<SimpleObject3> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
	}
}

public class train8_4객체원형리스트 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		CircularList l = new CircularList();
		CircularList l2 = new CircularList();
		Scanner sc = new Scanner(System.in);
		SimpleObject3 data;
		int count = 3;//l2 객체의 숫자를 3개로 한다 

		do {
			switch (menu = SelectMenu()) {
			case Add: //
				data = new SimpleObject3();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete: // 
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				int num = l.Delete(data, SimpleObject3.NO_ORDER);
				if(num != -1)
					System.out.println("[삭제 성공] 삭제된 데이터는 " + num);
				else
					System.out.println("[삭제 실패]");
				break;
			case Show: 
				l.Show();
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				boolean result = l.Search(data, SimpleObject3.NO_ORDER);
				if (result)
					System.out.println("검색 성공 = " + result);
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Merge:
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					data = new SimpleObject3();
					data.scanData("병합", 3);
					l2.Add(data, SimpleObject5.NO_ORDER );				
				}
				System.out.println("리스트 l::");
				l.Show();
				System.out.println("리스트 l2::");
				l2.Show();
				l.Merge(l2, SimpleObject5.NO_ORDER);
				//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				System.out.println("병합 리스트 l::");
				l.Show();
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
