class Solution {
    public int arrangeCoins(int n) {

        int l=0, r=n;
        int res = n;
        while(l <= r){
            int mid = l + (r-l)/2;//2

            long coinsNum = (long)(mid*(mid+1))/2;

            if(coinsNum > n){
                r = mid - 1; 
            }else{
                res = mid;
                l = mid+1;
                
            }
        }
        return res;

        
    }
}