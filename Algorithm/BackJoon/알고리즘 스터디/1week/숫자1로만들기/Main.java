package 숫자1로만들기;

import java.util.*;

public class Main {

	static int[] visit;
	static Queue<Integer> queue = new LinkedList<>();
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		visit = new int[1000001];
		visit[1] = 0;
		for (int i = 2; i <= N; i++) {
			visit[i] = visit[i - 1] + 1;
			if (i % 2 == 0) {
				visit[i] = Math.min(visit[i], visit[i / 2] + 1);
			}
			if (i % 3 == 0) {
				visit[i] = Math.min(visit[i], visit[i / 3] + 1);
			}
		}
		System.out.println(visit[N]);
		scanner.close();
	}
}
