package ch04_스택과큐;
/*
 * 실습 4_5번 - 정수 배열 원형 큐
 * 교재 148 ~ 157 페이지
 * 교재 소스 코드를 보지 않고 구현 완성 연습 필요 
 * /*
 * num 변수를 사용하지 않고 front == rear 일 때 queue가 full인지 empty 인지를 판단
 * 큐에서는 예외 클래스를 만드는 연습
 */
import java.util.Random;
/*
 * 큐 1번 실습 코드 - 정수들의 큐
 */
import java.util.Scanner;

import ch04_스택과큐.IntQueue3.EmptyIntQueue3Exception;
import ch04_스택과큐.IntQueue3.OverflowIntQueue3Exception;

//int형 고정 길이 큐

class IntQueue3 {
	private int[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean isEmptyTag;

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyIntQueue3Exception extends RuntimeException {
		public EmptyIntQueue3Exception(String msg) {
			//super사용이유 : RuntimeException은 오류 메시지를 저장할 수 있는 생성자를 제공
			super(msg);
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception(String msg) {
			super(msg);
		}
	}

	//--- 생성자(constructor) ---//
	public IntQueue3(int maxlen) {
		que = new int[maxlen];
		capacity = maxlen;
		front = rear = 0;
		isEmptyTag = true;
	}

	//--- 큐에 데이터를 인큐 ---//
	public boolean enque(int x) throws OverflowIntQueue3Exception {
		if(isFull())
			throw new OverflowIntQueue3Exception("enque : stack overflow");
		que[rear++] = x;
		isEmptyTag = false;
		if(rear == capacity)
			rear = 0;
		return true;
	}

	//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyIntQueue3Exception {
		if(isEmpty())
			throw new EmptyIntQueue3Exception("deque : stack empty");
		int result = que[front];
		que[front] = 0;
		front++;
		if(front == capacity)
			front = 0 ;
		if(front == rear)
			isEmptyTag = true;
		return result;
	}

	//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntQueue3Exception {
		if(isEmpty())
			throw new EmptyIntQueue3Exception("peek : stack empty");
		return que[front];
	}

	//--- 큐를 비움 ---//
	public void clear() {
		for(int i = 0 ; i < capacity ; i++) {
			que[i] = 0;
		}
		front=rear=0;
	}

	//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		for(int i = front ; i < rear ; i++ ) {
			if(que[i] == x)
				return i;
		}
		return -1;
	}

	//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		//식 이해하기
		//https://velog.io/@mcc919/Data-Structure-%EC%9B%90%ED%98%95-%ED%81%90Circular-Queue-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0
		//return ((rear - front + 1) + capacity) % capacity;
		if(rear > front)
			return rear - front;
		else if(rear < front)
			return (rear - front) + capacity;
		else if(!isEmptyTag)
			return capacity;
		return 0;	
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		if(isEmptyTag)
			return front == rear;
		return false;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		if(!isEmptyTag)
			return front == rear;
		return false;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if(isEmpty())
			System.out.println("dump : stack empty");
		else {
			for(int i = 0 ; i < size() ; i++) {
				System.out.print(que[(i+front)%capacity] + " ");
			}
		}
	}
			
	
}
	
public class 실습4_3_2정수원형큐_배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue3 oq = new IntQueue3(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				try {
					oq.enque(rndx);
					System.out.print("입력데이터: [" + rndx +"]");
					//System.out.println("인큐한 데이터는" + rndx + "입니다.");
				} catch(OverflowIntQueue3Exception e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (EmptyIntQueue3Exception e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}
		}
	}

}