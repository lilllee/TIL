package 에라토스테네스의체;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int count = 0;

		boolean[] isPrime = new boolean[a + 1];
		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i <= a; i++) {
			for (int j = i; j <= a; j = j + i){
				if (!isPrime[j]){
					count++;
					isPrime[j] = true;
				}
				if (count == b){
					System.out.println(j);
					return;
				}
			}
		}
		scanner.close();
	}
}
