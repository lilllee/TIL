package stack;

import LinkedList.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void set(){
        stack = new Stack();
    }
    @Test
    @DisplayName("push Test")
    void push() {
        stack.push(1);
        stack.push(2);
        stack.push(3);


        ListNode node = stack.stackNode;
        int i=0;
        while(node != null) {
            Assertions.assertEquals(i++,node.data);
            System.out.println(node.data);
        }

    }

    @Test
    @DisplayName("pop Test")
    void pop() {
        stack.push(10);
        stack.push(11);
        Assertions.assertEquals(11, stack.pop());
        Assertions.assertEquals(10, stack.pop());

    }

    @Test
    @DisplayName("stack Size")
    void size(){
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        System.out.println(stack.stackSize);
    }
}