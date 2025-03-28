package ch05_재귀알고리즘;

import java.util.Stack;

// 프로그래머스 159993 검색
/*
BFS
DFS

*/
//public class review5_7_3미로찾기 {
//	public int solution(String[] maps) {
//		int answer = 0;
//		return answer;
//	}
//}



/*
 * 미로 찾기 문제
 * -문제: 미로 테이블 (12,15)을 상하좌우 울타리를 친 maze[14][17]을 만들고 입구는 (1,1)이며 출구는(12,15)
 * -조건: stack을 사용한 backtracking 구현
 * 
 */

//enum -> 불변객체, 잘쓰면 좋음

class Items1 {
	int x;
	int y;
	int dir;
	
	public Items1(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

class Offsets1 {
	int a;
	int b;
	
	public Offsets1(int a, int b) {
		this.a = a;
		this.b = b;
	}

}

public class review5_7_3미로찾기 {
	static Offsets1[] moves = new Offsets1[8];//static을 선언하는 이유를 알아야 한다
	int[][] maze = new int[14][17];
	int[][] mark = new int[14][17];//1. main에 있는데 왜 선언? 2.완전 똑같은데 오류x?
	

	static void path(int maze[][], int mark[][], int m, int p){//m = 12, p = 15
		Stack<Items1> stk = new Stack<Items1>();
		stk.push(new Items1(1, 1, 2)); // new Items는 스택에 넣어주고 사라짐//미로 첫시작은 남,서(코딩 기본)
		
		while(!stk.empty()) {
			//초기화
			Items1 items = stk.pop();
			int i = items.x;
			int j = items.y;
			int dir = items.dir;
			mark[i][j] = 1;
			
			while(dir < 8) {
				int g = i + moves[dir].a;
				int h = j + moves[dir].b;
				
				if( g == m && h == p) {//출구에 도착했을때
					mark[g][h] = 1;
					System.out.println("미로 찾기 성공!");
					return;
				}
				else if (maze[g][h] == 0 && mark[g][h] == 0) {// 통로 && 한번도 간적없음
					mark[g][h] = 1;
					stk.push(new Items1(i, j, dir+1)); //현재위치, 다음방향(pop하면서 돌아갈때 다음방향부터 시작하기 위해서)
					i = g; j = h;
					dir = 0; 
				}else {
					dir++;
				}
						
			}
			mark[i][j] = 0; //pop하면서 뒤로가면서 지움
		}
		System.out.println("실패!");
	}

	static void show(String msg, int[][] arr) {
		System.out.println(msg);
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0; j<arr[0].length ; j++) {
				System.out.print(arr[i][j] );
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] maze = new int[14][17];
		int[][] mark = new int[14][17];

		int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
		
		for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets1(0, 0);//배열에 offsets 객체를 치환해야 한다.
		
		moves[0].a = -1;	moves[0].b = 0; //N
		moves[1].a = -1;	moves[1].b = 1;	//NE
		moves[2].a = 0;		moves[2].b = 1;//e
		moves[3].a = 1;		moves[3].b = 1;//SE
		moves[4].a = 1;		moves[4].b = 0;//S
		moves[5].a = 1;		moves[5].b = -1;//SW
		moves[6].a = 0;		moves[6].b = -1;//W
		moves[7].a = -1;	moves[7].b = -1;//NW

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 17; j++) {
				//input[][]을 maze[][]로 복사
				if(i == 0 || i == 13 || j == 0 || j==16) {
					maze[i][j] = 1;
					mark[i][j] = 1;
				}else {
				maze[i][j] = input[i-1][j-1];
				mark[i][j] = 0;
				}
			}
		}
		

		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);

		path(maze, mark, 12, 15);
		show("maze[12,15]::", maze);
		show("mark[12,15]::", mark);


	}
}
