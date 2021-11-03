import java.util.*;

public class Main {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;
		int height = 3;
		while (true) {
			int width = sum / height;
			int yellowSize = (height - 2) * (width - 2);
			if (yellowSize == yellow) {
				answer[0] = width;
				answer[1] = height;
				break;
			}
			height++;
		}
		return answer;
	}
}
