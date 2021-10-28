package 미로탐색;

import java.awt.*;
import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] visit;
	static int[][] map;
	static int[] dirX = {1, -1, 0, 0};
	static int[] dirY = {0, 0, 1, -1};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();

		map = new int[101][101];
		visit = new int[101][101];
		for (int i = 0; i < N; i++) {
			String s = scanner.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.print(map[N - 1][M - 1]);
		scanner.close();
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visit[x][y] = 1;
		while (!queue.isEmpty()) {
			Point currentNumber = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x1 = currentNumber.x + dirX[i];
				int y1 = currentNumber.y + dirY[i];
				if (x1 >= 0 && y1 >= 0 && x1 < N && y1 < M) {
					if (map[x1][y1] == 1 && visit[x1][y1] == 0) {
						queue.offer(new Point(x1, y1));
						visit[x1][y1] = 1;
						map[x1][y1] = map[currentNumber.x][currentNumber.y] + 1;
					}
				}
			}
		}
	}
}
