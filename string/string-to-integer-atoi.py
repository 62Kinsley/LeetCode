class Solution:
    def myAtoi(self, s: str) -> int:
        INT_MAX, INT_MIN = 2**31 - 1, -2**31

        #1.Ignore any leading whitespace (
        s = s.lstrip()
        n = len(s)
        if n==0:
            return 0

        res = 0

        #2.Signedness:
        index = 0
        sign = 1
        if s[index] == '+':
            index += 1
        elif s[index] == '-':
            sign = -1
            index += 1

        #3.Conversion:
        
        while index < n:
            c = s[index]
            if not('0' <= c <= '9'):
                break

            if(res > INT_MAX//10) or (res == INT_MAX//10 and int(c) > 7):
                return INT_MAX if sign == 1 else INT_MIN
            
            res = res * 10 + int(c)
            index += 1

        return res*sign
