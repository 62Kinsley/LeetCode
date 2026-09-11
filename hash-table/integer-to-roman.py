class Solution:
    def intToRoman(self, num:int) -> str:
        pairs = [
            (1000, "M"),
            (900, "CM"), 
            (500, "D"), 
            (400, "CD"),
            (100, "C"), 
            (90, "XC"), 
            (50, "L"), 
            (40, "XL"),
            (10, "X"), 
            (9, "IX"), 
            (5, "V"), 
            (4, "IV"), 
            (1, "I")
        ]
        res = []
        for value, sym in pairs:
            count, mod = divmod(num, value)#  1, 249 = 749,500
            res.append(count * sym) #mmm
            num = mod
        return "".join(res)
