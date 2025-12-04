class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i=0; i<n; i++){
            if(i % 2 == 0){
                 res += nums[i];
            }
           
        }

        return res;
    }
}

// 1,2, 3,4
// 6,2, 6,5, 1,2

// [1,2, 2,5, 6,6]:
