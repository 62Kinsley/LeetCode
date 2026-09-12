class Solution:
    def letterCombinations(self, digits: str) -> List[str]:

        if not digits:
            return []
        
        res = []
        path = []
        letters = ["","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        
        def backtracking( digInx: int) -> None:
            
            if( digInx == len(digits)):
                res.append("".join(path))
                return 

            num = int(digits[digInx])#3
            letter = letters[num] #def
            n = len(letter)#3

            for i in range(n): #0

                path.append(letter[i])
                backtracking(digInx+1)
                path.pop()
        
        backtracking(0)
        return res


        
        