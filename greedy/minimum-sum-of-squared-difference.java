class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
		//edge case: when k1+k2 = 0 return the differentce
        int n = nums1.length;
        int[] diffTimes = new int[100001];//0-10000, index:diff value:times
        int maxDiff = 0;
        long k = k1+k2;

        for(int i=0; i<n; i++){
            int curDiff = Math.abs(nums1[i] - nums2[i]);
            diffTimes[curDiff]++;
            if(curDiff > maxDiff){
                maxDiff = curDiff;
            }
        }

        for(int i=maxDiff; i>0&& k>0; i--){
            if(k >= diffTimes[i]){
                k -= diffTimes[i];
                diffTimes[i-1] += diffTimes[i];
                diffTimes[i] = 0;
            }else{//k < diffTimes[i]
                diffTimes[i-1] += k;
                diffTimes[i] -= k;
                k = 0;
            }
        }

        long res = 0;
        for(int i=maxDiff; i>0; i--){
            if(diffTimes[i] > 0){
                res += diffTimes[i]* i * i;
            }  
        }
        return res;
    }
}



