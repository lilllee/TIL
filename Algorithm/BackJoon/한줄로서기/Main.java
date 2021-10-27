package 한줄로서기;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int n = sn.nextInt();
		int[] answer = new int[n];
		for (int i = 0; i < n; i++) {
			int number = sn.nextInt();
			for (int j = 0; j < n; j++) {
				if (number == 0 && answer[j] == 0) {
					answer[j] = i + 1;
					break;
				} else if (answer[j] == 0) {
					number--;
				}
			}
		}
		for (int i : answer) {
			System.out.print(i + " ");
		}
		sn.close();
	}
}
