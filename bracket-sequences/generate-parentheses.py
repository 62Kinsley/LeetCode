class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        path = []

        def backtracking(n: int, openbracket_count: int, closingbracket_count:int) -> None:

            if len(path) == 2*n:
                res.append("".join(path))
                return 
                
            
            if openbracket_count < n :
                path.append('(')
                backtracking(n, openbracket_count+1, closingbracket_count)
                path.pop()


            if closingbracket_count < openbracket_count :
                path.append(')')
                backtracking(n, openbracket_count, closingbracket_count+1)
                path.pop()

        backtracking(n, 0, 0)
        return res







#1. 定性 ：This is a classic backtracking problem. Rather than generating all 2^(2n) combinations and filtering out the invalid ones, I'll build the string incrementally and prune invalid branches as soon as they appear."

#2. 状态"I'll track two counters: the number of opening brackets I've placed so far, and the number of closing brackets I've placed so far."

#3. 两条规则 — 最关键的部分"At each step I have two choices. First, I can add an opening bracket as long as I haven't used all n of them. Second, I can add a closing bracket only if the number of closing brackets placed so far is strictly less than the number of opening brackets placed so far."

#4. 解释第二条为什么正确"Since every closing bracket in a valid prefix has already matched an earlier opening one, the difference between the two counts is exactly the number of unmatched opening brackets — the running balance. So close < open is just another way of saying the balance is still positive, meaning there's an opening bracket left to close."

#5. base case"The base case is when the path reaches length 2n. Anything that gets there is guaranteed to be valid, so I can add it to the result directly without a validity check."