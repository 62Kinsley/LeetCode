class Solution:
    def isPalindrome(self, x: int) -> boolean:
        if(x < 0):
            return False
        
        cur = x
        res = 0
        while cur > 0:
            last_digit = cur % 10
            res = res * 10 + last_digit
            cur = cur // 10
        
        return res == x
