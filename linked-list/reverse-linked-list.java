//https://www.bilibili.com/video/BV1nB4y1i7eL/?vd_source=a2654b36458e7be6306c477da93c355e
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
// class Solution {
//     public ListNode reverseList(ListNode head) {
//     //注意！！这里的type是 ListNode！！！！
//        //initial two pointer 
//         ListNode prev = null;
//         ListNode cur = head;

//         while(cur != null){
//             //先用一个temp将cur.next记下，因为后面cur.next的指针反转以后，就不会指向这个temp了
//             //所以先记下来，后续双指针 prev, cur移动的时候会用到
//             ListNode temp = cur.next;
//             cur.next = prev;//反转了
//             //两个指针要往后移，但这时候一定要记住是prev先移动！！
//             prev = cur;//一定不能是cur先移动，因为cur移动了就不是当前的值了
//             cur = temp;
//         }
//         return prev;//最后返回的是head，也就是prev，因为这时的cur是null
           
//     }
// }

class Solution{
    public ListNode reverseList(ListNode head){
     
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;

        while(cur != null){
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }
}