class Solution {
    public int maxProfit(int[] prices) {
            int l=0, r=0;
            int res = 0;
            while(r < prices.length){
                if(prices[l] <= prices[r]){
                    res = Math.max(res, prices[r]-prices[l]);
                }else{
                    l = r;
                }
                r++;
            }
            return res;
    }
}

// time:O(N)
// space:O(1);

//需要clarify的问题： 1.是否只有一次 transaction  2.买卖是否能在同一天进行，还是不行
// class Solution { 

//     public int maxProfit(int[] prices) {
//          // dp[i][0]代表第i天持有股票的最大收益(第i天买 或者第i天前就持有)，
//         // dp[i][1]代表第i天不持有股票的最大收益((第i天卖掉 或者第i天本来就没有)，)
//         //这里只能交易一次

//         int n = prices.length;
//         int[][] dp = new int[n][2];

//         dp[0][0] = -prices[0];//第0天持有的最大收益
//         int res = 0;

//         for(int i=1; i<n; i++){
//             dp[i][0] = Math.max(dp[i-1][0], -prices[i]);// -prices[i]是因为只有一次交易，前面没有买和卖
//             dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i-1][0]);
            
//         }

//         return dp[n-1][1];


//     }
//  }
                    
// dp[5][0] 第i天持有(1. 5之前就持有 2.第5天持有)  Math.max(dp[i-1][0], dp[i-1][1]-price[i])
// dp[i][1] 第i天不持有（dp[i-1][1], dp[i-1][0]+price[i]）


// class Solution{
//     public int maxProfit(int[] prices){
//         // dp[i][0] : the max profit of from 0-i day hold this stock 
//         // dp[i][1]: the max profit of from 0-i day not hold this stock 
//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         dp[0][0] = -prices[0];
//         dp[0][1] = 0;

//         for(int i=1; i<n; i++){
//             dp[i][0] = Math.max(dp[i-1][0], -prices[i]);//0-(i-1) day hold, vs hold today
//             dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
//         }
//         return dp[n-1][1];
//     }
// }
