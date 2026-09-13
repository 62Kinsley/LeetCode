# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class HeapNode:
#     def __init__(self, node: ListNode):
#         self.node = node
    
#     def __lt__(self, other_node: HeapNode):
#         return self.node.val < other_node.node.val


# class Solution:
    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     root = ListNode()
    #     cur_root = root

    #     heap = []

    #     for head in lists:
    #         if head:
    #             heapq.heappush(heap, HeapNode(head))
        
    #     while heap:
    #         top_node = heapq.heappop(heap).node
    #         cur_root.next = top_node
    #         if top_node.next:
    #             heapq.heappush(heap, HeapNode(top_node.next))
    #         cur_root = cur_root.next
        
    #     return root.next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        n = len(lists)
        return self.divide(lists, 0, n-1)

    
    def divide(self, lists: List[Optional[ListNode]], l:int, r:int) -> Optional[ListNode]:
        
        if l == r:
            return lists[l]

        mid = l + (r-l) // 2
        left = self.divide(lists, l, mid)
        right = self.divide(lists, mid+1, r)

        return self.merge(left, right)

    def merge(self, l1:Optional[ListNode], l2:Optional[ListNode]) -> Optional[ListNode]:

        dummy = ListNode()
        cur = dummy

        while l1 and l2:
            if l1.val < l2.val:
                cur.next = l1
                l1 = l1.next
                cur = cur.next
            else:
                cur.next = l2
                l2 = l2.next
                cur = cur.next
        
        if l1:
            cur.next = l1
        if l2:
            cur.next = l2

        return dummy.next   