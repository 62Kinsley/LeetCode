# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class Solution:
#     def swapPairs(self, head: OptionalListNode) -> OptionalListNode:
#         dummy = ListNode()
#         dummy.next = head
#         prev = dummy

#         while prev.next and prev.next.next:
        
#            first = prev.next
#            second = prev.next.next

#            first.next = second.next
#            second.next = first
#            prev.next = second
           
#            prev = first

#         return dummy.next


class Solution:
    def swapPairs(self, head: OptionalListNode) -> OptionalListNode:

        if not head or not head.next:
            return head
        
        node1 = head
        node2 = head.next
        node3 = head.next.next

        node2.next = node1
        node1.next = self.swapPairs(node3)
        
        return node2