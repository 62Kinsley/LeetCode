class Solution {
    long MOD = 1000000007;
    public int maxProfit(int[] inventory, int orders) {
       
        int max = 0;
        for(int x : inventory){
            max = Math.max(max, x);
        }

        int l = 0;
        int  r = max;
        int target = 0;
        while(l < r){
            int mid = l+(r-l)/2;
            if(check(inventory, mid) < orders){
                target = mid;
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        long totalProfit = 0;
        long count = 0;
        for (int num : inventory) {
            if (num > target) {
                long n = num - target;
                totalProfit = (totalProfit + (long)(target + 1 + num)* n /2) % MOD;
                count += n;
            }
        }
        long remainingOrders = orders - count;
        totalProfit = (totalProfit + remainingOrders * target) % MOD;
        return (int) totalProfit;
    }

/// 辅助函数：计算如果价格阈值为 mid，我们要卖多少个球
    private long check(int[] inventory, int mid) {
        long sum = 0;
        for (int num : inventory) {
            if (num > mid) {
                sum += (num - mid);
            }
        }
        return sum;
    }
}

