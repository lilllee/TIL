package 설탕배달;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		if (n % 5 == 0) {
			System.out.println(n / 5);
		} else {
			int a = n / 5;
			while (true) {
				int s = n - (a * 5);
				if (s % 3 == 0) {
					System.out.println(a + s / 3);
					break;
				}
				a--;
				if (a < 0) {
					System.out.println(-1);
					break;
				}
			}
		}
		scanner.close();
	}
}
