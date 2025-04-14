package LinkedList;
// leetcode 1669
public class mergeBtwLL {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = null,after = null;
        ListNode temp = list1;

        int count = 0;

        while(temp != null){
            if(count == a-1) prev = temp;
            if(count == b){ 
                after = temp; 
                break;
            }
            temp = temp.next;
            count++;       
        }

        prev.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = after.next;

        return list1;
    }
}
