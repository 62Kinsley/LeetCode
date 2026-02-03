//https://leetcode.cn/problems/product-of-array-except-self/solutions/272369/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/

//这道题不能用除法 without using the division operation.

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         //这道题其实相当于把当前数字前面的乘积算出来， 再把后面的乘积算出来；
//         //因为前面的乘积是有规律的，可以分为左边
//         //后面的乘积也是有规律的，可以分为右边
//         //当对应的左边和右边都算出来以后，直接想乘，得到当前数左右两边的乘积，就是答案

//         int n = nums.length;//n=4
//         //创建四个数字每个数字左边的乘积的数组
//         int[] L = new int[n];
//         //创建四个数字每个数字右边边的乘积的数组
//         int[] R = new int[n];
//         int[] res = new int[n];

//         L[0] = 1;
//         for(int i=1; i<n; i++){
//             L[i] = L[i-1] * nums[i-1];
//         }

//         R[n-1] = 1;//R[nums.length - 1]
//         for(int j=n-2; j>=0 ; j--){
//             R[j] = R[j+1] * nums[j+1];
//         }

//         for(int i=0; i<n; i++){
//             res[i] = L[i] * R[i];
//         }

//         return res;


//     }
// }
//time: O(N)
//space: O(N)



class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int res[] =  new int[n];

        int[] leftProduct = new int[n];
        leftProduct[0] = nums[0] * 1;

        int[] rightProduct = new int[n];
        rightProduct[n-1] = nums[n-1] * 1;

        for(int i=1; i<n; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        for(int i=n-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i];
        }

        for(int i=1; i<n-1; i++){
            res[i] =  leftProduct[i-1] * rightProduct[i+1];
        }
        res[0] = rightProduct[1];
        res[n-1] = leftProduct[n-2];
        return res;

    }
}

