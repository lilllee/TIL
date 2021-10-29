package LinkedList;

public interface listnodeInter {

    ListNode add(ListNode head, ListNode nodeToAdd, int position);
    ListNode remove(ListNode head, int positionToRemove);
    boolean contains(ListNode head, ListNode nodeTocheck);
    boolean listnull(ListNode head);
    int listsize(ListNode head);

}
