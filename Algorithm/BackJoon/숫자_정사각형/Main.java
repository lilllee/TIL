package BackJoon.숫자_정사각형;

import java.util.*;

public class Main1051 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String inputNumbers = scanner.next();
            for (int j = 0; j < M; j++) {
                array[i][j] = inputNumbers.charAt(j) - '0';
            }
        }
        scanner.close();
        System.out.print(solution(N, M, array));
    }

    public static int solution(int N, int M, int[][] array) {
        Integer answer = 1;

        int maximumSize = Integer.min(N, M) - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 1; k <= maximumSize; k++) {
                    if (i + k < N && j + k < M &&
                            array[i + k][j] == array[i][j] &&
                            array[i + k][j + k] == array[i][j] &&
                            array[i][j + k] == array[i][j]) {
                        answer = Integer.max(answer, k + 1);
                    }
                }
            }
        }
        return answer * answer;
    }
}

