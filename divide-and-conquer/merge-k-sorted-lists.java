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

 /*
        堆优化的多指针法
        时间复杂度:O(NlogK) 空间复杂度:O(K)
        其中K为list的长度
 */
 //heap
//  class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {


//         PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

//         for(ListNode node :  lists){
//             if(node != null){
//                 minHeap.add(node);//[[1,3,4],[2,6],[4,5]]
//             }
            
//         }

//         ListNode dummy = new ListNode(0),  cur = dummy;

//         while(!minHeap.isEmpty()){
//             ListNode node = minHeap.poll();//1
//             cur.next = node;//dummy -> 1
//             cur = cur.next;

//             if(node.next != null){
//                 node = node.next;
//                 minHeap.add(node);
//             }
           
//         }

//         return dummy.next;
//     }
// }

// class Solution{
//    public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) return null;
//         Queue<ListNode> queue = new LinkedList<>();
//         for (ListNode list : lists){
//             queue.offer(list);
//         }

//         while(queue.size() >= 2){
//             ListNode l1 = queue.poll();
//             ListNode l2 = queue.poll();

//             if(l1 != null || l2 != null){
//                 queue.offer(mergeTwoLists(l1, l2)) ;
//             }
//         }
//         return queue.poll();
           
//     }

//     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0);
//         ListNode cur = dummy;

//         while (l1 != null && l2 != null) {
//             if(l1.val < l2.val){
//                 cur.next = l1;
//                 l1 = l1.next;
//             }else{
//                 cur.next = l2;
//                 l2 = l2.next;
//             }
//             cur = cur.next;
//         }
//         if(l1 != null) cur.next = l1;
//         if(l2 != null) cur.next = l2;

//         return dummy.next;
//     }
// }


// class Solution{
//    public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) return null;
//         return  divide(lists, 0, lists.length - 1);
//     }

//     private ListNode divide(ListNode[] lists, int left, int right) {
//         if (left == right) return lists[left];  // [[1,4,5],    [1,3,4],        [2,6]]
//         int mid = left + (right - left) / 2;
//         ListNode l1 =  divide(lists, left, mid);
//         ListNode l2 =  divide(lists, mid + 1, right);
//         return mergeTwoLists(l1, l2);
//     }

//     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0);
//         ListNode cur = dummy;

//         while (l1 != null && l2 != null) {
//             if(l1.val < l2.val){
//                 cur.next = l1;
//                 l1 = l1.next;
//             }else{
//                 cur.next = l2;
//                 l2 = l2.next;
//             }
//             cur = cur.next;
//         }
//         if(l1 != null) cur.next = l1;
//         if(l2 != null) cur.next = l2;

//         return dummy.next;
//     }
// }


class Solution{
    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode node : lists){
            if(node != null){
                minHeap.offer(node); //[1,4,5],[1,3,4],[2,6]]
            }
            
        }

        ListNode dummy = new ListNode();
        ListNode  cur = dummy;
        while(!minHeap.isEmpty()){
            ListNode node  = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            
            if (node.next!= null) {
                minHeap.add(node.next);
            }   
            
        }

        return dummy.next;

    }
}
