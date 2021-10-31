package Programmers.Level1.모의고사;

import java.util.*;

public class Main {

	public static int[] solution(int[] answers) {
		int[] answer = {};
		List<Integer> list = new ArrayList<>();
		int[] p1 = {1, 2, 3, 4, 5};
		int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int i1, i2, i3;
		int count1 = 0, count2 = 0, count3 = 0;
		for (int i = 0; i < answers.length; i++) {
			i1 = i % 5;
			i2 = i % 8;
			i3 = i % 10;

			if (answers[i] == p1[i1]) count1++;
			if (answers[i] == p2[i2]) count2++;
			if (answers[i] == p3[i3]) count3++;
		}
		if (count1 >= count2 && count1 >= count3) {
			list.add(1);
		}

		if (count2 >= count1 && count2 >= count3) {
			list.add(2);
		}

		if (count3 >= count1 && count3 >= count2) {
			list.add(3);
		}
		answer = new int[list.size()];
		for (int i=0; i < list.size(); i++){
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
	}
}

