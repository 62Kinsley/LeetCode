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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.next == null){
            return new TreeNode(head.val);
        } 

        ListNode slow = head, fast = head, prev = null;
       
        //[-10,-3,0,5,9]
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;//断开指针

        TreeNode node = new TreeNode(slow.val);

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);

        return node;
          
       
    }
    // public TreeNode  dfs(ListNode head){
        

    // }
}