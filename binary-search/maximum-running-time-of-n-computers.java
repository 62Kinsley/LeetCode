class Solution {
    public long maxRunTime(int n, int[] batteries) {

        int sum = 0;
        for(int x : batteries){
            sum += x;
        }

        int l=0, r = sum/n;
        while(l < r){
            int mid = l + (r-l) / 2;
            int estimatedTotal = check(batteries, mid);
            if(mid*n >  estimatedTotal ){//预期的target太大了
                    r = mid;
            }else{//target*n <=  estimatedTotal, 
                l = mid+1;
            }
        }
        return l;
        
    }


    private int check(int[] batteries, int target){
            int total = 0;

            for(int battery : batteries){
                total += Math.min(battery, target);//
            }
            return total;
    }
}



