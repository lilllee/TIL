package 마인크래프트;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int B = scanner.nextInt();
		int[][] map = new int[N][M];
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		int minTime = Integer.MAX_VALUE;
		int saveHeight = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scanner.nextInt();
				minHeight = Math.min(minHeight, map[i][j]);
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		for (int n = minHeight; n <= maxHeight; n++) {
			int time = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] > n) {
						time += 2 * (map[i][j] - n);
						B += map[i][j] - n;
					} else if (map[i][j] < n) {
						time += (n - map[i][j]);
						B -= (n - map[i][j]);
						if (B < 0) {
							break;
						}
					}
				}
			}
			if (time <= minTime) {
				minTime = time;
				saveHeight = Math.max(saveHeight, n);
			}
		}
		System.out.print(minTime + " " + saveHeight);
		scanner.close();
	}
}
