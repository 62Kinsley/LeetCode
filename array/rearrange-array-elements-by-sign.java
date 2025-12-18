class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = nums.length -1;
        int[] res = new int[n];
        int i=0, j=nums.length -1;  
        
    //                l             
    //     [3,1,-2,-5,2,-4]
    //        r

    //                i
    //     [3,-2,1,-5, 2 -4]
    //   j
        while(i < n-1 || j>0){
            if(nums[l] > 0){
                res[i] = nums[l];
                i+=2;
            }
            l++;
            

            if(nums[r] < 0){
                res[j] = nums[r];
                j-=2;
            }
            r--;
            
        }
        return res;
       
    }
}


