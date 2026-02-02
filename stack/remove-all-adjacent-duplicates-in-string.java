// class Solution {
//     public String removeDuplicates(String s) {
//         Stack<Character> stack = new Stack<>();
//         StringBuilder sb=new StringBuilder(); 
       
//         for(char c : s.toCharArray()){
//             if(!stack.isEmpty()){
//                 if(c == stack.peek()){
//                     stack.pop();
//                     continue;
//                 }
//             }
//             stack.push(c);
//         }

//         while(!stack.isEmpty()){
//             sb.append(stack.pop());
//         }

//         return sb.reverse().toString();
//     }
// }

class Solution {
    public String removeDuplicates(String s) {
        
        StringBuilder sb = new StringBuilder(); 
       
        for(char c : s.toCharArray()){
            int len = sb.length();
            if(len > 0 && c == sb.charAt(len - 1)){
                sb.deleteCharAt(len - 1);
                
            }else{
                sb.append(c);
            }
            //
        }

        return sb.toString();
    }
}

