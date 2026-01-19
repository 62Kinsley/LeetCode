class Solution {
    public int arrangeCoins(int n) {

        long l=0, r=n;
        long res = n;
        while(l <= r){
            long mid = l + (r-l)/2;//2

            long coinsNum = (mid*(mid+1))/2;

            if(coinsNum > n){
                r = mid - 1; 
            }else{
                res = mid;
                l = mid+1;
                
            }
        }
        return (int)res;

        
    }
}