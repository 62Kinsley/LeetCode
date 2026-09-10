class Solution:
    def longestPalindrome(self, s:str) -> str:
        res = ""
        maxLength = 0
        for i in range(len(s)):
            s1 = self.isPalindrome(s, i, i)
            s2 = self.isPalindrome(s, i, i+1)

            if(len(s1) > len(res)):
                res = s1
            if(len(s2) > len(res)):
                res = s2
        return res

    def isPalindrome(self, s:str, l:int, r:int) -> s:
        
        while(l >=0 and r<len(s)):
            if(s[l] == s[r]):
                l -= 1
                r += 1
            else:
                break
        return s[l+1: r]