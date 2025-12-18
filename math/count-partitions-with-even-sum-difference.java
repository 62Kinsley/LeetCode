class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;

        for(int num : nums){
            right += num;
        }

        for(int i=0; i<n-1; i++){
            left += nums[i];
            right -= nums[i];

            if((left - right) %2 == 0){
                res++;
            }
        }

        return res;

        
    }
}