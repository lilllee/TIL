package BackJoon.달팽이;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        System.out.println();
        int[][] board = new int[N][N];

        StringBuilder sb = new StringBuilder();

        int[] xyPosition = {0, 0};
        int currentValue = N * N;
        int currentX = 0;
        int currentY = N - 1;
        int total = N / 2;
        for (int i = 0; i < total; i++) {
            for (int j = currentX; j <= currentY; j++) {
                board[j][currentX] = currentValue;
                currentValue--;
            }
            currentX++;
            for (int l = currentX; l <= currentY; l++) {
                board[currentY][l] = currentValue;
                currentValue--;
            }
            for (int k = currentY - 1; k >= currentX - 1; k--) {
                board[k][currentY] = currentValue;
                currentValue--;
            }
            currentY--;
            for (int n = currentY; n >= currentX; n--) {
                board[currentX - 1][n] = currentValue;
                currentValue--;
            }
        }
        board[total][total] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == M) {
                    xyPosition[0] = i + 1;
                    xyPosition[1] = j + 1;
                }
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(xyPosition[0] + " " + xyPosition[1]);
        System.out.println(sb);
        br.close();
    }
}
