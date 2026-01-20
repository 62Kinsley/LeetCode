class Solution {
       //1.calculate the sum of nums
        //2.calculate the sum of every subsets
        //if sum of every subsets is != Integer (sum % k != 0)
        //such as: example2 10/3 != integer
        //return false;
        //sort nums: [1,2,2,3,3,4,5]
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;//12
        for(int num : nums){
            sum += num;
        }

        if(sum % k != 0){
            return false;
        }

        int need = sum / k; 
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        return backTracking(nums, 0, visited, 0, need, 0, k);
        

    }

    public boolean backTracking(int[] nums, int startIndex, boolean[] visited, int curSum, int target, int count, int k ){
        
        //termination condition: handle all element
        if(count == k){
            return true;
        }
        if(curSum == target){
            count++;//4
            return backTracking(nums, 0, visited, 0, target, count, k);
        }
        //  0 1 2 3 4 5 6
        // [4,3,2,3,5,2,1]
        // [t f f f f f t]

        for(int i=startIndex; i<nums.length; i++){//1
            if(visited[i]){
                continue;
            }
            if(curSum + nums[i] > target){//6
                continue;
            }
            visited[i] = true;
            if(backTracking(nums, i+1, visited, curSum+nums[i], target, count, k)){//1, 4,5, 0,4
                return true;
            }
            visited[i] = false;//回溯
            while(i+1< nums.length && nums[i+1] == nums[i]){
                i++;
            }
        }
        return false;


    }
}



