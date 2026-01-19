class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        //1.calculate the sum of nums
        //2.calculate the sum of every subsets
        //if sum of every subsets is != Integer (sum % k != 0)
        //such as: example2 10/3 != integer
        //return false;
        //sort nums: [1,2,2,3,3,4,5]

        //ues two pointer, l=0, r=n-1
        //create a boolean array the visted:[] to record which element is visited
        // check  boolean array the visted[], if there is element is false, return false, or return true

        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % k != 0){
            return false;
        }

        int need = sum / k; 
        Arrays.sort(nums);
        int n = nums.length;
        int l=0, r=n-1;
        boolean visited[] = new boolean[n];
        //      l
        //  0 1 2 3 4 5 6
        //        r
        // [1,2,2,3,3,4,5]
        // [t t t t t t t]
        while(l < r){
            if(nums[l] + nums[r] == need){
                visited[l] = true;
                visited[r] = true;
                l++;
                r--;
            }else if(nums[l] + nums[r] > need){
                r--;
            }else{
                return false;
            }
        }

        for(int i=n-1; i>=0; i--){
            if(!visited[i]){
                if(nums[i] == need){
                    visited[i] = true;
                }else{
                    return false;
                }
            }
        }
       
        return true;

    }
}