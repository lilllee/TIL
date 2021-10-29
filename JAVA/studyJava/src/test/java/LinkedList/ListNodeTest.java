package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    private ListNode listNode;

    @BeforeEach
    void 리스트생성() {
        listNode = new ListNode();
        ListNode fNode = new ListNode(1);
        ListNode sNode = new ListNode(2);
        ListNode tNode = new ListNode(4);
        ListNode foNode = new ListNode(5);
        ListNode fiNode = new ListNode(6);

        listNode = fNode;
        fNode.next = sNode;
        sNode.next = tNode;
        tNode.next = foNode;
        foNode.next = fiNode;

    }

    @Test
    @DisplayName("노드 추가 테스트")
    void add() {
        listNode = listNode.add(listNode, new ListNode(3), 2);

        for (int i = 0; i < 6; i++) {
            Assertions.assertEquals(i + 1, listNode.data);
            listNode = listNode.next;
        }
    }

    @Test
    @DisplayName("특정 위치 지우기")
    void remove() {
        listNode.remove(listNode, 1);
        listNode = listNode.next;
        assertEquals(listNode.data, 4);
    }


    @Test
    @DisplayName("노드가지고 있는지 테스트")
    void contains() {
        assertAll("가지고 있음?",
                () -> {
                    assertTrue(listNode.contains(listNode, new ListNode(4)));
                },
                () -> {
                    assertFalse(listNode.contains(listNode, new ListNode(3)));
                });
    }
    
    @Test
    @DisplayName("노드 사이즈")
    void nodeSize(){
        listNode = listNode.add(listNode, new ListNode(3), 2);
        int size = listNode.size;
        Assertions.assertEquals(5,size);
    }
}