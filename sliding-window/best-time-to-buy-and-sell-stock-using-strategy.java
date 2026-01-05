class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        
        int originProfit = 0;
        int profit  = 0;
        int half = k/2; //1
        int n = prices.length;

        for(int i=0; i<n; i++){
              originProfit += prices[i]*strategy[i];//算出Originalprofit:4
        }
        int maxProfit = originProfit;//4

        for(int i=half; i<k; i++){
              profit +=  prices[i];  //从中间开始算 
        }

        for(int i=k; i<prices.length; i++){
            profit += prices[i] * strategy[i];   
        }

        maxProfit = Math.max(maxProfit, profit);

      
        for(int i=1; i<=n-k; i++){
            profit += prices[i-1] * strategy[i-1];
            profit -= prices[i+half-1] * strategy[i+half-1];
            if(strategy[i+k-1] == 0){
                profit += prices[i+k-1];
            }
            if(strategy[i+k-1] == -1){
                profit += 2*prices[i+k-1];
            }

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}