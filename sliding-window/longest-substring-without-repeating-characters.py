class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        r = 0
        char_set  = set()
        res = 0

        for r in range(len(s)):
            c = s[r]

            while c in char_set:
                char_set.remove(s[l])
                l += 1

            char_set.add(c)
            res = max(res, r - l +1)
        return res

        