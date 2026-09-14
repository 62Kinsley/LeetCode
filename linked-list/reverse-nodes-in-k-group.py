# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head:Optional[ListNode], k: int) -> OptionalListNode:

        dummy = ListNode(0, head)
        fast = dummy
        slow = dummy

        while slow.next:
            for _ in range(k):
                fast = fast.next
                if not fast:
                    break
            if not fast:
                break
            
            cur_start = slow.next
            next_start = fast.next
            fast.next = None  
            slow.next = self.reverse(cur_start)
            cur_start.next = next_start
            
            slow = cur_start
            fast = cur_start

        return dummy.next



    def reverse(self, head:Optional[ListNode]) -> OptionalListNode :

        prev, cur = None, head

        while cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt

        return prev

            
