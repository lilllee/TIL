package BackJoon.제로;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        int input = 0;
        int answer = 0;
        for (int i =0; i < a; i++){
            input = scanner.nextInt();
            if (input == 0){
                stack.pop();
            }
            else {
                stack.push(input);
            }
        }
        for (Integer integer : stack) {
            answer += integer;
        }
        System.out.println( answer);
        scanner.close();
    }
}
