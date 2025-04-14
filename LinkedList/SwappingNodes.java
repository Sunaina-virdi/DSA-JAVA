package LinkedList;
// leetcode 1721
import java.util.*;

public class SwappingNodes {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int length(ListNode head){
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }
        return len;
    }
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return null;
        int len = length(head);

        ListNode first = head;
        
        for(int i = 1; i < k; i++){
            first = first.next;
        }

        ListNode second = head;

        for(int i = 1; i <= len - k; i++){
            second = second.next;
        }

        int data = first.val;
        first.val = second.val;
        second.val = data;

        return head;
    }
}

