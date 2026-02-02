class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb=new StringBuilder(); 
       
        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                if(c == stack.peek()){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

