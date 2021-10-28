package 숨박꼭질;

import java.util.*;

public class Main {

	static int[] visit;
	static Queue<Integer> queue = new LinkedList<>();
	static int N, K;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		visit = new int[100001];
		bfs();
		System.out.println(visit[K] - 1);
		scanner.close();
	}

	private static void bfs() {
		queue.offer(N);
		visit[N] = 1;
		int time = 0;
		while (!queue.isEmpty()) {
			int currentNumber = queue.poll();
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					time = currentNumber + 1;
				} else if (i == 1) {
					time = currentNumber - 1;
				} else {
					time = currentNumber * 2;
				}
				if (time >= 0 && time <= 100000 && visit[time] == 0) {
					queue.offer(time);
					visit[time] = visit[currentNumber] + 1;
				}
			}
		}
	}
}
