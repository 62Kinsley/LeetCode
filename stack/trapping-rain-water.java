// class Solution {
//     public int trap(int[] height) {
//         //这道不建议用monotonic stack的原因是 monotonic stack更适用于找到下/上一个比它大/小的元素
//         //但这道题我们更希望找到的是 右边/左边 比自己大，且是最大的元素，那就未必是下/上一个， 有可能是下下下个，上上个
//         //所以这里我们用双指针就好了，左指针找左边最大的， 右指针找右边最大的，分别找

//         int n = height.length;
//         int [] maxLeft = new int[n];
//         int [] maxRight = new int[n];

//         maxRight[n-1] = height[n-1];
//         for(int i=n-2; i>=0; i--){
//             maxRight[i] = Math.max(height[i], maxRight[i+1]);
           
//         }


//          maxLeft[0] = height[0];
//         for(int j=1; j<n-1; j++){
//            maxLeft[j] = Math.max(height[j], maxLeft[j-1]);    
//         }

//         int sum = 0;
//         for(int i=1; i<=n-2; i++){
//             if( maxLeft[i]>height[i] && maxRight[i]>height[i]){
//                 sum += Math.min(maxLeft[i],maxRight[i]) - height[i];
//             }
//         }

//         return sum;


        
//     }
// }
  


class Solution{
    public int trap(int[] height) {
        int n = height.length;
        int [] maxLeft = new int[n];
        int [] maxRight = new int[n];

        maxLeft[0] = height[0];
        for(int i=1; i<n-1; i++){
          maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }

        maxRight[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
           maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }

        int res = 0;

        for(int i=0; i<n-1; i++){
            res += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
        
    }
}










