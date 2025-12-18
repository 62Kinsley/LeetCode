class Solution {
    public long maxRunTime(int n, int[] batteries) {

        long sum = 0;
        for(int x : batteries){
            sum += x;
        }

        long l=0, r = sum/n;
        while(l < r){
            long mid = l + (r-l) / 2;
            long estimatedTotal = check(batteries, mid);
            if((long)mid*n >=  estimatedTotal ){//预期的target太大了
                    r = mid;
            }else{//target*n <=  estimatedTotal, 
                l = mid+1;
            }
        }
        return r;
        
    }


    private long check(int[] batteries, long target){
            int total = 0;

            for(int battery : batteries){
                total += Math.min(battery, target);//
            }
            return total;
    }
}



