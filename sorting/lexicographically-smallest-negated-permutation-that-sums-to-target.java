class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        //edge case：
    
        int sum  = (n+1)*n/2;      
        if(sum < target){
            return new int[0];
        }
        if(-sum > target){
            return new int[0];
        }
        if((sum - target)%2 == 1){
            return new int[0];
        }
      

        long d = (sum - target);
        int[] res = new int[n];
        int l=0, r=n-1;
       
        for(int x=n; x>=1; x--){
            if(d >= 2*x){
                d -= 2*x;
                res[l] = -x;
                l++;
            }else{
                res[r] = x;
                r--;
            }
        }

        return res;

    }
}