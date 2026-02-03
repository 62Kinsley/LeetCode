class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int n = nums.length;
        int l=0, r=0;
        int prod = 1;
        int res = 0;

        while(r < n){
            prod *= nums[r];
            while(l<=r && prod >= 100){
                prod /= nums[l];
                l++;
            }
            res += (r-l+1);
            r++;
        }
        return res;
    }
}