// class Solution {
//     public int arraySign(int[] nums) {
//         int product = 1;
//         for(int num : nums){
//             if(num == 0){
//                 return 0;
//             }
//             if(num < 0){
//                 product *= -1;
//             }
//              if(num > 0){
//                 product *= 1;
//             }  
//         }
//         return product;
      

//     }
// }

class Solution {
    public int arraySign(int[] nums) {
        int negCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                return 0;
            }
            if(nums[i]<0){
                negCount++;
            }
        }
        if(negCount%2==0){
            return 1;
        }else{
            return -1;
        }

        
    }

}