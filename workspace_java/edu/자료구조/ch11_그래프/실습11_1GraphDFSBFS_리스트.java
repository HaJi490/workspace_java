package ch11_그래프;

import java.util.*;

/*api/LinkedList는 
보통의 LinkedList처럼 link되어있는게 아니라 
ArrayList처럼 index를 이용해 접근*/

class Graph {
	LinkedList<Integer>[] adjacencyList;
	int n; //배열길이
	boolean[] visited;

	public Graph(int vertices) {
		this.n = vertices;
		adjacencyList = new LinkedList[n];
		for(int i = 0 ; i < n ; i++) {
			adjacencyList[i] = new LinkedList();
		}
	}

	void displayAdjacencyLists() { // ---------------------------------------
		for(int i = 0 ; i < n ; i++) {
			System.out.print(i+ "->");
			for( int num : adjacencyList[i])
				System.out.print(num + " ");
			System.out.println();
		}
	}

	void insertEdge(int start, int end) {
		if(start < 0 || start >= n || end < 0 || end >= n) {
			System.out.println("Node index out of bounds");
			return;
		}
		if(!adjacencyList[start].contains(end)) {
			adjacencyList[start].add(end);
			adjacencyList[end].add(start); // 반대도 추가해줘야함-----------------------------
		}
	}

	void bfs(int startNode) { //입력한 startNode
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		//행렬 버젼에 Queue 설명 참조

		visited[startNode] = true;
		queue.add(startNode);
		
		System.out.print("BFS traversal: ");
		while (!queue.isEmpty()) {
			int visitNode = queue.poll();
			for(int next : adjacencyList[visitNode]) {
				if(!visited[next]) {
					visited[next] = true;
					System.out.print(next + " ");
					queue.offer(next);
				}
			}
		}
		System.out.println();
	}

	void dfs(int startNode) {
		//Arrays.fill(visited, false);
		System.out.print("DFS traversal: ");
		nonRecursiveDfs(startNode);
		System.out.println();
	}

	void nonRecursiveDfs(int startNode) {
		boolean[] visited = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		/*
		 * Stack 클래스는 자바 표준 라이브러리에서 제공되는 클래스
		 * stack.push(10);    // 스택에 값 넣기
		 * stack.pop();       // 스택에서 값 꺼내기 (제거)
		 * stack.peek();      // 맨 위 값 확인 (제거 X)
		 * stack.isEmpty();   // 비어있는지 확인
		 * 
		 * Stack은 오래된 클래스이고, 동기화(synchronized) 때문에 성능 떨어짐
		 * Deque (예: ArrayDeque)를 사용해서 스택을 구현 추천
		 * Deque<Integer> stack = new ArrayDeque<>();
		 *
		 * stack.push(10);     // 값 넣기
		 * stack.pop();        // 값 꺼내기
		 * stack.peek();       // 맨 위 값 확인
		 */
		visited[startNode] = true;
		stack.push(startNode);
		System.out.println(startNode);

		while (!stack.isEmpty()) {
			int visitNode = stack.pop();
			//visited가 false인 것중에 첫번째
			int num = 0;
			do {
				int next = adjacencyList[visitNode].get(num);
				if(!visited[next]) {
					visited[next] = true;
					stack.push(next);
					System.out.println(next);
					break;
			}
			num++;
			} while(num <adjacencyList[visitNode].size() );
//			int tm = adjacencyList[visitNode].get(0);
//			do{
//				if(!visited[tm]) {
//					stack.push(tm);
//					break;
//				}
//				tm++;
//			}while(tm != adjacencyList[visitNode].getLast());
		}
	}
}

class InputGraph3 {
	int start, end;

	InputGraph3(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class 실습11_1GraphDFSBFS_리스트 {
	static final int N = 8;

	static int[][] makeGraph() {
		return new int[][]{
			{0, 1, 1, 0, 0, 0, 0, 0},
			{1, 0, 0, 1, 1, 0, 0, 0},
			{1, 0, 0, 0, 0, 1, 1, 0},
			{0, 1, 0, 0, 0, 0, 0, 1},
			{0, 1, 0, 0, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 0, 0, 1},
			{0, 0, 1, 0, 0, 0, 0, 1},
			{0, 0, 0, 1, 1, 1, 1, 0}
		};
	}
    static void showMatrix(int[][]m) {
    	System.out.println("adjacency matrix::");
    	for (int[] row : m) {
    		for (int num: row) {
    			System.out.print(num + " ");
    		}
    		System.out.println();
    	}
    }
	public static void main(String[] args) {
		int[][] matrix = makeGraph();
		showMatrix(matrix);
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph(N);

		while (true) {
			System.out.println("\nChoose Command: 1: Add edges, 2: Display Adjacency List, 3: BFS, 4: DFS, 5: Exit => ");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				List<InputGraph3> inputData = new ArrayList<>();
				for (int i = 0; i < matrix.length; i++) {
					for (int j = 0; j < matrix[0].length; j++) {
						//makeGraph메서드의 배열의 돌면서 1인값이 있으면 그래프에 넣는다
						if (matrix[i][j] == 1) {
							//start, end가 i, j인 inputGraph객체를 ArrayList에 넣음
							inputData.add(new InputGraph3(i, j));
						}
					}
				}
				for (InputGraph3 edge : inputData) {
					g.insertEdge(edge.start, edge.end);
				}
				break;

			case 2:
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.print("Enter starting node for BFS: ");
				int startBfsNode = sc.nextInt();
				g.bfs(startBfsNode);
				break;

			case 4:
				System.out.print("Enter starting node for DFS: ");
				int startDfsNode = sc.nextInt();
				g.dfs(startDfsNode);
				break;

			case 5:
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid input. Please re-enter.");
			}
		}
	}
}
