class Solution:
    def findMedianSortedArrays(self, nums1 : List[int], nums2 : List[int]) -> float:
        len1 = len(nums1)
        len2 = len(nums2)

        if(len1 + len2) % 2 == 0:
            mid = (len1 + len2) // 2
            k1 = self.getKth(nums1, nums2, 0, 0,  mid)
            k2 = self.getKth(nums1, nums2, 0, 0,  mid+1)
            return (k1+k2) / 2
        else:
            mid = (len1 + len2 + 1) // 2
            k = self.getKth(nums1, nums2, 0, 0,  mid)
            return k

    def getKth(self,nums1 : List[int], nums2 : List[int], l1:int, l2: int, k: int ) -> int:
        if(l1 >= len(nums1)):
            return nums2[l2 + k - 1]
        if(l2 >= len(nums2)):
            return nums1[l1 + k - 1]

        if(k == 1):
            return min(nums1[l1], nums2[l2])

        mid = k//2
        step1 = min(mid, len(nums1) - l1)
        step2 = min(mid, len(nums2) - l2)

        cur1 = l1+step1-1
        cur2 = l2+step1-1

        if(nums1[cur1] < nums2[cur2]):
            l1 = l1+step1
            ans = self.getKth(nums1, nums2, l1, l2, k-step1)
            return ans
        else:
            l2 = l2+step2
            ans = self.getKth(nums1, nums2, l1, l2, k-step2)
            return ans

        


        



        