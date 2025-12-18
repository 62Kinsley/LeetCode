class Solution {
    public int arraySign(int[] nums) {
        int product = 1;
        for(int num : nums){
            product *= num;
        }
        
        if(product >= 1){
            return 1;
        }else if(product <= -1){
            return -1;
        }else{
            return 0;
        }
    }
}