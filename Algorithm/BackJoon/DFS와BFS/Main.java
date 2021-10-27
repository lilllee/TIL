package DFS와BFS;

import java.util.*;

public class Main {

	static int[] visit;
	static int[][] graph;
	static int N;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args){
		Scanner sca = new Scanner(System.in);
		N = sca.nextInt();
		int M = sca.nextInt();
		int V = sca.nextInt();
		graph = new int[1001][1001];
		visit = new int[1001];
		for (int i = 0; i < M; i++) {
			int x = sca.nextInt();
			int y = sca.nextInt();
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		visit[V] = 1;
		dfs(V);
		Arrays.fill(visit,0);
		System.out.println();
		bfs(V);
		sca.close();
	}

	private static void bfs(int v) {
		visit[v] = 1;
		queue.offer(v);
		while (!queue.isEmpty()) {
			int front = queue.peek();
			queue.poll();
			System.out.print(front + " ");
			for (int i = 1; i <= N; i++) {
				if (graph[front][i] == 1 && visit[i] == 0) {
					visit[i] = 1;
					queue.offer(i);
				}
			}
		}
	}

	private static void dfs(int v) {
		visit[v] = 1;
		System.out.print(v + " ");
		for (int i = 1; i <= N; i++) {
			if (graph[v][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}
	}
}
