package 나이트의이동;

import java.awt.*;
import java.util.*;

public class Main {

	static int[] dirX = {-2, -2, -1, -1, 1, 2, 2, 1};
	static int[] dirY = {-1, 1, -2, 2, -2, -1, 1, 2};
	static int[][] map;
	static int[][] visit;
	static int count;
	static int mapSize;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			mapSize = scanner.nextInt();
			count = 0;
			map = new int[301][301];
			visit = new int[301][301];

			Point startPosition = new Point(scanner.nextInt(), scanner.nextInt());
			Point targetPosition = new Point(scanner.nextInt(), scanner.nextInt());
			bfs(startPosition, targetPosition);
		}
		scanner.close();
	}

	private static void bfs(Point startPosition, Point targetPosition) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(startPosition);
		visit[startPosition.x][startPosition.y] = 1;
		while (!queue.isEmpty()) {
			Point currentPosition = queue.poll();
			if (currentPosition.equals(targetPosition)) {
				System.out.println(map[currentPosition.x][currentPosition.y]);
				return;
			}
			for (int i = 0; i < 8; i++) {
				int x1 = currentPosition.x + dirX[i];
				int y1 = currentPosition.y + dirY[i];
				if (x1 >= 0 && y1 >= 0 && x1 < mapSize && y1 < mapSize) {
					if (visit[x1][y1] == 0) {
						count = map[currentPosition.x][currentPosition.y] + 1;
						queue.offer(new Point(x1, y1));
						visit[x1][y1] = 1;
						map[x1][y1] = count;
					}
				}
			}
		}
	}
}
