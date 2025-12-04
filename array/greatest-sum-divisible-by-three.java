// class Solution {
//     public int maxSumDivThree(int[] nums) {
//         //1.cal the sum of nums
//         //sum % 3 = ?
//         //contains 余数，就去掉，没有得 return 0

//         int sum = 0;
//         // int res = 0;
//         HashSet<Integer> set = new HashSet<>();
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int num: nums){
//             sum += num;
//             set.add(num);//23
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }

//         if(sum % 3 == 0){
//             return sum;
//         } 
//         int mod = sum % 3; //2
//         int carry = sum / 3;//7
//         if(set.contains(mod)){
//             return sum - mod;
//         }

//         for(int i=carry-1; i>0; i--){
//             int need = sum - i*3;
//             if(set.contains(need)){
//                 return i*3;
//             }
//         }
//         return 0;


//     }
// }

// [1,2,3,4,4]:
class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];  //0,1,2
        int sum = 0;
        for (int num : nums) { //1
            int[] current = dp.clone(); 
            for(int i=0; i<3; i++){//
                int newsum = current[i] + num;//1+1
                int reminder = newsum % 3;//
                dp[reminder] = Math.max(dp[reminder], newsum);
            }
            
        }
        return dp[0];
    }
      


}