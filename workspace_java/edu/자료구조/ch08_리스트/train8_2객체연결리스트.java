package ch08_리스트;
/*
 * 정수 리스트 > 객체 리스트: 2번째 실습 대상
 */
import java.util.Comparator;
import java.util.Scanner;


class SimpleObject5 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름
	private String expire;//  유효기간 필드를 추가
	
	public SimpleObject5() {
		no = null;name = null;
	}
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}
	
	
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {//sw가 3이면 11 비트 연산 >  NO, NAME을 모두 입력받는다 
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임 sw가 3이면 &는 비트 연산이므로 결과는 1 //& #이진수로 나타냈을 때 자릿수가 둘다 1인 자릿수만 계산함
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {//sw가 3이고 NAME과 비트 & 연산하면 결과는 2
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject5> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject5> {
		public int compare(SimpleObject5 d1, SimpleObject5 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no)<0) ? -1 : 0;// d1 > d2 = 1(d1이 뒤쪽으로 가야함) ; d1 < d2 =-1 ; d1 = d2 = 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject5> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject5> {
		public int compare(SimpleObject5 d1, SimpleObject5 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}
class Node2 {
	SimpleObject5 data;
	Node2 link;
	
	public Node2(SimpleObject5 element) {
		data = element;
		link = null;
	}
}

class LinkedList2 {
	Node2 first;
	
	public LinkedList2() {
		first = null;
	}
	
	public int Delete(SimpleObject5 element, Comparator<SimpleObject5> cc)
	//전달된 element를 찾을 때 comparator 객체를 사용한다 
	{
//		Node2 q, current = first;
//		q = current;
		
		Node2 p = first, q=null;
		while(p!= null) {
			if ( cc.compare(element, p.data) == 0)
				if( p != first) {
					q.link = p.link;
					return Integer.parseInt(p.data.getNo());
				}else {
					first = p.link;
					return Integer.parseInt(p.data.getNo());
				}
			q = p; p = p.link;
		}

		return -1;// 삭제할 대상이 없다.
	}
	
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node2 p = first;
		SimpleObject5 so;
		
		while(p != null) {
			System.out.println( p.data.toString());
			p=p.link;
		}
	}
	
	public void Add(SimpleObject5 element, Comparator<SimpleObject5> cc) 
	//임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node2 newNode = new Node2(element);//data = element;
		Node2 p = first, q= null;
		if (first == null) {//insert into empty list
			first = newNode;
			return;
		}
		while(p !=null) { 
			if(cc.compare(element, p.data) < 0) { //newNode가 p보다 작을때
				newNode.link = p;
				if(q != null) {//중간에 넣을 때
					q.link = newNode;
					return;
				}else { //first에 넣을떄
					first = newNode;
					return;
				}
			}
			//newNode가 더 크면
			q = p; p = p.link;	
		}
		//제일 끝자리
		q.link = newNode;
	}
	
	//검색안됨
	public boolean Search(SimpleObject5 element, Comparator<SimpleObject5> cc) { 
		// 전체 리스트를 올림차순 순서대로 출력한다.
//		Node2 q, current = first;
//		q = current;
		Node2 p = first;
		while(p != null) {
			if(cc.compare(element, p.data) == 0) 
				return true;
			p = p.link;
		}
		return false;
	}
	
//	void Merge(LinkedList2 b, Comparator<SimpleObject5> cc) {
//		/*
//		 * 연결리스트 a,b에 대하여 a = a + b
//		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
//		 * 난이도 등급: 최상급
//		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
//		 */
//		// b가 비어있으면 병합할 필요없음
//		if(b.first == null) return;
//		
//		// 현재 리스트가 비어있으면 b를 그대로 사용
//		if(first == null) {
//			first = b.first;
//			return;
//		}
//		
//		Node2 pl = first, q = null;
//		Node2 pl2 = b.first, q2 =null;
//		
//		while( pl != null && pl2 != null) {//pl2가 다 크면 pl2가 안나옴/ l2마지막만 병합----------------------------------------
//			if(cc.compare(pl.data, pl2.data) == 1){//pl이 더 클때
//				q2 = pl2;
//				if(pl == first) {
//					first = pl2;
//					pl2 = pl2.link;
//					q2.link = pl;
//				}else {
//					pl2 = pl2.link;
//					q2.link = pl;
//					if(pl2 == null) break;
//				}
//				while(cc.compare(pl.data, pl2.data) == 1) {//pl이 더 크면
//					q2.link = pl2;
//					q2 = pl2;
//					pl2 = pl2.link;
//					q2.link = pl;
//					if(pl2 == null) break;
//				}
//				
//			}else {//pl이 더 작을때
//				q = pl;
//				pl = pl.link;
//				q.link = pl2;
//				if(pl == null) break;
//				while(cc.compare(pl.data, pl2.data) == -1) {
//					q.link = pl;
//					q = pl;
//					pl = pl.link;
//					q.link = pl;
//					if(pl == null) break;
//				}
//			}
//		}
//	}
	void Merge(LinkedList2 b, Comparator<SimpleObject5> cc) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
		// b가 비어있으면 병합할 필요없음
		if(b.first == null) return;
		
		// 현재 리스트가 비어있으면 b를 그대로 사용
		if(first == null) {
			first = b.first;
			return;
		}
		
		Node2 result = null; // 결과리스트의 머리
		Node2 tail = null; // 결과리스트의 마지막 노드
		Node2 p1 = first; // 현재리스트의 포인터
		Node2 p2 = b.first; // b리스트의 포인터
		
		//결과 리스트의 첫 노드 결정
		if( cc.compare(p1.data, p2.data) <= 0) { //p1이 작거나 같으면
			result = p1;
			p1 = p1.link;
		}else {
			result = p2;
			p2 = p2.link;
		}
		
		tail = result;
		
		//두 리스트를 병합
		while (p1 != null && p2 != null) {
			if (cc.compare(p1.data, p2.data) <= 0) {
				tail.link = p1;
				tail = p1;
				p1 = p1.link;
			}else {
				tail.link = p2;
				tail = p2;
				p2 = p2.link;
			}
		}
		
		//남은 노드 연결
		if(p1 != null) {
			tail.link = p1;
		}else {
			tail.link = p2;
		}
		
		//새로 병합된 리스트를 current로 설정
		first = result;

	}
	
}

public class train8_2객체연결리스트 {

	enum Menu {
		Add( "삽입"), Delete( "삭제"), Show( "인쇄"), Search( "검색"), Merge("합병"), Exit( "종료");

		private final String message;                // 표시할 문자열

		static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {                        // 생성자(constructor)
			message = string;
		}

		String getMessage() {                        // 표시할 문자열을 반환
			return message;
		}
	}

	//--- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 &&
						m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() ||key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;                               
		LinkedList2 l = new LinkedList2();
		LinkedList2 l2 = new LinkedList2();
		Scanner sc = new Scanner(System.in);
		int count = 3; //3개의 객체 입력 개수
		SimpleObject5 data;
		do {
			switch (menu = SelectMenu()) {
			case Add :                          
				data = new SimpleObject5();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject5.NO_ORDER);//회원번호 순서로 정렬 입력
				break;
			case Delete :                         
				data = new SimpleObject5();
				data.scanData("삭제", SimpleObject5.NO);
				int num = l.Delete(data, SimpleObject5.NO_ORDER);//회원번호 조건 비교하여 삭제 
				System.out.println("삭제된 데이터: " + num + "\n");
				break;
			case Show :                           
				l.Show();
				break;
			case Search : // 회원 번호 검색
				data = new SimpleObject5();
				data.scanData("탐색", SimpleObject5.NO);
				boolean result = l.Search(data, SimpleObject5.NO_ORDER);//회원번호로 검색
				if (result)
					System.out.println("검색 성공 = " + result +"\n");
				else
					System.out.println("검색 실패 = " + result +"\n");
				break;
			case Merge://난이도 상
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					data = new SimpleObject5();
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
				break;
			case Exit :                           // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}


