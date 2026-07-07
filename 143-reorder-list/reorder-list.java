/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast != null) slow = slow.next;
        ListNode h2 = reverse(slow);
        ListNode h1 = head;
        

        while(h2 != null){
            ListNode t1 = h1.next;
            ListNode t2 = h2.next;
            h1.next = h2;
            h2.next = t1;
            h1 = t1;
            h2 = t2;
        
        }
        h1.next = null;


    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tempnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempnext;
        }
        return prev;
    }
}