class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        l = 0
        r = len(height) - 1

        while(l < r):
            width = r - l
            h = min(height[l], height[r])
            area = width * h
            res = max(res, area)

            if(height[l] > height[r]):
                r -= 1
            else:
                l += 1

        return res