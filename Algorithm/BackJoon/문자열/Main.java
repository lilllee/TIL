package 문자열;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String A = scanner.next();
		String B = scanner.next();
		scanner.close();
		System.out.print(solution(A, B));
	}

	private static int solution(String a, String b) {
		int answer = 0;
		int aStringSize = a.length();
		int bStringSize = b.length();
		int totalSize = bStringSize - aStringSize;
		int wordCount;
		int maximumCount = 50;

		for (int i = 0; i <= totalSize; i++) {
			wordCount = 0;
			for (int j = 0; j < aStringSize; j++) {
				if (a.charAt(j) != b.charAt(i + j)) {
					wordCount++;
				}
			}
			maximumCount = Integer.min(maximumCount, wordCount);
		}
		answer = maximumCount;
		return answer;
	}
}
