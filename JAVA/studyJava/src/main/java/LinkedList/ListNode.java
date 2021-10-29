package LinkedList;

import java.util.List;

public class ListNode implements listnodeInter {


    public ListNode next;
    public int size;
    public int data;

    public ListNode() {
    }

    public ListNode(int data) {
        this.next = null;
        this.data = data;
        this.size = 0;
    }

    @Override
    public int listsize(ListNode head) {

        if (head.next == null) {
            return (0);
        } else {
            while (head != null) {
                head = head.next;
                size++;
            }
        }
        return (size);
    }

    @Override
    public boolean listnull(ListNode head) {
        if (head.next == null)
            return (false);
        return (true);
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (position == listsize(head)) {
            return null;
        } else if (head == null) {
            return nodeToAdd;
        } else if (position == 0) {
            nodeToAdd.next = head;
            size++;
            return nodeToAdd;
        }
        for (int i = 0; i < position - 1; i++) {
            head = head.next;
        }
        ListNode prevNode = head;
        nodeToAdd.next = prevNode.next;
        prevNode.next = nodeToAdd;
        return this;
    }

    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        if (head == null) {
            return null;
        } else if (positionToRemove == 0) {
            size--;
            return head;
        }
        for (int i = 0; i < positionToRemove - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        size--;
        return head;
    }


    @Override
    public boolean contains(ListNode head, ListNode nodeTocheck) {
        if (head.next == null && head.data == 0) {
            return false;
        } else {
            while (head != null) {
                if (head.data == nodeTocheck.data) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

}
