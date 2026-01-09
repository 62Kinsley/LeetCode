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

    //1.find the middle node (odd even)
    // 2.create new linked list which would be reversed of the original linked list.
    //3.  just need the second half of linked list to be reversed.
    //4. After getting middle node, reverse the list after that node.

    //1->2->2->1         //1->2->3->2->1

    //1->2  2<-1        //1->2->3 <-2<-1
    public boolean isPalindrome(ListNode head) {

        ListNode middle = middleNode(head);//2 3
        ListNode head2 = reverse(middle);

        while(head2 != null){
             if(head2.val != head.val){
                return false;
            }
            head2 = head2.next;
            head = head.next;
        }
        return true;
    }

    public ListNode middleNode(ListNode head){//two pointer, fast, slow
        ListNode fast = head;
        ListNode slow = head;
             
         //1->2->3->2->1
                
        while(fast != null && fast.next != null){
            slow = slow.next;// speed of 1
            fast = fast.next.next;// speed of 2
        }
        return slow;

    }

    //reverse the linkedlist
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
            
        //<-3 <-2<-1
        while(cur != null){
              ListNode next = cur.next;//null
              cur.next = prev;
              prev = cur;
              cur = next;
        }
        return prev;

    }
}

