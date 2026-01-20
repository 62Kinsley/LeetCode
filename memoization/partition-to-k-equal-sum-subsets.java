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
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if(sum%k!=0) return false;
        int a=sum/k;
        // Arrays.sort(nums);
        boolean[] b=new boolean[nums.length];
        return isTrue(nums,k,a,0,b,0);
    }
    public boolean isTrue(int[] a,int k,int tar,int i,boolean[] b,int curr){
        if(k==1){
            return true;
        }
        if(curr==tar){
            return isTrue(a,k-1,tar,0,b,0);
        }
        for(int j=i;j<a.length;j++){
            if(b[j]) continue;
            if(curr+a[j]>tar) continue;
            b[j]=true;
            if(isTrue(a,k,tar,j+1,b,curr+a[j])) return true;
            b[j]=false;
            if(curr==0){
                break;
            }
        }
        return false;
    }
}