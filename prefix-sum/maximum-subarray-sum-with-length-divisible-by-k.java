// class Solution {
//     public long maxSubarraySum(int[] nums, int k) {
        
//         //1.prefix sum
//         //[-5, 1, 2, -3,  4]
// //prefix   0  -5,-4, -2, -5, -1
// // /只有当两个前缀和的索引对 k 取余相同时，它们的差才代表一个长度被 k 整除的子数组。
// //r-l+1 % k == 0?  -> r+1 % k == l%k
// //4+1 % 4 == 1%4
//         int n = nums.length;
//         long[] prefix = new long[n+1];
    
//         for(int i=1; i<=n; i++){
//             prefix[i] = prefix[i-1] + nums[i-1];
        
//         }

//         long ans = Long.MIN_VALUE;
//         long[] minPrefix = new long[k];//因为余数最多不会超过k
//         Arrays.fill(minPrefix, Long.MAX_VALUE/2);

//         for(int j=0; j<=n; j++){
//             int mod = j % k;//1%4=1, 5%4=1, 9%4=1
//             minPrefix[mod] =  Math.min(minPrefix[mod], prefix[j]);
//             ans = Math.max(prefix[j] - minPrefix[mod], ans);
//         }

//         return ans;
      
//     }
// }

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        long[] minS = new long[k];
        Arrays.fill(minS, Long.MAX_VALUE / 2); // 防止下面减法溢出

        long ans = Long.MIN_VALUE;
        for (int j = 0; j < sum.length; j++) {
            int i = j % k;
            ans = Math.max(ans, sum[j] - minS[i]);
            minS[i] = Math.min(minS[i], sum[j]);
        }
        return ans;
    }
}


