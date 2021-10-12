package BackJoon.저항;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> colorMap = new HashMap<>();
		colorMapSetting(colorMap);
		long answer = 1;

		for (int i = 0; i < 3; i++) {
			String color = scanner.next();
			answer = solution(answer, color, colorMap, i);
		}
		System.out.println(answer);
		scanner.close();
	}

	public static void colorMapSetting(HashMap<String, Integer> colorMap) {
		colorMap.put("black", 0);
		colorMap.put("brown", 1);
		colorMap.put("red", 2);
		colorMap.put("orange", 3);
		colorMap.put("yellow", 4);
		colorMap.put("green", 5);
		colorMap.put("blue", 6);
		colorMap.put("violet", 7);
		colorMap.put("grey", 8);
		colorMap.put("white", 9);
	}
	
	private static long solution(long answer, String color, HashMap<String, Integer> colorMap, int i) {
		int colorNumber = colorMap.get(color);

		if (i == 0) {
			answer = colorNumber;
		} else if (i == 1) {
			answer = (answer * 10) + colorNumber;
		} else {
			answer = (long) (answer * (Math.pow(10, colorNumber)));
		}
		return answer;
	}
}
