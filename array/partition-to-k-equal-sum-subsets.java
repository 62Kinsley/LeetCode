// class Solution {
//        //1.calculate the sum of nums
//         //2.calculate the sum of every subsets
//         //if sum of every subsets is != Integer (sum % k != 0)
//         //such as: example2 10/3 != integer
//         //return false;
//         //sort nums: [1,2,2,3,3,4,5]
//     public boolean canPartitionKSubsets(int[] nums, int k) {
        
//         int sum = 0;//12
//         for(int num : nums){
//             sum += num;
//         }

//         if(sum % k != 0){
//             return false;
//         }

//         int need = sum / k; 
//         int n = nums.length;
//         boolean[] visited = new boolean[n];
//         Arrays.sort(nums);
//         return backTracking(nums, need, 0, 0);
        

//     }

//     public boolean backTracking(int[] nums, int target, int sum, int count, boolean[] visited){
        
//          //termination condition: handle all element
//          if(index == nums.length){

//          }

//          for(int i=0; i<)



//     }
// }

class Solution {
    private boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) return true;
        if (cur == target) {
            // 构建下一个集合
            return backtracking(nums, k-1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur+nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, k, target, cur+nums[i], i+1, used)) return true;
                used[i] = false;
            }
        }
        return false;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum/k) return false;
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum/k, 0, 0, used);
    }
}
