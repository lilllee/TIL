package stack;

import LinkedList.ListNode;

public class Stack implements StackInter {

    ListNode stackNode;
    int top;
    int stackSize;
    int popData;

    public Stack() {
        this.stackNode = null;
        this.top = -1;
        this.stackSize = 0;
        this.popData = 0;
    }

    @Override
    public void push(int data) {
        ListNode pushNode = new ListNode(data);
        if (stackNode == null){
            stackNode = new ListNode(data);
            top++;
            stackSize++;
        }else {
            stackSize++;
            stackNode = stackNode.add(stackNode,pushNode,++top);
        }
    }
    @Override
    public int pop() {
        if (top == -1){
            return top;
        }
//        else if (top == 0){
//            return stackNode.remove(stackNode,0).data;
//        }
        else{
            stackSize--;
            popData = stackNode.remove(stackNode,top--).data;
            return popData;
        }
    }
}
