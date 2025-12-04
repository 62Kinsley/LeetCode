// class Solution {
//     public int arrayPairSum(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         int res = 0;
//         for(int i=0; i<n; i+=2){
            
//             res += nums[i];
//         }

//         return res;
//     }
// }

class Solution {
    public int arrayPairSum(int[] nums) {
        int[] bucket = new int[20001];

        for(int num : nums){
            bucket[num+10000]++;
        }
        int res = 0;
        boolean add = true;
        for(int i=0; i<=20000; i++){
            while(bucket[i] > 0){
                if(add){
                    res +=(i- 10000);//1+2
                }
                add = !add;//t
                bucket[i]--;//
            }
        }
        return res;

    }
}