class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] res = new int[n];
        stack.push(heights[n-1]);

        for(int i=n-2; i>=0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && heights[i] > stack.peek()){
                    res[i]++;
                    stack.pop();
                }

                if(!stack.isEmpty() && heights[i] < stack.peek()){
                    res[i]++;
                }   
                
            }
            stack.push(heights[i]);
            
        }
        return res;
    }
}