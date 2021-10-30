import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int answer;
	static Queue<Point> queue = new LinkedList<>();

	public static int solution(int[] numbers, int target) {
		//dfs(numbers, target, 0, 0);
		bfs(numbers, target);
		return answer;
	}

	//BFS 풀이
	private static void bfs(int[] numbers, int target) {
		queue.offer(new Point(0,0));
		while (!queue.isEmpty()) {
			Point idxAndNum = queue.poll();
			int idx = idxAndNum.x;
			int num = idxAndNum.y;
			if (idx >= numbers.length) {
				if (num == target) {
					answer++;
				}
			} else {
				queue.offer(new Point(idx + 1,num + numbers[idx]));
				queue.offer(new Point(idx + 1,num - numbers[idx]));
			}
		}
	}
	
	//DFS 풀이
	private static void dfs(int[] numbers, int target, int num, int idx) {
		if (idx >= numbers.length) {
			if (num == target) {
				answer++;
			}
		} else {
			int add = num + numbers[idx];
			int sub = num - numbers[idx];
			dfs(numbers, target, add, idx + 1);
			dfs(numbers, target, sub, idx + 1);
		}
	}

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}
