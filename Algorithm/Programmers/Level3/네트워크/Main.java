public class Main {

	static int[] visit;

	public static int solution(int n, int[][] computers) {
		int answer = 0;

		visit = new int[computers.length];
		for (int i = 0; i < computers.length; i++) {
			if (visit[i] == 0) {
				answer++;
				dfs(i, computers);
			}
		}
		return answer;
	}

	private static void dfs(int idx, int[][] computers) {
		visit[idx] = 1;

		for (int i = 0; i < computers.length; i++) {
			if (computers[idx][i] == 1 && visit[i] == 0) {
				dfs(i, computers);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
}
