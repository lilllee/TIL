package 유기농배추;

import java.util.*;

public class Main {

	static int[][] visit;
	static int[][] board;
	static int N;
	static int M;
	static int[] dirX = {-1, 1, 0, 0};
	static int[] dirY = {0, 0, -1, 1};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			N = scanner.nextInt();
			M = scanner.nextInt();
			int K = scanner.nextInt();
			int count = 0;
			board = new int[51][51];
			visit = new int[2501][2501];

			for (int j = 0; j < K; j++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				board[x][y] = 1;
			}

			for (int x1 = 0; x1 < N; x1++) {
				for (int y1 = 0; y1 < M; y1++) {
					if (board[x1][y1] == 1 && visit[x1][y1] == 0) {
						dfs(x1, y1);
						count++;
					}
				}
			}
			queue.offer(count);
		}
		for (Integer integer : queue) {
			System.out.println(integer);
		}
		scanner.close();
	}

	private static void dfs(int x, int y) {
		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int x1 = x + dirX[i];
			int y1 = y + dirY[i];

			if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < M) {
				if (board[x1][y1] == 1 && visit[x1][y1] == 0) {
					dfs(x1, y1);
				}
			}
		}
	}
}
