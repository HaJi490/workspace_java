package ch04_스택과큐;
/*
 * 실습 4_1번 - 정수 배열 스택
 * 스택을 정수 배열로 구현
 * 예외 처리 코드 이해가 필요
 * 교재 133 - 실습 4-1 소스코드를 읽어보고 가능하면 책을 보지 않고 소스코드 구현완성 노력이 좋다 
 */

import java.util.Scanner;

//int형 고정 길이 스택

class IntStack3 {
	private int[] stk; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터 : 쌓여있는 데이터수
	
	//생성자
	public IntStack3(int size) {
		try {
			stk = new int[size];//배열길이가 size인 배열본체 생성 
		} catch(OutOfMemoryError x) {
			capacity = 0;
			x.printStackTrace();
		}
		capacity = size;//스택용량 = 매개변수로 받은 값;
		top = 0 ;//생성할때 스택은 비어있으니까 0;
		
	}
	//--- 실행시 예외: 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		//생성자 추가
		public EmptyIntStackException(String msg) {
			super(msg);
		}
	}
	
	/*
	 * public class RuntimeException extends Exception { public
	 * RuntimeException(String message) { super(message); } }
	 */
	
	//--- 실행시 예외: 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		//생성자 추가
		public OverflowIntStackException(String msg) {
			//왜 super로 받는지??
			super(msg);
		}
	}


	//--- 스택에 x를 푸시 ---//
	public boolean push(int x) throws OverflowIntStackException {
		//추가
		//top이 인덱스로 들어갈건데 <=를 쓰면 0에 있는 값을 못구하고 예외처리 되지않나?
		//->top은 인덱스가 아니라 쌓인 데이터 수니까 1부터 시작함!!!!!!
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException("push: stack overflow");
		//x를 받아서 top에 넣고 top을 증가시킴
		//top이 1부터 시작하면 인덱스보다 1씩 클텐데 stk[top]은 값이 없는거 아닌가?
		stk[top++] = x;
		return true;
	}

	//--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public int pop() throws EmptyIntStackException {
		//추가
		if(top <= 0)
			throw new EmptyIntStackException("pop : stack is Empty");
		return stk[--top] ; 
	}

	//--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public int peek() throws EmptyIntStackException {
		//추가
		if(top<0) {
			throw new EmptyIntStackException("peek : stack is Empty");
		}
		return stk[top-1];
	}

	//--- 스택을 비움 ---//
	public void clear() {
		//추가
		top = 0;
	}

	//--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
	public int indexOf(int x) {
		//추가
		for( int i = 0 ; i < stk.length ; i++) {
			if(stk[i] == x) {
				return i;
			}
		}
		return -1;
	}

	//--- 스택의 크기를 반환 ---//
	public int getCapacity() {
		//추가
		return capacity;
	}

	//--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		//추가
		return top;
	}

	//--- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		//추가
		//return top<= 0;
		return size() <= 0;
	}

	//--- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		//추가
		//return top >= capacity;
		return size() >= capacity;
	}
	
	//--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() throws EmptyIntStackException{
		//추가
		for(int num : stk)
			System.out.println(num);
	}
}

public class 실습4_2_0정수스택 {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack3 s = new IntStack3(4); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {

			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					//스택의 top에 x를 넣음
					s.push(x);
				} catch (IntStack3.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 팝
				try {
					//꼭대기의 데이터를 꺼냄 
					//'x='이 왜있는거지 > pop을 적용한 데이터를 가져오는건가?
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack3.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
				//pop한 값이 peek에 나옴, dump해도 나옴 근데 push하면 새값이 나옴
			case 3: // 피크
				try {
					//top에 있는 값을 가져옴
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack3.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;

			case 4: // 덤프
				try {
					s.dump();
				} catch (IntStack3.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다." + e.getMessage());
					e.printStackTrace();
				}
				break;
			}
		}
	}
}