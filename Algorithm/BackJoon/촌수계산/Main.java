package 촌수계산;

import java.util.*;

public class Main {

	static int x1;
	static int y1;
	static int[][] array;
	static int[] visit;
	static int count;
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();

		x1 = scanner.nextInt();
		y1 = scanner.nextInt();
		int T = scanner.nextInt();
		array = new int[101][101];
		visit = new int[101];
		for (int i = 0; i < T; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			array[x][y] = 1;
			array[y][x] = 1;
		}
		dfs(x1, 0);
		if (count == 0) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
		scanner.close();
	}

	private static void dfs(int v, int cnt) {
		visit[v] = 1;
		if (v == y1) {
			count = cnt;
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (visit[i] == 0 && array[v][i] == 1) {
				dfs(i, cnt + 1);
			}
		}
	}
}
