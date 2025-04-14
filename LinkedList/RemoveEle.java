package LinkedList;
// leetcode 203
public class RemoveEle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) 
            head = head.next;

        ListNode temp = head;

        while(temp != null && temp.next != null){
            ListNode newNode = temp.next;
            if(newNode.val == val)
                temp.next = newNode.next;
            else 
                temp = temp.next;
        }
        return head;
    }
}
