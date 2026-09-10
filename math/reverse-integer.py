#"Let me make sure I've got this. I'm given a signed 32-bit integer, and I need to return it with the digits reversed. If the reversed value overflows the 32-bit range, I return 0 instead. And the catch is I can't use a 64-bit type to hold an intermediate result, so I have to detect the overflow before it happens."

#"The idea is a pop-and-push loop. On each iteration I pop the last digit off x using mod 10, then push it onto the result with res = res * 10 + digit. I shrink x by integer-dividing it by 10, so the loop runs once per digit and terminates when x hits zero."

#"The tricky part is the overflow check. I can't compute res * 10 + digit and then test it, because by then it's already wrapped around. So I check before multiplying."

#"Integer.MAX_VALUE is 2147483647, so MAX_VALUE / 10 is 214748364. If res is already greater than that, then res * 10 is guaranteed to overflow, and I return 0 immediately. Same logic on the negative side with MIN_VALUE / 10

#grab the last digit by mod 10
#shrin x by dividing by 10
class Solution:
    def reverse(self, x:int) -> int:

        INT_MAX = 2**31 - 1
        res = 0
        is_negative = False 
        if(x < 0):
            is_negative = True
            x *= -1

        while(x > 0):

            digit = x%10

            if(res >  INT_MAX // 10) or ( res ==  INT_MAX // 10 and digit > 7):
                return 0
            res = res*10 + digit
            x = x // 10

        return -res if is_negative else res




