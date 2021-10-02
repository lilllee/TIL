import java.util.Scanner;

public class Stack {

    private static int[] stack;
    private static int stackSize = 0;


    private static void push(int inputData) {
        stack[stackSize] = inputData;
        stackSize++;
    }

    private static int pop() {
        int popData = 0;
        if (stackSize == 0) {
            popData = -1;
        } else {
            popData = stack[stackSize - 1];
            stack[stackSize - 1] = 0;
            stackSize--;
        }
        return popData;
    }

    private static int getStackSize() {
        return stackSize;
    }

    private static int getStackTop() {
        int topData = 0;
        if (stackSize == 0) {
            topData = -1;
        } else {
            topData = stack[stackSize - 1];
        }
        return topData;
    }

    private static int empty() {
        return stackSize == 0 ? 1 : 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stackSize = scanner.nextInt();
        stack = new int[stackSize];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < stackSize; i++) {
            String command = scanner.next();
            if (command.equals("push")) {
                int inputData = scanner.nextInt();
                push(inputData);
            } else if (command.equals("pop")) {
                answer.append(pop()).append('\n');
            } else if (command.equals("size")) {
                answer.append(getStackSize()).append('\n');
            } else if (command.equals("empty")) {
                answer.append(empty()).append('\n');
            } else if (command.equals("top")) {
                answer.append(getStackTop()).append('\n');
            }
        }
        scanner.close();
        System.out.println(answer);
    }
}
