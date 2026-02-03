// class Solution {
//     public int removeDuplicates(int[] nums) {
        
//         //这道题不允许重新 new 一个nums来存，要在原来的nums上面操作
//         //所以要用快慢指针做
        
//         int slow = 0, fast = 1;

//         while(fast<nums.length){
//             if(nums[fast] != nums[slow]){
//                 slow++;
//                 nums[slow] = nums[fast];
//             }
//             fast++;
//         }
//         return slow+1;
//     }
// }
//  l
// [0,0,1,1,1,2,2,3,3,4]
//     r
class Solution{
    public int removeDuplicates(int[] nums) {
        int l=0, r=0;
        int n = nums.length;

        while(r < n){
            if(nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];  
            }
            r++;
            
        }
        return l+1;
    }
}

