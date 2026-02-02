// //greedy
// class Solution {
//     public int maxSubArray(int[] nums) {
        
//         if(nums.length == 1){
//             return nums[0];
//         }
//         int sum = 0;
//         int res = Integer.MIN_VALUE;
//         for(int i=0; i<nums.length; i++){
//             sum += nums[i];
//             // if(sum > res){
//             //     res = sum;
//             // }

//             res = Math.max(res, sum);//这个顺序要在先

//             if(sum < 0){//然后再判断大小 这个顺序要在后
//                 sum = 0;
//             } 

//         }

//         return res;
//     }
// }



// [-2,1, -3,4,-1,2,1,-5,4]
//  -2 1  -2 4  3 5 6 1  5

class Solution{
    public int maxSubArray(int[] nums){
        int res = nums[0];
        int count = nums[0];
        for(int num : nums){
            count += num;//3
            if(count < 0){
                count = 0;//0
            }
            res = Math.max(res, count);
        }
        return res;
    }
}