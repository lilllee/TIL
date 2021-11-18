package 일곱난쟁이;

import java.util.*;

public class Main {

	static List<Integer> list;
	static int sum;
	static int[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = scanner.nextInt();
			sum += arr[i];
		}
		int[] sortedArray = Arrays.stream(arr)
				.sorted()
				.toArray();

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - sortedArray[i] - sortedArray[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (i == k || j == k) {
							continue;
						}
						System.out.println(sortedArray[k]);
					}
					return;
				}
			}
		}
		scanner.close();
	}
}
