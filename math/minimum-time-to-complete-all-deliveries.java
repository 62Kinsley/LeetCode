//mid : 7
//:d = [3,1]
//r = [2,3]
class Solution {
    public long minimumTime(int[] d, int[] r) {
        long l = 0;
        long temp = ((long)d[0] + (long)d[1]) * (long)Math.max(r[0], r[1]);
        long h = Math.max(100L, temp);
        while(l <= h){
            long mid = l + (h-l)/2;
            // first drone can finish x1 task:
            long x1 = mid - (mid / r[0]);//7-3 = 4 [1,3,5,7]
            long x2 = mid - (mid / r[1]);//7-2 = 5 [1,2,4,5,7]

            //overlap task:
            long gcdd = gcd(r[0], r[1]);//2和3的最大公约数
            long lcm = (r[0] / gcdd )* (long)r[1];
            long x3 = mid - (mid / r[0]+  mid / r[1] - mid / lcm);  //7- 4 = 3 [1,5,7]
            long canFinish = x1+x2-x3 ;//= (x1-x3) + (x2-x3) + x3 
            if( x1 >= d[0] && x2 >= d[1]  && x1+x2-x3 >= d[0]+d[1]){
                h = mid - 1;
            }else{
                l = mid+1;
            }
        }

        return l;
        
    }
    private long gcd(long a, long b) {//2,3
        while (b != 0) {
            long t = a % b;//3%3=0
            a = b;//2
            b = t;//0
        }
        return a;
    }
}

