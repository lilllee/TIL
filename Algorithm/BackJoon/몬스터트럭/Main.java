package BackJoon.몬스터트럭;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int R, C;
		char[][] board;
		R = scanner.nextInt();
		C = scanner.nextInt();
		board = new char[R][C];
		int[] arr = new int[5];

		scanner.nextLine();
		for (int i = 0; i < R; i++) {
			String inputData = scanner.nextLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = inputData.charAt(j);
			}
		}
		for (int i = 0; i < R - 1; i++) {
			for (int j = 0; j < C - 1; j++) {
				int destroyCarCount = 0;
				if (board[i][j] == '#' || board[i + 1][j] == '#' || board[i][j + 1] == '#' || board[i + 1][j + 1] == '#') {
					continue;
				}
				if (board[i][j] == 'X') {
					destroyCarCount++;	
				}
				if (board[i + 1][j] == 'X') {
					destroyCarCount++;
				}
				if (board[i][j + 1] == 'X') {
					destroyCarCount++;
				}
				if (board[i + 1][j + 1] == 'X') {
					destroyCarCount++;
				}
				arr[destroyCarCount]++;
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}
		scanner.close();
	}
}
